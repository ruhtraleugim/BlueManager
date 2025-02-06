package com.BlueSpectre.BlueManeger.Core.Usecases.Pagamento;

import java.util.Optional;

import com.BlueSpectre.BlueManeger.Core.Domain.PagamentoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.PagamentoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorIDUserCase;

public class BuscarPagamentoPorIDUseCaseImpl implements BuscarPorIDUserCase<PagamentoDomain>{
    
    private final PagamentoGateway pagamentoGateway;

    public BuscarPagamentoPorIDUseCaseImpl(PagamentoGateway pagamentoGateway){
        this.pagamentoGateway = pagamentoGateway;
    }
    @Override
    public Optional<PagamentoDomain> execute(Long ID) {
        return pagamentoGateway.getPagamentoByID(ID);
    }
}