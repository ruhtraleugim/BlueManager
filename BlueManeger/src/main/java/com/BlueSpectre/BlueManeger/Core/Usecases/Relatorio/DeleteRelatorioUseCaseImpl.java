package com.BlueSpectre.BlueManeger.Core.Usecases.Relatorio;

import com.BlueSpectre.BlueManeger.Core.Gateway.RelatorioGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.DeleteUsecase;

public class DeleteRelatorioUseCaseImpl implements DeleteUsecase {

    private final RelatorioGateway relatorioGateway;

    public DeleteRelatorioUseCaseImpl(RelatorioGateway relatorioGateway){
        this.relatorioGateway = relatorioGateway;
    }
    @Override
    public void execute(Long ID) {
       relatorioGateway.deleteRelatorio(ID);
    }
    
}