package com.BlueSpectre.BlueManeger.Core.Usecases.Fornecedor;

import java.util.Optional;

import com.BlueSpectre.BlueManeger.Core.Domain.FornecedorDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.FornecedorGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorNomeUseCase;

public class BuscarFornecedorPorNomeUseCaseImpl implements BuscarPorNomeUseCase<FornecedorDomain>{

    private final FornecedorGateway fornecedorGateway;

    public BuscarFornecedorPorNomeUseCaseImpl(FornecedorGateway fornecedorGateway){
        this.fornecedorGateway = fornecedorGateway;
    }
    @Override
    public Optional<FornecedorDomain> execute(String Nome) {
        return fornecedorGateway.getFornecedorByName(Nome);
    }
}