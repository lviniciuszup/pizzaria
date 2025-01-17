package com.zup.pizzaria.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Pedido pedidoId;
    private FormaPagamento formaPagamento;
    private Double valorPago;
    private LocalDateTime dataHoraPagamento;

    public Long getId(){
        return id;
    }
    public void setID(Long id){
        this.id = id;
    }

    public Pedido getPedidoId(){
        return pedidoId;
    }

    public void setPedidoId(Pedido pedidoId) {
        this.pedidoId = pedidoId;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDateTime getDataHoraPagamento() {
        return dataHoraPagamento;
    }

    public void setDataHoraPagamento(LocalDateTime dataHoraPagamento) {
        this.dataHoraPagamento = LocalDateTime.now();
    }

    public Pagamento(Long id, Pedido pedidoId, FormaPagamento formaPagamento, Double valorPago, LocalDateTime dataHoraPagamento) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.formaPagamento = formaPagamento;
        this.valorPago = valorPago;
        this.dataHoraPagamento = dataHoraPagamento;
    }
}
