package com.BlueSpectre.BlueManeger.Core.Usecases.Estoque;

import com.BlueSpectre.BlueManeger.Core.Domain.EstoqueDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.EstoqueGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.AlterarUserCase;

public class AlterarEstoqueUseCaseImpl implements AlterarUserCase<EstoqueDomain> {
   
    private final EstoqueGateway estoqueGateway;

    public AlterarEstoqueUseCaseImpl(EstoqueGateway estoqueGateway){
        this.estoqueGateway = estoqueGateway;
    }
    @Override
    public EstoqueDomain execute(Long ID, EstoqueDomain estoqueModel) {
        return estoqueGateway.updateEstoque(estoqueModel, ID);
    } 
}