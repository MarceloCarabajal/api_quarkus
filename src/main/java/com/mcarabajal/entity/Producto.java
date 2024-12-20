package com.mcarabajal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremental
    private long id;

    private String titulo;

    private String descripcion;

    private float precio;

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
