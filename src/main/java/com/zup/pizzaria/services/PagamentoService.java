package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.PagamentoDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.models.Pagamento;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.repository.ClienteRepository;
import com.zup.pizzaria.repository.PagamentoRepository;
import com.zup.pizzaria.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final PedidoRepository pedidoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository, PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.pedidoRepository = pedidoRepository;

    }

    public PagamentoDTO realizarPagamento(Pagamento pagamento) {
        if (pagamento == null) {
            throw new IllegalArgumentException("O pagamento não pode ser nulo.");
        }
        pagamentoRepository.save(pagamento);
        Pedido pedido = pedidoRepository.findById(pagamento.getPedidoId()).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        if (pagamento.getValorPago() < pedido.getValorTotal()) {
            throw new IllegalArgumentException("O valor pago não pode ser menor que o valor total do pedido.");
        }

        return new PagamentoDTO(pedido.getId(), pagamento.getFormaPagamento(), pagamento.getValorPago(), pagamento.getDataHoraPagamento());
    }
}