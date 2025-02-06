package com.BlueSpectre.BlueManeger.Core.Usecases.Venda;

import com.BlueSpectre.BlueManeger.Core.Gateway.VendaGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.DeleteUsecase;

public class DeleteVendaUseCaseImpl implements DeleteUsecase{
    
    private final VendaGateway vendaGateway;

    public DeleteVendaUseCaseImpl(VendaGateway vendaGateway){
        this.vendaGateway = vendaGateway;
    }
    @Override
    public void execute(Long ID) {
        vendaGateway.deleteVenda(ID);
    }
}