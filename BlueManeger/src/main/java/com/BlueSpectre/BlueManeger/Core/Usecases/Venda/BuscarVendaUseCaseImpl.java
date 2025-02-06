package com.BlueSpectre.BlueManeger.Core.Usecases.Venda;

import java.util.List;

import com.BlueSpectre.BlueManeger.Core.Domain.VendaDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.VendaGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarUseCase;

public class BuscarVendaUseCaseImpl implements BuscarUseCase<VendaDomain>{
    
    private final VendaGateway vendaGateway;

    public BuscarVendaUseCaseImpl(VendaGateway vendaGateway){
        this.vendaGateway = vendaGateway;
    }
    @Override
    public List<VendaDomain> execute() {
        return vendaGateway.getVendas();
    }
}