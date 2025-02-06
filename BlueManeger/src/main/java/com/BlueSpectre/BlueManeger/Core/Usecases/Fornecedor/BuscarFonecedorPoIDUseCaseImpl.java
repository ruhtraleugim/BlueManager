package com.BlueSpectre.BlueManeger.Core.Usecases.Fornecedor;

import java.util.Optional;

import com.BlueSpectre.BlueManeger.Core.Domain.FornecedorDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.FornecedorGateway;
import com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces.BuscarPorIDUserCase;

public class BuscarFonecedorPoIDUseCaseImpl implements BuscarPorIDUserCase<FornecedorDomain>{

    private final FornecedorGateway fornecedorGateway;

    public BuscarFonecedorPoIDUseCaseImpl(FornecedorGateway fornecedorGateway){
        this.fornecedorGateway = fornecedorGateway;
    }
    @Override
    public Optional<FornecedorDomain> execute(Long ID) {
        return fornecedorGateway.getFornecedorByID(ID);
    }
} 