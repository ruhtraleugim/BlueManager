package com.BlueSpectre.BlueManeger.Infra.Mapper.Produto;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.BlueSpectre.BlueManeger.Core.Domain.ProdutoDomain;
import com.BlueSpectre.BlueManeger.Infra.Dto.ProdutoDTO;
import com.BlueSpectre.BlueManeger.Infra.Mapper.MapperInteface;
import com.BlueSpectre.BlueManeger.Infra.Mapper.Fornecedor.FornecedorMapper;
import com.BlueSpectre.BlueManeger.Infra.Persistence.Entities.ProdutoEntity;

@Component
public class ProdutoMapper implements MapperInteface<ProdutoDomain, ProdutoDTO, ProdutoEntity> {
    
    private final FornecedorMapper fornecedorMapper;
    public ProdutoMapper(@Lazy FornecedorMapper fornecedorMapper){
        this.fornecedorMapper = fornecedorMapper;
    }
    @Override
    public ProdutoDomain toDomain(ProdutoDTO dto) {
        if (dto == null) {
            return null;
        }
        return new ProdutoDomain(dto.idProduto(),
                                dto.descricaoProduto(),
                                dto.nomeProduto(),
                                dto.validadeProduto(),
                                dto.tipoProduto(),
                                dto.valorProduto(),
                                fornecedorMapper.toDomain(dto.fornecedorDTO()));
    }
    @Override
    public ProdutoDTO toDto(ProdutoDomain domain) {
        if (domain == null) {
            return null;
        }
       return new ProdutoDTO(domain.idProduto(),
                            domain.descricaoProduto(),
                            domain.nomeProduto(),
                            domain.validadeProduto(),
                            domain.tipoProduto(),
                            domain.valorProduto(),
                            fornecedorMapper.toDto(domain.fornecedorDomain()));
    }
    @Override
    public ProdutoEntity toEntity(ProdutoDomain domain) {
        if (domain == null) {
            return null;
        }
        return new ProdutoEntity(domain.idProduto(),
                            domain.descricaoProduto(),
                            domain.nomeProduto(),
                            domain.validadeProduto(),
                            domain.tipoProduto(),
                            domain.valorProduto(),
                            fornecedorMapper.toEntity(domain.fornecedorDomain()));
    }

    @Override
    public ProdutoDomain entityToDomain(ProdutoEntity entity) {
        if (entity == null) {
            return null;
        }
        return new ProdutoDomain(entity.getIdProduto(),
                                entity.getDescricaoProduto(),
                                entity.getNomeProduto(),
                                entity.getValidadeProduto(),
                                entity.getTipoProduto(),
                                entity.getValorProduto(),
                                fornecedorMapper.entityToDomain(entity.getFornecedorEntity()));
    }
    @Override
    public ProdutoDTO entityToDto(ProdutoEntity entity) {
        if (entity == null) {
            return null;
        }
        return new ProdutoDTO(entity.getIdProduto(),
                                entity.getDescricaoProduto(),
                                entity.getNomeProduto(),
                                entity.getValidadeProduto(),
                                entity.getTipoProduto(),
                                entity.getValorProduto(),
                                fornecedorMapper.entityToDto(entity.getFornecedorEntity()));
    }
}