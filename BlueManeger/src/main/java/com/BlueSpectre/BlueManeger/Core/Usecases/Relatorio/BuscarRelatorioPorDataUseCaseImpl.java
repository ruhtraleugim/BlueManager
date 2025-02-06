package com.BlueSpectre.BlueManeger.Core.Usecases.Relatorio;

import java.time.LocalDate;
import java.util.List;

import com.BlueSpectre.BlueManeger.Core.Domain.RelatorioDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.RelatorioGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorDataUseCase;

public class BuscarRelatorioPorDataUseCaseImpl implements BuscarPorDataUseCase<RelatorioDomain>{

    private final RelatorioGateway relatorioGateway;

    public BuscarRelatorioPorDataUseCaseImpl(RelatorioGateway relatorioGateway){
        this.relatorioGateway = relatorioGateway;
    }
    @Override
    public List<RelatorioDomain> execute(LocalDate date) {
        return relatorioGateway.getRelatorioByDate(date);
    } 
}