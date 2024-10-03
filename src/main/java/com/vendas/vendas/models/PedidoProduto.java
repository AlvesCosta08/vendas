package com.vendas.vendas.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;


@Entity
@Table(name = "pedido_produto")
public class PedidoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido_produto", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false, foreignKey = @ForeignKey(name = "fk_pedido"))
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false, foreignKey = @ForeignKey(name = "fk_produto"))
    private Produto produto;

    @Column(name = "quantidade", nullable = false)
    @Min(1) // Garante que a quantidade seja maior que zero
    private Integer quantidade;

    @Column(name = "valor_unitario", nullable = false, precision = 10, scale = 2)
    @DecimalMin("0.00") // Garante que o valor unitário seja maior ou igual a zero
    private BigDecimal valorUnitario;

    @Column(name = "subtotal", nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    public PedidoProduto() {}

    public PedidoProduto(Pedido pedido, Produto produto, Integer quantidade, BigDecimal valorUnitario) {
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.subtotal = calcularSubtotal();
    }

    private BigDecimal calcularSubtotal() {
        return valorUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    @PrePersist
    @PreUpdate
    private void atualizarSubtotal() {
        this.subtotal = calcularSubtotal();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        this.subtotal = calcularSubtotal();
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
        this.subtotal = calcularSubtotal();
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}


