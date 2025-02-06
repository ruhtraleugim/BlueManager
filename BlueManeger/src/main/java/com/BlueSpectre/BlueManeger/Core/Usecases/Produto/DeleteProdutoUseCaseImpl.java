package com.BlueSpectre.BlueManeger.Core.Usecases.Produto;

import com.BlueSpectre.BlueManeger.Core.Gateway.ProdutoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.DeleteUsecase;

public class DeleteProdutoUseCaseImpl implements DeleteUsecase {

    private final ProdutoGateway produtoGateway;

    public DeleteProdutoUseCaseImpl(ProdutoGateway produtoGateway){
        this.produtoGateway = produtoGateway;
    }
    @Override
    public void execute(Long ID) {
        produtoGateway.deleteProduto(ID);
    }
    
}