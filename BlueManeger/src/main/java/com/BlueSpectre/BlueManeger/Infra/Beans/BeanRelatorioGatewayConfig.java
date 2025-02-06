package com.BlueSpectre.BlueManeger.Infra.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.BlueSpectre.BlueManeger.Core.Domain.RelatorioDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.RelatorioGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.AlterarUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorDataUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.CriarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.DeleteUsecase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Relatorio.AlterarRelatorioUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Relatorio.BuscarRelatorioPorDataUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Relatorio.BuscarRelatorioUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Relatorio.CriarRelatorioUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Relatorio.DeleteRelatorioUseCaseImpl;


@Configuration
public class BeanRelatorioGatewayConfig {
    @Bean
    public AlterarUserCase<RelatorioDomain> alterarRelatorio(RelatorioGateway relatorioGateway){
        return new AlterarRelatorioUseCaseImpl(relatorioGateway);
    }
    @Bean
    public BuscarPorDataUseCase<RelatorioDomain> buscarRelatorioPorData(RelatorioGateway relatorioGateway){
        return new BuscarRelatorioPorDataUseCaseImpl(relatorioGateway);
    }
    @Bean
    public BuscarUseCase<RelatorioDomain> buscarRelatorio(RelatorioGateway relatorioGateway){
        return new BuscarRelatorioUseCaseImpl(relatorioGateway);
    }
    @Bean
    public CriarUseCase<RelatorioDomain> criarRelatorio(RelatorioGateway relatorioGateway) {
        return new CriarRelatorioUseCaseImpl(relatorioGateway);
    }
    @Bean
    public  DeleteUsecase deleteRelatorio(RelatorioGateway relatorioGateway){
        return new DeleteRelatorioUseCaseImpl(relatorioGateway);
    }
}