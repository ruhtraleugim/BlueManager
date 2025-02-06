package com.BlueSpectre.BlueManeger.Infra.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.BlueSpectre.BlueManeger.Core.Domain.ProdutoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.ProdutoGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.AlterarUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorIDUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.CriarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.DeleteUsecase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Produto.AlterarProdutoUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Produto.BuscarProdutoPorIDUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Produto.BuscarProdutoUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Produto.CriarProdutoUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Produto.DeleteProdutoUseCaseImpl;

@Configuration
public class BeanProdutoGatewayConfig {
    @Bean
    public AlterarUserCase<ProdutoDomain> alterarProduto(ProdutoGateway produtoGateway){
        return new AlterarProdutoUseCaseImpl(produtoGateway);
    }
    @Bean
    public BuscarPorIDUserCase<ProdutoDomain> buscarProdutoPorID(ProdutoGateway produtoGateway){
        return new BuscarProdutoPorIDUseCaseImpl(produtoGateway);
    }
    @Bean
    public BuscarUseCase<ProdutoDomain> buscarProduto(ProdutoGateway produtoGateway){
        return new BuscarProdutoUseCaseImpl(produtoGateway);
    }
    @Bean
    public CriarUseCase<ProdutoDomain> criarProduto(ProdutoGateway produtoGateway) {
        return new CriarProdutoUseCaseImpl(produtoGateway);
    }
    @Bean
    public  DeleteUsecase deleteProduto(ProdutoGateway produtoGateway){
        return new DeleteProdutoUseCaseImpl(produtoGateway);
    }
}
