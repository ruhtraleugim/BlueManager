package com.BlueSpectre.BlueManeger.Core.Usecases.Debito;

import java.util.List;

import com.BlueSpectre.BlueManeger.Core.Domain.DebitoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.DebitoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarUseCase;


public class BuscarDebitoUseCaseImpl implements BuscarUseCase<DebitoDomain>{

    private final DebitoGateway debitoGateway;

    public BuscarDebitoUseCaseImpl(DebitoGateway debitoGateway){
        this.debitoGateway = debitoGateway;
    }
    @Override
    public List<DebitoDomain> execute() {
        return debitoGateway.GetDebito();
    }
}