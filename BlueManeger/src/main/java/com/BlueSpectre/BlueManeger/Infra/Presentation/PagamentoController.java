package com.BlueSpectre.BlueManeger.Infra.Presentation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BlueSpectre.BlueManeger.Core.Domain.PagamentoDomain;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.AlterarUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorDataUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorIDUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.CriarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.DeleteUsecase;
import com.BlueSpectre.BlueManeger.Infra.Dto.PagamentoDTO;
import com.BlueSpectre.BlueManeger.Infra.Mapper.Pagamento.PagamentoMapper;

@RestController
@RequestMapping("/Pagamento")
public class PagamentoController implements ControllerInterface<PagamentoDTO>{

    private final PagamentoMapper pagamentoMapper;
    private final AlterarUserCase<PagamentoDomain> alterar;
    private final CriarUseCase<PagamentoDomain> criar;
    private final BuscarUseCase<PagamentoDomain> buscar;
    private final BuscarPorIDUserCase<PagamentoDomain> buscarPorId;
    private final BuscarPorDataUseCase<PagamentoDomain> buscarPorData;
    private final DeleteUsecase delete;

    public PagamentoController(PagamentoMapper pagamentoMapper, AlterarUserCase<PagamentoDomain> alterar,
            CriarUseCase<PagamentoDomain> criar, BuscarUseCase<PagamentoDomain> buscar,
            BuscarPorIDUserCase<PagamentoDomain> buscarPorId, BuscarPorDataUseCase<PagamentoDomain> buscarPorData,
            @Qualifier("deletePagamento")DeleteUsecase delete) {
        this.pagamentoMapper = pagamentoMapper;
        this.alterar = alterar;
        this.criar = criar;
        this.buscar = buscar;
        this.buscarPorId = buscarPorId;
        this.buscarPorData = buscarPorData;
        this.delete = delete;
    }
    @PutMapping("alterar/{id}")
    @Override
    public ResponseEntity<?> alterarEntity(@RequestBody PagamentoDTO c,@PathVariable Long id) {
        PagamentoDomain pagamento = pagamentoMapper.toDomain(c);
        alterar.execute( id , pagamento);
        PagamentoDTO dto = pagamentoMapper.toDto(pagamento);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("buscar")
    @Override
    public List<PagamentoDTO> buscarEntity() {
        return buscar.execute().stream().map(pagamentoMapper::toDto).toList();
    }
    @GetMapping("buscaPorId/{id}")
    @Override
    public ResponseEntity<PagamentoDTO> buscarEntityPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pagamentoMapper.toDto(buscarPorId.execute(id).get()));
    }

    public List<PagamentoDTO> buscarEntityPorData(LocalDate data) {
        return buscarPorData.execute(data).stream().map(pagamentoMapper::toDto).toList();
    }

    @Override
    public ResponseEntity<?> criarEntity(@RequestBody PagamentoDTO c) {
        PagamentoDomain pagamento = pagamentoMapper.toDomain(c);
        criar.execute(pagamento);
        PagamentoDTO dto = pagamentoMapper.toDto(pagamento);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<?> deletarEntity(@PathVariable Long id) {
        delete.execute(id);
        return ResponseEntity.ok().body("A entidade Foi deletada com exito");
    }
}