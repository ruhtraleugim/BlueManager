package com.BlueSpectre.BlueManeger.Core.Usecases.Relatorio;

import java.util.List;

import com.BlueSpectre.BlueManeger.Core.Domain.RelatorioDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.RelatorioGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarUseCase;

public class BuscarRelatorioUseCaseImpl implements BuscarUseCase<RelatorioDomain> {
    private final RelatorioGateway relatorioGateway;

    public BuscarRelatorioUseCaseImpl(RelatorioGateway relatorioGateway){
        this.relatorioGateway = relatorioGateway;
    }
    @Override
    public List<RelatorioDomain> execute() {
        return relatorioGateway.getRelatorio() ;
    }
}