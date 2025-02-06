package com.BlueSpectre.BlueManeger.Core.Gateway;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.BlueSpectre.BlueManeger.Core.Domain.PagamentoDomain;


public interface PagamentoGateway {
       
        Optional<PagamentoDomain> getPagamentoByID(Long ID);

        List<PagamentoDomain> getPagamentos();

        List<PagamentoDomain> getPagamentoByDate(LocalDate date);

        PagamentoDomain newPagamentoModel(PagamentoDomain pagamento);

        PagamentoDomain alterarPagamentoModel(Long ID, PagamentoDomain pagamento);

        void deletePagamento(Long ID);

}
