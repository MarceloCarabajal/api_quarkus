package com.mcarabajal.controller;

import com.mcarabajal.entity.Cliente;
import com.mcarabajal.repository.ClienteRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/api/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteApi {

    @Inject
    ClienteRepository clienteRepository;

    @GET
    public List<Cliente> getAllClientes() {
        return clienteRepository.listAll();
    }

    @POST
    public void createCliente(Cliente cliente) {
        clienteRepository.persist(cliente);
    }

    @GET
    @Path("/{id}")
    public Cliente getClienteById(@PathParam("id") Long id) {
        return clienteRepository.findById(id);
    }

    @DELETE
    @Path("/{id}")
    public void deleteCliente(@PathParam("id") Long id) {
        clienteRepository.deleteById(id);
    }
}
