package com.BlueSpectre.BlueManeger.Core.Usecases.Debito;

import com.BlueSpectre.BlueManeger.Core.Domain.DebitoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.DebitoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.CriarUseCase;
import lombok.extern.slf4j.Slf4j;

public class CriarDebitoUseCaseImpl implements CriarUseCase<DebitoDomain>{
    
    private final DebitoGateway debitoGateway;

    public CriarDebitoUseCaseImpl(DebitoGateway debitoGateway){
        this.debitoGateway = debitoGateway;
    }
    @Override
    public DebitoDomain execute(DebitoDomain debitoModel) {
        return debitoGateway.newDebito(debitoModel);
    }
}