package com.articulos.crud_articulos.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movimientos_stock")
public class MovimientoStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Long id;

    @Column(name = "id_articulo")
    private Long articuloId;

    @Column(name = "tipo_usuario") //
    private String tipoUsuario;

    @Column(name = "id_user")
    private Long userId;
    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "tipo_movimiento") // Entrada o Salida
    private String tipoMovimiento;

    @Column(name = "fecha_movimiento")
    private Date fecha;



    // Constructor
    public MovimientoStock() {
        // Puedes inicializar valores por defecto si es necesario
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(Long articuloId) {
        this.articuloId = articuloId;
    }

    public Long getUserId() { // Getter para userId
        return userId;
    }

    public void setUserId(Long userId) { // Setter para userId
        this.userId = userId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String userType) {
        this.tipoUsuario = tipoUsuario;
    }
}
