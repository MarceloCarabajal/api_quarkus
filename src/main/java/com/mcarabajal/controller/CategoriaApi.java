package com.mcarabajal.controller;

import com.mcarabajal.entity.Categoria;
import com.mcarabajal.repository.CategoriaRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/api/categorias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaApi {

    @Inject
    CategoriaRepository categoriaRepository;

    @GET
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.listAll();
    }

    @POST
    public void createCategoria(Categoria categoria) {
        categoriaRepository.persist(categoria);
    }

    @GET
    @Path("/{id}")
    public Categoria getCategoriaById(@PathParam("id") Long id) {
        return categoriaRepository.findById(id);
    }

    @DELETE
    @Path("/id")
    public void deleteCategoriaById(@PathParam("id") Long id) {
        categoriaRepository.deleteById(id);
    }
}
