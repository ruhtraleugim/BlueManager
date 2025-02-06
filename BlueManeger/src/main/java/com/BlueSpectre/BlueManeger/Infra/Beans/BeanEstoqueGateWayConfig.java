package com.BlueSpectre.BlueManeger.Infra.Beans;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.BlueSpectre.BlueManeger.Core.Domain.EstoqueDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.EstoqueGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Estoque.AlterarEstoqueUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Estoque.BuscarEstoquePorDataUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Estoque.BuscarEstoqueUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Estoque.CriarEstoqueUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Estoque.DeleteEstoqueUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.AlterarUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorDataUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.CriarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.DeleteUsecase;

@Configuration
public class BeanEstoqueGateWayConfig {
    @Bean
    public AlterarUserCase<EstoqueDomain> alterarEstoque(EstoqueGateway estoqueGateway){
        return new AlterarEstoqueUseCaseImpl(estoqueGateway);
    }
    @Bean
    public BuscarPorDataUseCase<EstoqueDomain> buscarEstoquePorData(EstoqueGateway estoqueGateway){
        return new BuscarEstoquePorDataUseCaseImpl(estoqueGateway);
    }
    @Bean
    public BuscarUseCase<EstoqueDomain> buscarEstoque(EstoqueGateway estoqueGateway){
        return new BuscarEstoqueUseCaseImpl(estoqueGateway);
    }
    @Bean
    public CriarUseCase<EstoqueDomain> CriarEstoque(EstoqueGateway estoqueGateway){
        return new CriarEstoqueUseCaseImpl(estoqueGateway);
    }
    @Bean
    public DeleteUsecase deleteEstoque(EstoqueGateway estoqueGateway){
        return new DeleteEstoqueUseCaseImpl(estoqueGateway);
    }
}