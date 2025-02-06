package com.BlueSpectre.BlueManeger.Core.Usecases.Debito;

import java.time.LocalDate;
import java.util.List;

import com.BlueSpectre.BlueManeger.Core.Domain.DebitoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.DebitoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorDataUseCase;

public class BuscarDebitoPorDataUseCaseImpl implements BuscarPorDataUseCase<DebitoDomain>{

    private final DebitoGateway debitoGateway;

    public BuscarDebitoPorDataUseCaseImpl(DebitoGateway debitoGateway){
        this.debitoGateway = debitoGateway;
    }
    @Override
    public List<DebitoDomain> execute(LocalDate date) {
        return debitoGateway.getDebitosByDate(date);
    }
}