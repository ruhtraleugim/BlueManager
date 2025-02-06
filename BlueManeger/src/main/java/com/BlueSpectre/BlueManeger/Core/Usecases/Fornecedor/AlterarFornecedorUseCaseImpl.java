package com.BlueSpectre.BlueManeger.Core.Usecases.Fornecedor;

import com.BlueSpectre.BlueManeger.Core.Domain.FornecedorDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.FornecedorGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.AlterarUserCase;

public class AlterarFornecedorUseCaseImpl implements AlterarUserCase<FornecedorDomain>{

    private final FornecedorGateway fornecedorGateway;

    public AlterarFornecedorUseCaseImpl(FornecedorGateway fornecedorGateway){
        this.fornecedorGateway = fornecedorGateway;
    }
    @Override
    public FornecedorDomain execute(Long ID, FornecedorDomain fornecedor) {
        return fornecedorGateway.alterarFornecedor(ID, fornecedor);
    }
}