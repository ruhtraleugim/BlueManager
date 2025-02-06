package com.BlueSpectre.BlueManeger.Infra.Mapper.Fornecedor;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.BlueSpectre.BlueManeger.Core.Domain.FornecedorDomain;
import com.BlueSpectre.BlueManeger.Infra.Dto.FornecedorDTO;
import com.BlueSpectre.BlueManeger.Infra.Mapper.MapperInteface;
import com.BlueSpectre.BlueManeger.Infra.Mapper.Produto.ProdutoMapper;
import com.BlueSpectre.BlueManeger.Infra.Persistence.Entities.FornecedorEntity;


@Component
public class FornecedorMapper implements MapperInteface<FornecedorDomain, FornecedorDTO, FornecedorEntity>{
    
    private final ProdutoMapper produtoMapper;
    
    public FornecedorMapper(@Lazy ProdutoMapper produtoMapper){
        this.produtoMapper = produtoMapper;
    }
    @Override
    public FornecedorDomain toDomain(FornecedorDTO dto) {
        if (dto == null){
            return null;
        }
        return new FornecedorDomain(dto.id(),
                                    dto.valorProdutoFornecedor(),
                                    dto.fornecedorEndereco(),
                                    dto.fornecedorNome(),
                                    dto.fornecedorTelefone(),
                                    dto.fornecedorEmail(),
                                    dto.tipoProduto(),
                                    produtoMapper.toDomain(dto.produtoDTO()));

    }
    @Override
    public FornecedorDTO toDto(FornecedorDomain domain) {
        if (domain == null){
            return null;
        }
        return new FornecedorDTO(domain.idFornecedor(),
                                domain.valorProdutoFornecedor(),
                                domain.fornecedorEndereco(),
                                domain.fornecedorNome(),
                                domain.fornecedorTelefone(),
                                domain.fornecedorEmail(),
                                domain.tipoProduto(), 
                                produtoMapper.toDto(domain.produto()));
    }
    @Override
    public FornecedorEntity toEntity(FornecedorDomain domain) {
        if (domain == null) {
            return null;
        }
        return new FornecedorEntity(domain.idFornecedor(),
                                    domain.valorProdutoFornecedor(),
                                    domain.fornecedorEndereco(),
                                    domain.fornecedorNome(),
                                    domain.fornecedorTelefone(),
                                    domain.fornecedorEmail(),
                                    domain.tipoProduto(),
                                    produtoMapper.toEntity(domain.produto()));
    }
    @Override
    public FornecedorDomain entityToDomain(FornecedorEntity entity) {
        if (entity == null) {
            return null;
        }
        return new FornecedorDomain(entity.getIdFornecedor(),
                                    entity.getValorProdutoFornecedor(),
                                    entity.getFornecedorEndereco(),
                                    entity.getFornecedorNome(),
                                    entity.getFornecedorTelefone(),
                                    entity.getFornecedorEmail(),
                                    entity.getProduto().getTipoProduto(),
                                    produtoMapper.entityToDomain(entity.getProduto()));
    }
    @Override
    public FornecedorDTO entityToDto(FornecedorEntity entity) {
        if (entity == null) {
            return null;
        }
        return new FornecedorDTO(entity.getIdFornecedor(),
                                    entity.getValorProdutoFornecedor(),
                                    entity.getFornecedorEndereco(),
                                    entity.getFornecedorNome(),
                                    entity.getFornecedorTelefone(),
                                    entity.getFornecedorEmail(),
                                    entity.getProduto().getTipoProduto(),
                                    produtoMapper.entityToDto(entity.getProduto()));
    }
}