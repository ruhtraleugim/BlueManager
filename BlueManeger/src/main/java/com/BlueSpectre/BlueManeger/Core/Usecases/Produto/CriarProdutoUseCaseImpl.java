package com.BlueSpectre.BlueManeger.Core.Usecases.Produto;

import com.BlueSpectre.BlueManeger.Core.Domain.ProdutoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.ProdutoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.CriarUseCase;

public class CriarProdutoUseCaseImpl implements CriarUseCase<ProdutoDomain>{

    private final ProdutoGateway produtoGateway;

    public CriarProdutoUseCaseImpl(ProdutoGateway produtoGateway){
        this.produtoGateway = produtoGateway;
    }
    @Override
    public ProdutoDomain execute(ProdutoDomain produto) {
        return produtoGateway.newProduto(produto);
    }
}