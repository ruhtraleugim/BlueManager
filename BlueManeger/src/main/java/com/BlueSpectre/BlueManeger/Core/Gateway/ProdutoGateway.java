package com.BlueSpectre.BlueManeger.Core.Gateway;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.BlueSpectre.BlueManeger.Core.Domain.ProdutoDomain;


public interface ProdutoGateway {

        Optional<ProdutoDomain> getProdutoByID(Long ID);

        Optional<ProdutoDomain> getProdutoByNome(String nomeProduto);

        List<ProdutoDomain> getProdutoByDate(LocalDate date);

        List<ProdutoDomain> getProduto();

        ProdutoDomain newProduto(ProdutoDomain produtoModel);

        ProdutoDomain alterarProduto(ProdutoDomain produto, Long ID);

        void deleteProduto(Long ID);

}