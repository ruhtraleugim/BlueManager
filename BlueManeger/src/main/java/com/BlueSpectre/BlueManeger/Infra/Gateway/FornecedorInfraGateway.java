package com.BlueSpectre.BlueManeger.Infra.Gateway;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BlueSpectre.BlueManeger.Core.Domain.FornecedorDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.FornecedorGateway;
import com.BlueSpectre.BlueManeger.Infra.Mapper.Fornecedor.FornecedorMapper;
import com.BlueSpectre.BlueManeger.Infra.Persistence.FornecedorPercistence;
import com.BlueSpectre.BlueManeger.Infra.Persistence.Entities.FornecedorEntity;

@Service
public class FornecedorInfraGateway implements FornecedorGateway{

    private final FornecedorPercistence fornecedorRepository;
    private final FornecedorMapper fornecedorMapper;

    public FornecedorInfraGateway(FornecedorPercistence fornecedorRepository, FornecedorMapper fornecedorMapper) {
        this.fornecedorRepository = fornecedorRepository;
        this.fornecedorMapper = fornecedorMapper;
    }
    @Override
    public Optional<FornecedorDomain> getFornecedorByID(Long id) {
        return fornecedorRepository.findById(id).map(fornecedorMapper::entityToDomain);
    }
    @Override
    public Optional<FornecedorDomain> getFornecedorByName(String nome) {
        return fornecedorRepository.findByFornecedorNome(nome).map(fornecedorMapper::entityToDomain);
    }
    @Override
    public List<FornecedorDomain> getFornecedores() {
        return fornecedorRepository.findAll().stream().map(fornecedorMapper::entityToDomain).toList();
    }
    @Override
    public FornecedorDomain newFornecedor(FornecedorDomain fornecedor) {
       FornecedorEntity fornecedorEntity = fornecedorMapper.toEntity(fornecedor);
       FornecedorEntity savedEntity = fornecedorRepository.save(fornecedorEntity);
       return fornecedorMapper.entityToDomain(savedEntity);
    }
    @Override
    public void deleteFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }
    @Override
    public FornecedorDomain alterarFornecedor(Long id, FornecedorDomain fornecedor) {
        FornecedorEntity fornecedorEntity = fornecedorMapper.toEntity(fornecedor);
        fornecedorRepository.updadeEstoque(fornecedorEntity, id);
        return fornecedorMapper.entityToDomain(fornecedorEntity);
    }   
}