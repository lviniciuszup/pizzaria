package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.ClientePostDTO;
import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public ClienteDTO novoClienteService(ClientePostDTO novoCliente) {
        Cliente novoClienteEntidade = novoCliente.dtoCliente();
        Cliente criaNovoCliente = clienteRepository.save(novoClienteEntidade);
        return ClienteDTO.dtoCliente(criaNovoCliente);

    }

    public List<ClienteDTO> listaClientesService() {
        List<Cliente> todosClientes = clienteRepository.findAll();
        return todosClientes.stream()
                .map(ClienteDTO::dtoCliente).toList();
    }

}