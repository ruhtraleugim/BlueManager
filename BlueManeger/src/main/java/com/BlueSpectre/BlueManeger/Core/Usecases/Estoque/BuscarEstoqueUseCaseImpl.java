package com.BlueSpectre.BlueManeger.Core.Usecases.Estoque;

import java.util.List;

import com.BlueSpectre.BlueManeger.Core.Domain.EstoqueDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.EstoqueGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarUseCase;



public class BuscarEstoqueUseCaseImpl implements BuscarUseCase<EstoqueDomain> {

    private final EstoqueGateway estoqueGateway;

    public BuscarEstoqueUseCaseImpl(EstoqueGateway estoqueGateway){
        this.estoqueGateway = estoqueGateway;
    }
    @Override
    public List<EstoqueDomain> execute() {
        return estoqueGateway.getEstoques();
    }
}