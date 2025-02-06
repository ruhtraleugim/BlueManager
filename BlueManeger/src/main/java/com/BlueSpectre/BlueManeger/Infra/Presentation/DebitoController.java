package com.BlueSpectre.BlueManeger.Infra.Presentation;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BlueSpectre.BlueManeger.Core.Domain.DebitoDomain;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.AlterarUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorDataUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorIDUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.CriarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.DeleteUsecase;
import com.BlueSpectre.BlueManeger.Infra.Dto.DebitoDTO;
import com.BlueSpectre.BlueManeger.Infra.Mapper.Debito.DebitoMapper;


@RestController
@RequestMapping("/Debito")
public class DebitoController implements ControllerInterface<DebitoDTO> {

    private final DebitoMapper debitoMapper;
    private final AlterarUserCase<DebitoDomain> alterar;
    private final BuscarUseCase<DebitoDomain> buscar;
    private final BuscarPorIDUserCase<DebitoDomain> buscarPorID;
    private final BuscarPorDataUseCase<DebitoDomain> buscarPorData;
    private final CriarUseCase<DebitoDomain> criar;
    private final DeleteUsecase deletar;

    public DebitoController(DebitoMapper debitoMapper, AlterarUserCase<DebitoDomain> alterar, BuscarUseCase<DebitoDomain> buscar,
                            BuscarPorIDUserCase<DebitoDomain> buscarPorID, BuscarPorDataUseCase<DebitoDomain> buscarPorData,
                            CriarUseCase<DebitoDomain> criar, @Qualifier("deleteDebito") DeleteUsecase deletar) {
        this.debitoMapper = debitoMapper;
        this.alterar = alterar;
        this.buscar = buscar;
        this.buscarPorID = buscarPorID;
        this.buscarPorData = buscarPorData;
        this.criar = criar;
        this.deletar = deletar;
    }

    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<?> alterarEntity(@RequestBody DebitoDTO c,@PathVariable Long id) {
        alterar.execute(id,debitoMapper.toDomain(c));
        return ResponseEntity.ok().body("Entidade alterada");
    }
    
    @GetMapping("/buscar")
    @Override
    public List<DebitoDTO> buscarEntity() {
        return buscar.execute().stream().map(debitoMapper::toDto).collect(Collectors.toList());
    }
    
    @GetMapping("/buscarPorData/{date}")
    public List<DebitoDTO> buscarPorData(@PathVariable LocalDate date) {
        return buscarPorData.execute(date).stream().map(debitoMapper::toDto).collect(Collectors.toList());
    }  

    @GetMapping("/buscarPorID/{id}")
    @Override
    public ResponseEntity<DebitoDTO> buscarEntityPorId(@PathVariable Long id) {
        DebitoDTO dto = debitoMapper.toDto(buscarPorID.execute(id).get());
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/criar")
    @Override
    public ResponseEntity<DebitoDTO> criarEntity(@RequestBody DebitoDTO c) {
        DebitoDomain domain = debitoMapper.toDomain(c);
        criar.execute(domain);
        DebitoDTO dto = debitoMapper.toDto(domain);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<?> deletarEntity(@PathVariable Long id) {
        deletar.execute(id);
        return ResponseEntity.ok().body("Entidade Deletada com sucesso");
    }
}