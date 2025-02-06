package com.BlueSpectre.BlueManeger.Core.Usecases.Pagamento;

import com.BlueSpectre.BlueManeger.Core.Gateway.PagamentoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.DeleteUsecase;

public class DeletePagamentoUseCaseImpl implements DeleteUsecase{

    private final PagamentoGateway   pagamentoGateway;

    public DeletePagamentoUseCaseImpl(PagamentoGateway pagamentoGateway){
        this.pagamentoGateway = pagamentoGateway;
    }
    @Override
    public void execute(Long ID) {
        pagamentoGateway.deletePagamento(ID);
    }
}