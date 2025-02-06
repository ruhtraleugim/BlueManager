package com.BlueSpectre.BlueManeger.Core.Usecases.Venda;

import java.time.LocalDate;
import java.util.List;

import com.BlueSpectre.BlueManeger.Core.Domain.VendaDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.VendaGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorDataUseCase;

public class BuscarVendaPorDiaUseCaseImpl  implements BuscarPorDataUseCase<VendaDomain>{
   
    private final VendaGateway vendaGateway;

    public BuscarVendaPorDiaUseCaseImpl(VendaGateway vendaGateway){
        this.vendaGateway = vendaGateway;
    }
    @Override
    public List<VendaDomain> execute(LocalDate date) {
        return vendaGateway.getVendasByDate(date);
    }
}