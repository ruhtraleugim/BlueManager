package com.BlueSpectre.BlueManeger.Infra.Persistence.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "RELATORIO")
@Table(name = "RELATORIO")
public class RelatorioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRelatorio;
    private double lucroEsperado;
    private double lucroPorProduto;
    private LocalDateTime dataHoraRelatorio;

    @JoinColumn(name = "idEstoque")
    @OneToOne
    private EstoqueEntity estoque;
    @JoinColumn(name = "idVenda")
    @ManyToOne
    private VendaEntity venda;
}