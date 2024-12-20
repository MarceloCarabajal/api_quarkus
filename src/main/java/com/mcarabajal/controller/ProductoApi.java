package com.mcarabajal.controller;

import com.mcarabajal.entity.Producto;
import com.mcarabajal.repository.ProductoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/productos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductoApi {

    @Inject
    ProductoRepository productoRepository;

    @GET
    public List<Producto> getAllProductos() {
        return productoRepository.listAll();
    }

    @POST
    @Transactional
    public Response createProducto(Producto producto) {
        try {
            productoRepository.persist(producto);
            return Response.status(Response.Status.CREATED).entity(producto).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al crear el producto: " + e.getMessage()).build();
        }
    }

    @GET
    @Transactional
    @Path("/{id}")
    public Producto getProductoById(@PathParam("id") Long id) {
        return productoRepository.findById(id);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void deleteProductoById(@PathParam("id") Long id) {
        productoRepository.deleteById(id);
    }
}
