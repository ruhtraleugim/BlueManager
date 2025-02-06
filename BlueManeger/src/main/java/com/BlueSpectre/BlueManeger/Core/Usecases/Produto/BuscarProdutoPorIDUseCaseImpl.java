package com.BlueSpectre.BlueManeger.Core.Usecases.Produto;

import java.util.Optional;

import com.BlueSpectre.BlueManeger.Core.Domain.ProdutoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.ProdutoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorIDUserCase;

public class BuscarProdutoPorIDUseCaseImpl implements BuscarPorIDUserCase<ProdutoDomain>{

    private final ProdutoGateway produtoGateway;

    public BuscarProdutoPorIDUseCaseImpl(ProdutoGateway produtoGateway){
        this.produtoGateway = produtoGateway;
    }
    @Override
    public Optional<ProdutoDomain> execute(Long ID) {
        return produtoGateway.getProdutoByID(ID);
    }
}