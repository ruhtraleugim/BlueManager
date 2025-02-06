package com.BlueSpectre.BlueManeger.Core.Usecases.Relatorio;

import com.BlueSpectre.BlueManeger.Core.Domain.RelatorioDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.RelatorioGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.CriarUseCase;

public class CriarRelatorioUseCaseImpl implements CriarUseCase<RelatorioDomain> {

    private final RelatorioGateway relatorioGateway;

    public CriarRelatorioUseCaseImpl(RelatorioGateway relatorioGateway){
        this.relatorioGateway = relatorioGateway;
    }
    @Override
    public RelatorioDomain execute(RelatorioDomain relatorio) {
        return relatorioGateway.newRelatorio(relatorio);
    }
}