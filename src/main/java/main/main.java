
package main;

import com.controladores.CRUDS.CRUDFactura;
import com.controladores.ContInventario;
import com.controladores.ContVenta;
import com.controladores.CRUDS.CRUDProducto;
import com.controladores.CRUDS.CRUDVenta;
import com.modelo.Factura;
import com.modelo.Producto;
import com.modelo.Venta;
import com.vista.AddProductoInventarioGUI;
import com.vista.EliminarProducto;
import com.vista.EliminarVenta;
import com.vista.Menu_Interfaz;
import com.vista.ModificarProductoInventario;
import com.vista.ModificarProductoVenta;
import com.vista.PuntoCobro;

public class main {
    public static void main(String[] args) {

        Producto modelo = new Producto();
        CRUDProducto consultas = new CRUDProducto();
        Menu_Interfaz menu = new Menu_Interfaz();
        AddProductoInventarioGUI vista = new AddProductoInventarioGUI();
        EliminarProducto vistaEliminar = new EliminarProducto();
        ModificarProductoInventario vistaModificar = new ModificarProductoInventario();
        ModificarProductoVenta ventaModificar = new ModificarProductoVenta();
        EliminarVenta eliminarVenta = new EliminarVenta();
        PuntoCobro puntoCobro = new PuntoCobro();
        Venta venta = new Venta();
        Factura factura = new Factura();
        CRUDVenta crudventa = new CRUDVenta();
        CRUDFactura crudfactura = new CRUDFactura();

        ContInventario controlador = new ContInventario(modelo, consultas, menu, vista, vistaEliminar, vistaModificar);
        ContVenta controladorVenta = new ContVenta(modelo, consultas, menu, ventaModificar, eliminarVenta, puntoCobro, venta, factura, crudventa, crudfactura);
        controlador.iniciar();
        menu.txtFechaInv.setText(menu.fecha());
        menu.txtFechaActualVenta.setText(menu.fecha());
        menu.setVisible(true);
    }
}
