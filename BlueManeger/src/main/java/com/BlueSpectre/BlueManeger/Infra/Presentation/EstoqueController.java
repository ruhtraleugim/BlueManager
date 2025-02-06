package com.BlueSpectre.BlueManeger.Infra.Presentation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BlueSpectre.BlueManeger.Core.Domain.EstoqueDomain;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.AlterarUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorDataUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.CriarUseCase;
import com.BlueSpectre.BlueManeger.Infra.Dto.EstoqueDTO;
import com.BlueSpectre.BlueManeger.Infra.Mapper.Estoque.EstoqueMapper;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/Estoque")
public class EstoqueController implements ControllerInterface<EstoqueDTO>{

    private final EstoqueMapper estoqueMapper;
    private final AlterarUserCase<EstoqueDomain> alterar;
    private final BuscarUseCase<EstoqueDomain> buscar;
    private final BuscarPorDataUseCase<EstoqueDomain> buscarPorData;
    private final CriarUseCase<EstoqueDomain> criar;

    public EstoqueController( AlterarUserCase<EstoqueDomain> alterar, BuscarUseCase<EstoqueDomain> buscar,
                             BuscarPorDataUseCase<EstoqueDomain> buscarPorData,
                            CriarUseCase<EstoqueDomain> criar, EstoqueMapper estoqueMapper) {
        this.estoqueMapper = estoqueMapper;
        this.alterar = alterar;
        this.buscar = buscar;
        this.buscarPorData = buscarPorData;
        this.criar = criar;
    }

    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<?> alterarEntity(@RequestBody EstoqueDTO c,@PathVariable Long id) {
        EstoqueDomain domain = estoqueMapper.toDomain(c);
        alterar.execute(id, domain);
        EstoqueDTO dto = estoqueMapper.toDto(domain);   
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("buscar")
    @Override
    public List<EstoqueDTO> buscarEntity() {
        return buscar.execute().stream().map(estoqueMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("buscar/{id}")
    @Override
    public ResponseEntity<EstoqueDTO> buscarEntityPorId(@PathVariable Long id) {
        throw new UnsupportedOperationException("Unimplemented method ");
    }

    @GetMapping("buscar/{data}")
    public List<EstoqueDTO> buscarEntityPorData(@PathVariable LocalDate data) {
        return buscarPorData.execute(data).stream().map(estoqueMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping("criar")
    @Override
    public ResponseEntity<?> criarEntity(@RequestBody EstoqueDTO c) {
        EstoqueDomain domain = estoqueMapper.toDomain(c);
        criar.execute(domain);
        EstoqueDTO dto = estoqueMapper.toDto(domain);
        return ResponseEntity.ok().body(dto); 
    }

    @Override
    public ResponseEntity<?> deletarEntity(@PathVariable Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unsupported method for this entity : 'deleteEntity'");
    }
}