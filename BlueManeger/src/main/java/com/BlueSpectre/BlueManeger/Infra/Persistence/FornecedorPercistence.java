package com.BlueSpectre.BlueManeger.Infra.Persistence;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BlueSpectre.BlueManeger.Infra.Persistence.Entities.FornecedorEntity;

import jakarta.transaction.Transactional;

@Repository
public interface FornecedorPercistence extends JpaRepository<FornecedorEntity, Long >{
    
    Optional<FornecedorEntity> findByFornecedorNome(String nome);

    @Modifying
    @Transactional
    @Query("UPDATE FORNECEDOR f SET f.valorProdutoFornecedor = :valorProdutoFornecedor, " +
        "f.fornecedorEndereco = :fornecedorEndereco, " +
        "f.fornecedorNome = :fornecedorNome, " +
        "f.fornecedorTelefone = :fornecedorTelefone, " +
        "f.fornecedorEmail = :fornecedorEmail, " +
        "f.tipoProduto = :tipoProduto, " +
        "f.produto = :produto " +
        "WHERE f.idFornecedor = :idFornecedor")
    FornecedorEntity updadeEstoque(FornecedorEntity entity,Long id);
}