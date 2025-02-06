package com.BlueSpectre.BlueManeger.Core.Usecases.Pagamento;

import com.BlueSpectre.BlueManeger.Core.Domain.PagamentoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.PagamentoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.CriarUseCase;

public class CriarPagamentoUseCaseImpl implements CriarUseCase<PagamentoDomain>{
    
    private final PagamentoGateway pagamentoGateway;

    public CriarPagamentoUseCaseImpl(PagamentoGateway pagamentoGateway){
        this.pagamentoGateway = pagamentoGateway;
    }
    @Override
    public PagamentoDomain execute(PagamentoDomain Pagamento) {
        return pagamentoGateway.newPagamentoModel(Pagamento);
    }
}