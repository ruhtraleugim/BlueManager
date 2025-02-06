package com.BlueSpectre.BlueManeger.Infra.Beans;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.BlueSpectre.BlueManeger.Core.Domain.DebitoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.DebitoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Debito.AlterarDebitoUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Debito.BuscarDebitoPorDataUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Debito.BuscarDebitoPorIDUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Debito.BuscarDebitoUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Debito.CriarDebitoUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Debito.DeleteDebitoUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.AlterarUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorDataUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorIDUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.CriarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.DeleteUsecase;

@Configuration
public class BeanDebitoGatewayConfig {
    @Bean
    public AlterarUserCase<DebitoDomain> alterarDebito(DebitoGateway debitoGateway){
        return new AlterarDebitoUseCaseImpl(debitoGateway);
    }
    @Bean
    public BuscarPorDataUseCase<DebitoDomain> buscarDebitoPorData(DebitoGateway debitoGateway){
        return new BuscarDebitoPorDataUseCaseImpl(debitoGateway);
    }
    @Bean
    public BuscarPorIDUserCase<DebitoDomain> buscarDebitoPorID(DebitoGateway debitoGateway){
        return new BuscarDebitoPorIDUseCaseImpl(debitoGateway);
    }
    @Bean
    public BuscarUseCase<DebitoDomain> buscarDebito(DebitoGateway debitoGateway){
        return new BuscarDebitoUseCaseImpl(debitoGateway);
    }
    @Bean
    public CriarUseCase<DebitoDomain> criarDebito(DebitoGateway debitoGateway) {
        return new CriarDebitoUseCaseImpl(debitoGateway);
    }
    @Bean
    public  DeleteUsecase deleteDebito(DebitoGateway debitoGateway){
        return new DeleteDebitoUseCaseImpl(debitoGateway);
    }
}