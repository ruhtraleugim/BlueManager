package com.BlueSpectre.BlueManeger.Core.Usecases.Venda;

import com.BlueSpectre.BlueManeger.Core.Domain.VendaDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.VendaGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.CriarUseCase;

public class CriarVendaUseCaseImpl implements CriarUseCase<VendaDomain>{

    private final VendaGateway vendaGateway;

    public CriarVendaUseCaseImpl(VendaGateway vendaGateway){
        this.vendaGateway = vendaGateway;
    }

    @Override
    public VendaDomain execute(VendaDomain venda) {
       return vendaGateway.newVenda(venda);
    }
}