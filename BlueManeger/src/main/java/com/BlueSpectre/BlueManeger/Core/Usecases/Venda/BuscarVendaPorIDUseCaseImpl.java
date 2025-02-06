package com.BlueSpectre.BlueManeger.Core.Usecases.Venda;

import java.util.Optional;

import com.BlueSpectre.BlueManeger.Core.Domain.VendaDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.VendaGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorIDUserCase;

public class BuscarVendaPorIDUseCaseImpl implements BuscarPorIDUserCase<VendaDomain>{

    private final VendaGateway vendaGateway;

    public BuscarVendaPorIDUseCaseImpl(VendaGateway vendaGateway){
        this.vendaGateway = vendaGateway;
    }
    @Override
    public Optional<VendaDomain> execute(Long ID) {
        return vendaGateway.getVendaByID(ID);
    }
}