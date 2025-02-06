package com.BlueSpectre.BlueManeger.Infra.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.BlueSpectre.BlueManeger.Core.Domain.PagamentoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.PagamentoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.AlterarUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorDataUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorIDUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.CriarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.DeleteUsecase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Pagamento.AlterarPagamentoUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Pagamento.BuscarPagamentoPorDataUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Pagamento.BuscarPagamentoPorIDUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Pagamento.BuscarPagamentoUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Pagamento.CriarPagamentoUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Pagamento.DeletePagamentoUseCaseImpl;

@Configuration
public class BeanPagamentoGatewayConfig {
    @Bean
    public AlterarUserCase<PagamentoDomain> alterarPagamento(PagamentoGateway pagamentoGateway){
        return new AlterarPagamentoUseCaseImpl(pagamentoGateway);
    }
    @Bean
    public BuscarPorDataUseCase<PagamentoDomain> buscarPagamentoPorData(PagamentoGateway pagamentoGateway){
        return new BuscarPagamentoPorDataUseCaseImpl(pagamentoGateway);
    }
    @Bean
    public BuscarUseCase<PagamentoDomain> buscarPagamento(PagamentoGateway pagamentoGateway){
        return new BuscarPagamentoUseCaseImpl(pagamentoGateway);
    }
    @Bean
    public BuscarPorIDUserCase<PagamentoDomain> buscarPagamentoPorID(PagamentoGateway pagamentoGateway){
        return new BuscarPagamentoPorIDUseCaseImpl(pagamentoGateway);
    }
    @Bean
    public CriarUseCase<PagamentoDomain> CriarPagamento(PagamentoGateway pagamentoGateway){
        return new CriarPagamentoUseCaseImpl(pagamentoGateway);
    }
    @Bean
    public DeleteUsecase deletePagamento(PagamentoGateway pagamentoGateway){
        return new DeletePagamentoUseCaseImpl(pagamentoGateway);
    }
}