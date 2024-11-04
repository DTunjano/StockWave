
package com.modelo;


public class Cliente extends Persona {
    private int id_cliente;

    public Cliente(int id_cliente, int id, String nombre_1, String nombre_2, String apellido_1, String apellido_2, String tipo_documento, String documento, String telefono) {
        super(id, nombre_1, nombre_2, apellido_1, apellido_2, tipo_documento, documento, telefono);
        this.id_cliente = id_cliente;
    }
    
    public Cliente() {
        super();
        this.id_cliente = 0;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return getNombre_1() +" "+getApellido_1();
    }
    
    
    
}
