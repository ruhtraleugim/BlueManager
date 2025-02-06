package com.BlueSpectre.BlueManeger.Core.Usecases.Fornecedor;

import com.BlueSpectre.BlueManeger.Core.Gateway.FornecedorGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.DeleteUsecase;

public class DeletarFornecedorUseCaseImpl implements DeleteUsecase {

    private final FornecedorGateway fornecedorGateway;

    public DeletarFornecedorUseCaseImpl(FornecedorGateway fornecedorGateway){
        this.fornecedorGateway = fornecedorGateway;
    }
    @Override
    public void execute(Long ID) {
        fornecedorGateway.deleteFornecedor(ID);
    }
    
}