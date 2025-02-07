package com.BlueSpectre.BlueManeger.Infra.Presentation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BlueSpectre.BlueManeger.Core.Domain.RelatorioDomain;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.AlterarUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorDataUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.CriarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.DeleteUsecase;
import com.BlueSpectre.BlueManeger.Infra.Dto.RelatorioDTO;
import com.BlueSpectre.BlueManeger.Infra.Mapper.Relatorio.RelatorioMapper;

@RestController
@RequestMapping("/Relatorio")
public class RelatorioController implements ControllerInterface<RelatorioDTO>{

    private final RelatorioMapper relatorioMapper;
    private final AlterarUserCase<RelatorioDomain> alterar;
    private final BuscarUseCase<RelatorioDomain> buscar;
    private final BuscarPorDataUseCase<RelatorioDomain> buscarPorData;
    private final CriarUseCase<RelatorioDomain> criar;
    private final DeleteUsecase delete;

    public RelatorioController(RelatorioMapper relatorioMapper, AlterarUserCase<RelatorioDomain> alterar,
            BuscarUseCase<RelatorioDomain> buscar, BuscarPorDataUseCase<RelatorioDomain> buscarPorData,
            CriarUseCase<RelatorioDomain> criar, DeleteUsecase delete) {
        this.relatorioMapper = relatorioMapper;
        this.alterar = alterar;
        this.buscar = buscar;
        this.buscarPorData = buscarPorData;
        this.criar = criar;
        this.delete = delete;
    }
    
    @Override
    public ResponseEntity<?> alterarEntity(RelatorioDTO c, Long id) {
        alterar.execute(id, relatorioMapper.toDomain(c));
        return ResponseEntity.ok().body("A entidade Foi alterada com exito");
    }

    @GetMapping("/buscar")
    @Override
    public List<RelatorioDTO> buscarEntity() {
        return buscar.execute().stream().map(relatorioMapper::toDto).toList();
    }
    @GetMapping("/buscarPorData/{data}")
    public List<RelatorioDTO> buscarEntityPorData(LocalDate data) {
        return buscarPorData.execute(data).stream().map(relatorioMapper::toDto).toList();
    }
    
    @Override
    public ResponseEntity<RelatorioDTO> buscarEntityPorId(@PathVariable Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResponseEntity<?> criarEntity(RelatorioDTO c) {
        RelatorioDomain domain = relatorioMapper.toDomain(c);
        criar.execute(domain);
        RelatorioDTO dto = relatorioMapper.toDto(domain);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<?> deletarEntity(Long id) {
        delete.execute(id);
        return ResponseEntity.ok().body("A entidade Foi deletada com exito");
    }
}