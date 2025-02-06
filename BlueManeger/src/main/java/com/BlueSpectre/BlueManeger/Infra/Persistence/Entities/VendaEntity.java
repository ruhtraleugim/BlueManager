package com.BlueSpectre.BlueManeger.Infra.Persistence.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "VENDA")
@Entity(name = "VENDA")
public class VendaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenda;
    private int quantidadeProduto;
    private double valorVenda;
    private LocalDateTime dataVenda;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private ProdutoEntity produtoVenda;

    @ManyToOne
    @JoinColumn(name = "id_pagamento")
    private PagamentoEntity pagamento; 
}