package com.BlueSpectre.BlueManeger.Core.Usecases.Pagamento;

import java.util.List;

import com.BlueSpectre.BlueManeger.Core.Domain.PagamentoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.PagamentoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarUseCase;

public class BuscarPagamentoUseCaseImpl implements BuscarUseCase<PagamentoDomain>{
    
    private final PagamentoGateway pagamentoGateway;

    public BuscarPagamentoUseCaseImpl (PagamentoGateway pagamentoGateway){
        this.pagamentoGateway = pagamentoGateway;
    }
    @Override
    public List<PagamentoDomain> execute() {
        return pagamentoGateway.getPagamentos();
    }
}