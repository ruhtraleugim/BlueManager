package com.BlueSpectre.BlueManeger.Core.Usecases.Debito;

import com.BlueSpectre.BlueManeger.Core.Domain.DebitoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.DebitoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.AlterarUserCase;

public class AlterarDebitoUseCaseImpl implements AlterarUserCase<DebitoDomain> {
    
    private final DebitoGateway debitoGateway;

    public AlterarDebitoUseCaseImpl(DebitoGateway debitoGateway){
        this.debitoGateway = debitoGateway;
    }
    @Override
    public DebitoDomain execute(Long ID, DebitoDomain debito) {
        debitoGateway.deleteDebito(ID);
        return debitoGateway.newDebito(debito);
    }
}