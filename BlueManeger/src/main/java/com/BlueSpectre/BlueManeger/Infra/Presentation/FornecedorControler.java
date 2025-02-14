package com.BlueSpectre.BlueManeger.Infra.Presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BlueSpectre.BlueManeger.Core.Domain.FornecedorDomain;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.AlterarUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorIDUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorNomeUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.CriarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.DeleteUsecase;
import com.BlueSpectre.BlueManeger.Infra.Dto.FornecedorDTO;
import com.BlueSpectre.BlueManeger.Infra.Mapper.Fornecedor.FornecedorMapper;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/Fornecedor")
public class FornecedorControler implements ControllerInterface<FornecedorDTO>{
    
    private final FornecedorMapper fornecedorMapper;
    private final AlterarUserCase<FornecedorDomain> alterar;
    private final BuscarUseCase<FornecedorDomain> buscar;
    private final BuscarPorIDUserCase<FornecedorDomain> buscarPorID;
    private final BuscarPorNomeUseCase<FornecedorDomain> buscarPorNome;
    private final CriarUseCase<FornecedorDomain> criar;
    private final DeleteUsecase delete;

    public FornecedorControler(FornecedorMapper fornecedorMapper ,AlterarUserCase<FornecedorDomain> alterar, BuscarUseCase<FornecedorDomain> buscar, BuscarPorIDUserCase<FornecedorDomain> buscarPorID, BuscarPorNomeUseCase<FornecedorDomain> buscarPorNome,
            CriarUseCase<FornecedorDomain> criar, @Qualifier("deleteFornecedor")DeleteUsecase delete) {
        this.alterar = alterar;
        this.buscar = buscar;
        this.buscarPorID = buscarPorID;
        this.criar = criar;
        this.fornecedorMapper = fornecedorMapper;
        this.delete = delete;
        this.buscarPorNome = buscarPorNome;
    }

    @PutMapping("update/{id}")
    @Override
    public ResponseEntity<?> alterarEntity(FornecedorDTO c, Long id) {
        FornecedorDomain domain = fornecedorMapper.toDomain(c);
        alterar.execute(id, domain);
        FornecedorDTO dto = fornecedorMapper.toDto(domain);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("buscar")
    @Override
    public List<FornecedorDTO> buscarEntity() {
       return buscar.execute().stream().map(fornecedorMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("buscar/{id}")
    @Override
    public ResponseEntity<FornecedorDTO> buscarEntityPorId(Long id) {
       return ResponseEntity.ok().body(fornecedorMapper.toDto(buscarPorID.execute(id).get()));
    }

    @GetMapping("buscar/{nome}")
    public ResponseEntity<FornecedorDTO> buscarEntityPorNome(String nome) {
        return ResponseEntity.ok().body(fornecedorMapper.toDto(buscarPorNome.execute(nome).get()));
    }

    @PostMapping("criar")
    @Override
    public ResponseEntity<?> criarEntity(FornecedorDTO c) {
        FornecedorDomain domain = fornecedorMapper.toDomain(c);
        criar.execute(domain);
        FornecedorDTO dto = fornecedorMapper.toDto(domain);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("deletar/{id}")
    @Override
    public ResponseEntity<?> deletarEntity(Long id) {
        delete.execute(id);
        return ResponseEntity.ok().body("A entitade Foi devidamente excluida");
    }
}