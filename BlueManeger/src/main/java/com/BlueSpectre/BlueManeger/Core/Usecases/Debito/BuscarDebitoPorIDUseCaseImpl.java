package com.BlueSpectre.BlueManeger.Core.Usecases.Debito;

import java.util.Optional;

import com.BlueSpectre.BlueManeger.Core.Domain.DebitoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.DebitoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorIDUserCase;

public class BuscarDebitoPorIDUseCaseImpl implements BuscarPorIDUserCase<DebitoDomain>{

    private final DebitoGateway debitoGateway;
        
    public BuscarDebitoPorIDUseCaseImpl(DebitoGateway debitoGateway){
        this.debitoGateway = debitoGateway;
    }
    @Override
    public Optional<DebitoDomain> execute(Long ID) {
        return debitoGateway.getDebitosByID(ID);
    }
}