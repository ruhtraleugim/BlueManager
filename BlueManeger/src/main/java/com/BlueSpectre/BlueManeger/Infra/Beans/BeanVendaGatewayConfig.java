package com.BlueSpectre.BlueManeger.Infra.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.BlueSpectre.BlueManeger.Core.Domain.VendaDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.VendaGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.AlterarUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorDataUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorIDUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.CriarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.DeleteUsecase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Venda.AlterarVendaUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Venda.BuscarVendaPorDiaUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Venda.BuscarVendaPorIDUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Venda.BuscarVendaUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Venda.CriarVendaUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Venda.DeleteVendaUseCaseImpl;


@Configuration
public class BeanVendaGatewayConfig {
    @Bean
    public AlterarUserCase<VendaDomain> alterarVenda(VendaGateway vendaGateway) {
        return new AlterarVendaUseCaseImpl(vendaGateway);
    }
    @Bean
    public BuscarPorDataUseCase<VendaDomain> buscarVendaPorDia(VendaGateway vendaGateway) {
        return new BuscarVendaPorDiaUseCaseImpl(vendaGateway);
    }
    @Bean
    public BuscarPorIDUserCase<VendaDomain> buscarVendaPorID(VendaGateway vendaGateway) {
        return new BuscarVendaPorIDUseCaseImpl(vendaGateway);
    }
    @Bean
    public BuscarUseCase<VendaDomain> buscarVenda(VendaGateway vendaGateway) {
        return new BuscarVendaUseCaseImpl(vendaGateway);
    }
    @Bean
    public CriarUseCase<VendaDomain> criarVenda(VendaGateway vendaGateway) {
        return new CriarVendaUseCaseImpl(vendaGateway);
    }
    @Bean
    public DeleteUsecase deleteVenda(VendaGateway vendaGateway) {
        return new DeleteVendaUseCaseImpl(vendaGateway);
    }
}