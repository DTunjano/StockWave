
package com.modelo;

public class Producto {
    
    private int id;
    private int codigo_producto;
    private int categoria;
    private String nombre;
    private int cantidad;
    private boolean estado;
    private double valor_unitario;

    public Producto(int id, int codigo_producto, int categoria, String nombre, int cantidad, boolean estado, double valor_unitario) {
        this.id = id;
        this.codigo_producto = codigo_producto;
        this.categoria = categoria;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.estado = estado;
        this.valor_unitario = valor_unitario;
    }

    public Producto() {
        this.id = 0;
        this.codigo_producto = 0;
        this.categoria = 0;
        this.nombre = "";
        this.cantidad = 0;
        this.estado = false;
        this.valor_unitario = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }
    
    
}
