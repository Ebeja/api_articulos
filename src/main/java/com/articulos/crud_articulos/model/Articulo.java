package com.articulos.crud_articulos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "articulos")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_articulo")
    private Long idArticulo;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "precio_producto", nullable = false)
    private Double precio_producto;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    // Constructor vacío (necesario para JPA)
    public Articulo() {
        this.precio_producto = 0.0; // Establece un valor predeterminado
    }

    // Constructor con todos los campos
    public Articulo(Long idArticulo, String nombre, String descripcion, Double precio_producto, Integer stock) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_producto = (precio_producto != null) ? precio_producto : 0.0; // Establece 0.0 si es nulo
        this.stock = stock;
    }

    // Getters y Setters
    public Long getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @JsonProperty("precio_producto")
    public Double getPrecioProducto() {
        return precio_producto;
    }

    public void setPrecioProducto(Double precio_producto) {
        this.precio_producto = precio_producto;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
