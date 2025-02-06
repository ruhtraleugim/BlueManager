package com.BlueSpectre.BlueManeger.Core.Usecases.Venda;

import com.BlueSpectre.BlueManeger.Core.Domain.VendaDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.VendaGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.AlterarUserCase;

public class AlterarVendaUseCaseImpl implements AlterarUserCase<VendaDomain>{
    
    private final VendaGateway vendaGateway;

    public AlterarVendaUseCaseImpl(VendaGateway vendaGateway){
        this.vendaGateway = vendaGateway;
    }

    @Override
    public VendaDomain execute(Long ID, VendaDomain venda) {
        return vendaGateway.alterarVenda(venda, ID);
    }
}