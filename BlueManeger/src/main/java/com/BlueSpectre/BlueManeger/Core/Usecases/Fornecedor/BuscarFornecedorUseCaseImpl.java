package com.BlueSpectre.BlueManeger.Core.Usecases.Fornecedor;

import java.util.List;

import com.BlueSpectre.BlueManeger.Core.Domain.FornecedorDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.FornecedorGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarUseCase;

public class BuscarFornecedorUseCaseImpl implements BuscarUseCase<FornecedorDomain> {

    private final FornecedorGateway fornecedorGateway;

    public BuscarFornecedorUseCaseImpl(FornecedorGateway fornecedorGateway){
        this.fornecedorGateway = fornecedorGateway;
    }
    @Override
    public List<FornecedorDomain> execute() {
        return fornecedorGateway.getFornecedores();
    } 
}