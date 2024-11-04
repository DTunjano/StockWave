
package com.modelo;


public class Empleado extends Persona{
    private int id_empleado;
    private int id_cargo;

    public Empleado(int id_empleado, int id_cargo, int id, String nombre_1, String nombre_2, String apellido_1, String apellido_2, String tipo_documento, String documento, String telefono) {
        super(id, nombre_1, nombre_2, apellido_1, apellido_2, tipo_documento, documento, telefono);
        this.id_empleado = id_empleado;
        this.id_cargo = id_cargo;
    }
    
    public Empleado(int id_empleado, int id_cargo) {
        this.id_empleado = id_empleado;
        this.id_cargo = id_cargo;
    }
    
    public Empleado() {
        super();
        this.id_empleado = 0;
        this.id_cargo = 0;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    @Override
    public String toString() {
        return getNombre_1() +" "+getApellido_1();
    }
    
    
    
}
