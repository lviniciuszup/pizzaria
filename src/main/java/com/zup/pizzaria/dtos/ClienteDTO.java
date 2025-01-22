package com.zup.pizzaria.dtos;

import com.zup.pizzaria.models.Cliente;

public record ClienteDTO(Long id, String nome, String email) {

    public static ClienteDTO dtoCliente (Cliente cliente) {
        return new ClienteDTO(
                cliente.getId(), cliente.getNome(), cliente.getEmail()
        );
    }
}