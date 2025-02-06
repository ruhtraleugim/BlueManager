package com.BlueSpectre.BlueManeger.Core.Usecases.Estoque;

import com.BlueSpectre.BlueManeger.Core.Domain.EstoqueDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.EstoqueGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.CriarUseCase;

public class CriarEstoqueUseCaseImpl implements CriarUseCase<EstoqueDomain> {
    private final EstoqueGateway estoqueGateway;

    public CriarEstoqueUseCaseImpl(EstoqueGateway estoqueGateway){
        this.estoqueGateway = estoqueGateway;
    }
    @Override
    public EstoqueDomain execute(EstoqueDomain estoqueModel) {
        return estoqueGateway.criarEstoque(estoqueModel);
    }
}