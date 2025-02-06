package com.BlueSpectre.BlueManeger.Infra.Persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BlueSpectre.BlueManeger.Infra.Persistence.Entities.ProdutoEntity;

import jakarta.transaction.Transactional;

import java.time.LocalDate;

@Repository
public interface ProdutoPercistence extends JpaRepository<ProdutoEntity, Long> {
    
    Optional<ProdutoEntity> findByNomeProduto(String name);

    List<ProdutoEntity> findByValidadeProduto(LocalDate validadeProduto);

    @Modifying
    @Transactional
    @Query("UPDATE PRODUTO p SET p.descricaoProduto = :descricaoProduto, " +
       "p.nomeProduto = :nomeProduto, " +
       "p.validadeProduto = :validadeProduto, " +
       "p.tipoProduto = :tipoProduto, " +
       "p.valorProduto = :valorProduto, " +
       "p.fornecedorEntity = :fornecedorEntity " +
       "WHERE p.idProduto = :idProduto")
    ProdutoPercistence updateProduto(ProdutoEntity entity , Long id);
}