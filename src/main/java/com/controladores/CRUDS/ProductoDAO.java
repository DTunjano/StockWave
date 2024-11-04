package com.controladores.CRUDS;
import com.modelo.Producto;


public interface ProductoDAO {
    boolean registrar(Producto pro);
    boolean modificar(Producto pro, int n);
    boolean modificarCantidad(Producto pro, int codigo);
    boolean eliminar(Producto pro);
    boolean buscar(Producto pro);
}

