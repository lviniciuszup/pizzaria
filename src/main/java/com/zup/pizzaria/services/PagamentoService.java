package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.PedidoDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.repository.PagamentoRepository;
import com.zup.pizzaria.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {
    private final PedidoRepository pedidoRepository;
    private final PagamentoRepository pagamentoRepository;


    public PagamentoService(PedidoRepository pedidoRepository,PagamentoRepository pagamentoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.pagamentoRepository = pagamentoRepository;
    }

    public PedidoDTO criarPedido(Pedido pedido) {

    }
}
