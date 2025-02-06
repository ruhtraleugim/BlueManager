package com.BlueSpectre.BlueManeger.Core.Usecases.Produto;

import java.util.List;

import com.BlueSpectre.BlueManeger.Core.Domain.ProdutoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.ProdutoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarUseCase;

public class BuscarProdutoUseCaseImpl implements BuscarUseCase<ProdutoDomain> {
    
    private ProdutoGateway produtoGateway;

    public BuscarProdutoUseCaseImpl(ProdutoGateway produtoGateway){
        this.produtoGateway = produtoGateway;
    }
    @Override
    public List<ProdutoDomain> execute() {
        return produtoGateway.getProduto();
    }
}