package com.BlueSpectre.BlueManeger.Infra.Presentation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BlueSpectre.BlueManeger.Core.Domain.ProdutoDomain;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.AlterarUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorIDUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.CriarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.DeleteUsecase;
import com.BlueSpectre.BlueManeger.Infra.Dto.ProdutoDTO;
import com.BlueSpectre.BlueManeger.Infra.Mapper.Produto.ProdutoMapper;

@RestController
@RequestMapping("/Produto")
public class ProdutoController implements ControllerInterface<ProdutoDTO> {

    private final ProdutoMapper produtoMapper;
    private final AlterarUserCase<ProdutoDomain> alterar;
    private final BuscarUseCase<ProdutoDomain> buscar;
    private final BuscarPorIDUserCase<ProdutoDomain> buscarPorId;
    private final CriarUseCase<ProdutoDomain> criar;
    private final DeleteUsecase delete;

    public ProdutoController(ProdutoMapper produtoMapper, AlterarUserCase<ProdutoDomain> alterar,
            BuscarUseCase<ProdutoDomain> buscar, BuscarPorIDUserCase<ProdutoDomain> buscarPorId,
            CriarUseCase<ProdutoDomain> criar, DeleteUsecase delete) {
        this.produtoMapper = produtoMapper;
        this.alterar = alterar;
        this.buscar = buscar;
        this.buscarPorId = buscarPorId;
        this.criar = criar;
        this.delete = delete;
    }
    @PutMapping("alterar/{id}")
    @Override
    public ResponseEntity<?> alterarEntity(@RequestBody ProdutoDTO c,@PathVariable Long id) {
        ProdutoDomain domain = produtoMapper.toDomain(c);
        alterar.execute(id, domain);
        ProdutoDTO dto = produtoMapper.toDto(domain);
        return ResponseEntity.ok().body(dto);
    }
    @GetMapping("buscar")
    @Override
    public List<ProdutoDTO> buscarEntity() {
        return buscar.execute().stream().map(produtoMapper::toDto).toList();
    }
    @GetMapping("buscarPorId/{id}")
    @Override
    public ResponseEntity<ProdutoDTO> buscarEntityPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoMapper.toDto(buscarPorId.execute(id).get()));
    }
    @PostMapping("criar")
    @Override
    public ResponseEntity<?> criarEntity(@RequestBody ProdutoDTO c) {
        ProdutoDomain domain = produtoMapper.toDomain(c);
        criar.execute(domain); 
        ProdutoDTO dto = produtoMapper.toDto(domain);
        return ResponseEntity.ok().body(dto);
    }
    @DeleteMapping("deletar/{id}")
    @Override
    public ResponseEntity<?> deletarEntity(@PathVariable Long id) {
        delete.execute(id);
        return ResponseEntity.ok().body("Entity deleted with sucess");
    }
}