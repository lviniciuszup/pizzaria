package com.zup.pizzaria.dtos;

import com.zup.pizzaria.models.Cliente;

public record ClientePostDTO(String nome, String email) {

    public Cliente dtoCliente() {
        validar();
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(nome);
        novoCliente.setEmail(email);
        return novoCliente;
    }

    private void validar() {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode estar vazio ou nulo");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("O e-mail não pode estar vazio ou nulo");
        }
        if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("E-mail não é válido");
        }
    }
}
