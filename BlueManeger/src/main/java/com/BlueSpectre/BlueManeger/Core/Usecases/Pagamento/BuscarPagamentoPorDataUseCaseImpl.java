package com.BlueSpectre.BlueManeger.Core.Usecases.Pagamento;

import java.time.LocalDate;
import java.util.List;

import com.BlueSpectre.BlueManeger.Core.Domain.PagamentoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.PagamentoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorDataUseCase;

public class BuscarPagamentoPorDataUseCaseImpl implements BuscarPorDataUseCase<PagamentoDomain> {

    private final PagamentoGateway pagamentoGateway;

    public BuscarPagamentoPorDataUseCaseImpl(PagamentoGateway pagamentoGateway){
        this.pagamentoGateway = pagamentoGateway;
    }
    @Override
    public List<PagamentoDomain> execute(LocalDate date) {
        return pagamentoGateway.getPagamentoByDate(date);
    }
}