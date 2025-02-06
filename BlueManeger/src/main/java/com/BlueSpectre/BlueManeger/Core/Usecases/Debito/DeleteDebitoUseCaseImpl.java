package com.BlueSpectre.BlueManeger.Core.Usecases.Debito;

import com.BlueSpectre.BlueManeger.Core.Gateway.DebitoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.DeleteUsecase;

public class DeleteDebitoUseCaseImpl implements DeleteUsecase{

    private final DebitoGateway debitoGateway;

    public DeleteDebitoUseCaseImpl(DebitoGateway debitoGateway){
        this.debitoGateway = debitoGateway;
    }
    @Override
    public void execute(Long ID) {
        debitoGateway.deleteDebito(ID);
    }
}