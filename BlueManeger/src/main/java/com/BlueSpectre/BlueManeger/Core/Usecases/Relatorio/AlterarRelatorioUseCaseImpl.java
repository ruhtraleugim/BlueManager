package com.BlueSpectre.BlueManeger.Core.Usecases.Relatorio;

import com.BlueSpectre.BlueManeger.Core.Domain.RelatorioDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.RelatorioGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.AlterarUserCase;

public class AlterarRelatorioUseCaseImpl implements AlterarUserCase<RelatorioDomain>{

    private final RelatorioGateway relatorioGateway;

    public AlterarRelatorioUseCaseImpl(RelatorioGateway relatorioGateway){
        this.relatorioGateway = relatorioGateway;
    }
    @Override
    public RelatorioDomain execute(Long ID, RelatorioDomain relatorio) {
      return relatorioGateway.alterarRelatorio(ID, relatorio);
    }
}