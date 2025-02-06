package com.BlueSpectre.BlueManeger.Core.Usecases.Estoque;

import com.BlueSpectre.BlueManeger.Core.Gateway.EstoqueGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.DeleteUsecase;

public class DeleteEstoqueUseCaseImpl implements DeleteUsecase{

    private final EstoqueGateway estoqueGateway;

    public DeleteEstoqueUseCaseImpl(EstoqueGateway estoqueGateway){
        this.estoqueGateway = estoqueGateway;
    }
    @Override
    public void execute(Long ID) {
        estoqueGateway.deletarEstoque(ID);
    }
}