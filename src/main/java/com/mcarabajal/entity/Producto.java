package com.mcarabajal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremental
    private long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private float precio;

    @Column(nullable = false)
    private int stock;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "producto_cliente",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    private List<Cliente> clientes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "categoria_id") // esto crea la clave foranea
    private Categoria categoria;

    public Producto() {
    }

    public Producto(String titulo, String descripcion, float precio, int stock) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }
}
