package com.BlueSpectre.BlueManeger.Infra.Gateway;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BlueSpectre.BlueManeger.Core.Domain.ProdutoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.ProdutoGateway;
import com.BlueSpectre.BlueManeger.Infra.Mapper.Produto.ProdutoMapper;
import com.BlueSpectre.BlueManeger.Infra.Persistence.ProdutoPercistence;
import com.BlueSpectre.BlueManeger.Infra.Persistence.Entities.ProdutoEntity;

@Service
public class ProdutoInfraGateway implements ProdutoGateway {

    private final ProdutoPercistence produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoInfraGateway(ProdutoPercistence produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }   
    @Override
    public Optional<ProdutoDomain> getProdutoByID(Long id) {
        return produtoRepository.findById(id).map(produtoMapper::entityToDomain);
    }
    @Override
    public Optional<ProdutoDomain> getProdutoByNome(String nomeProduto) {
        return produtoRepository.findByNomeProduto(nomeProduto).map(produtoMapper::entityToDomain);
    }
    @Override
    public List<ProdutoDomain> getProdutoByDate(LocalDate date) {
        return produtoRepository.findByValidadeProduto(date).stream().map(produtoMapper::entityToDomain).toList();
    }
    @Override
    public List<ProdutoDomain> getProduto() {
        return produtoRepository.findAll().stream().map(produtoMapper::entityToDomain).toList();
    }
    @Override
    public ProdutoDomain newProduto(ProdutoDomain produtoModel) {
        ProdutoEntity produtoEntity = produtoMapper.toEntity(produtoModel);
        ProdutoEntity savedEntity = produtoRepository.save(produtoEntity);
        return produtoMapper.entityToDomain(savedEntity);
    }
    @Override
    public ProdutoDomain alterarProduto(ProdutoDomain produto, Long id) {
        ProdutoEntity produtoEntity = produtoMapper.toEntity(produto);
        produtoRepository.updateProduto(produtoEntity, id);
        return produtoMapper.entityToDomain(produtoEntity);
    }
    @Override
    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}