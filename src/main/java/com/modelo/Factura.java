
package com.modelo;

public class Factura {
    private int id;
    private int id_empleado;
    private int id_venta;
    private int id_cliente;
    private int id_producto;
    private double subtotal;
    private double impuesto;

    public Factura(int id, int id_empleado, int id_venta, int id_cliente, int id_producto, double subtotal, double impuesto) {
        this.id = id;
        this.id_empleado = id_empleado;
        this.id_venta = id_venta;
        this.id_cliente = id_cliente;
        this.id_producto = id_producto;
        this.subtotal = subtotal;
        this.impuesto = impuesto;
    }
    
    public Factura() {
        this.id = 0;
        this.id_empleado = 0;
        this.id_venta = 0;
        this.id_cliente = 0;
        this.id_producto = 0;
        this.subtotal = 0;
        this.impuesto = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    
    
    
}
