package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> novoClienteController(@Valid @RequestBody ClienteDTO dadosCliente) {
        ClienteDTO novoCliente = clienteService.novoClienteService(dadosCliente);
        return ResponseEntity.ok().body(novoCliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listaClientesController() {
        List<ClienteDTO> listaClientes = clienteService.listaClientesService();
        return ResponseEntity.ok().body(listaClientes);

    }
}