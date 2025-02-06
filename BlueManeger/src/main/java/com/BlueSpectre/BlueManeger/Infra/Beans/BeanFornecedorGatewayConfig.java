package com.BlueSpectre.BlueManeger.Infra.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.BlueSpectre.BlueManeger.Core.Domain.FornecedorDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.FornecedorGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Fornecedor.AlterarFornecedorUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Fornecedor.BuscarFonecedorPoIDUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Fornecedor.BuscarFornecedorPorNomeUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Fornecedor.BuscarFornecedorUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Fornecedor.CriarFornecedorUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Fornecedor.DeletarFornecedorUseCaseImpl;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.AlterarUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorIDUserCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorNomeUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.CriarUseCase;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.DeleteUsecase;

@Configuration
public class BeanFornecedorGatewayConfig {
    @Bean
    public AlterarUserCase<FornecedorDomain> alterarFornecedor(FornecedorGateway fornecedorGateway){
        return new AlterarFornecedorUseCaseImpl(fornecedorGateway);
    }
    @Bean
    public BuscarPorIDUserCase<FornecedorDomain> buscarFornecedorPorID(FornecedorGateway fornecedorGateway){
        return new BuscarFonecedorPoIDUseCaseImpl(fornecedorGateway);
    }
    @Bean
    public BuscarPorNomeUseCase<FornecedorDomain> buscarFornecedorPorNome(FornecedorGateway fornecedorGateway){
        return new BuscarFornecedorPorNomeUseCaseImpl(fornecedorGateway);
    }
    @Bean
    public BuscarUseCase<FornecedorDomain> buscarUseCase(FornecedorGateway fornecedorGateway){
        return new BuscarFornecedorUseCaseImpl(fornecedorGateway);
    }
    @Bean
    public CriarUseCase<FornecedorDomain> criarFornecedor(FornecedorGateway fornecedorGateway){
        return new CriarFornecedorUseCaseImpl(fornecedorGateway);
    }
    @Bean
    public DeleteUsecase deleteFornecedor(FornecedorGateway fornecedorGateway){
        return new DeletarFornecedorUseCaseImpl(fornecedorGateway);
    }
}