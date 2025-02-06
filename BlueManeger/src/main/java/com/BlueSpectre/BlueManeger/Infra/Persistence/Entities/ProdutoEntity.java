package com.BlueSpectre.BlueManeger.Infra.Persistence.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

import com.BlueSpectre.BlueManeger.Core.Enum.TipoProduto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "PRODUTO")
@Table(name = "PRODUTO")
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idProduto;

    private String descricaoProduto;
    private String nomeProduto;
    private LocalDate validadeProduto;

    @Enumerated(EnumType.STRING)
    private TipoProduto tipoProduto;
    
    private double valorProduto;
    
    @ManyToOne
    @JoinColumn(name = "idFornecedor")
    private FornecedorEntity fornecedorEntity;
}