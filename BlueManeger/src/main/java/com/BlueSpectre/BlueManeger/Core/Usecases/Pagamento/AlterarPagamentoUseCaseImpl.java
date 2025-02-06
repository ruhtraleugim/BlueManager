package com.BlueSpectre.BlueManeger.Core.Usecases.Pagamento;

import com.BlueSpectre.BlueManeger.Core.Domain.PagamentoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.PagamentoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.AlterarUserCase;

public class AlterarPagamentoUseCaseImpl implements AlterarUserCase<PagamentoDomain>{

    private final PagamentoGateway pagamentoGateway;

    public AlterarPagamentoUseCaseImpl(PagamentoGateway pagamentoGateway){
        this.pagamentoGateway = pagamentoGateway;
    }
    @Override
    public PagamentoDomain execute(Long ID, PagamentoDomain altPagamento) {
        return pagamentoGateway.alterarPagamentoModel(ID, altPagamento);
    }
}