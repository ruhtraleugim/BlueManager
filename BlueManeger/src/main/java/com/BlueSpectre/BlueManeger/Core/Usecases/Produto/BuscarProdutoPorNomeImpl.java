package com.BlueSpectre.BlueManeger.Core.Usecases.Produto;

import java.util.Optional;

import com.BlueSpectre.BlueManeger.Core.Domain.ProdutoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.ProdutoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorNomeUseCase;

public class BuscarProdutoPorNomeImpl implements BuscarPorNomeUseCase<ProdutoDomain> {

    private final ProdutoGateway produtoGateway;

    public BuscarProdutoPorNomeImpl(ProdutoGateway produtoGateway){
        this.produtoGateway = produtoGateway;
    }
    @Override
    public Optional<ProdutoDomain> execute(String Nome) {
        return produtoGateway.getProdutoByNome(Nome);
    }
}