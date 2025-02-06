package com.BlueSpectre.BlueManeger.Core.Usecases.Fornecedor;

import com.BlueSpectre.BlueManeger.Core.Domain.FornecedorDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.FornecedorGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.CriarUseCase;

public class CriarFornecedorUseCaseImpl implements CriarUseCase<FornecedorDomain>{

    private final FornecedorGateway fornecedorGateway;

    public CriarFornecedorUseCaseImpl(FornecedorGateway fornecedorGateway){
        this.fornecedorGateway = fornecedorGateway;
    }
    @Override
    public FornecedorDomain execute(FornecedorDomain fornecedor) {
        return fornecedorGateway.newFornecedor(fornecedor);
    }
}