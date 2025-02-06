package com.BlueSpectre.BlueManeger.Core.Usecases.Produto;

import com.BlueSpectre.BlueManeger.Core.Domain.ProdutoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.ProdutoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.AlterarUserCase;

public class AlterarProdutoUseCaseImpl implements AlterarUserCase<ProdutoDomain> {

    private final ProdutoGateway produtoGateway;

    public AlterarProdutoUseCaseImpl(ProdutoGateway produtoGateway){
        this.produtoGateway = produtoGateway;
    }
    @Override
    public ProdutoDomain execute(Long ID, ProdutoDomain newProduto) {
       return produtoGateway.alterarProduto(newProduto, ID);
    }
}