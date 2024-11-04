
package com.controladores;

import com.controladores.CRUDS.CRUDProducto;
import com.modelo.Producto;
import com.vista.AddProductoInventarioGUI;
import com.vista.EliminarProducto;
import com.vista.Menu_Interfaz;
import com.vista.ModificarProductoInventario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ContInventario implements ActionListener {
    
    private final Producto modelo;
    private final CRUDProducto consultas;
    private final Menu_Interfaz menu;
    private final AddProductoInventarioGUI vista;
    private final EliminarProducto vistaEliminar;
    private final ModificarProductoInventario vistaModificar;

    public ContInventario(Producto modelo, CRUDProducto consultas, Menu_Interfaz menu, AddProductoInventarioGUI vista, EliminarProducto vistaEliminar, ModificarProductoInventario vistaModificar) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.menu = menu;
        this.vista = vista;
        this.vistaEliminar = vistaEliminar;
        this.vistaModificar = vistaModificar;
        
        this.menu.bttAddProductoInventario.addActionListener(this);
        this.menu.bttEliminarProductoInventario.addActionListener(this);
        this.menu.bttModificarProductoInventario.addActionListener(this);
        this.vista.bttAddInventario.addActionListener(this);
        this.vista.bttCancelarInventario.addActionListener(this);
        this.vistaEliminar.bttEliminarInventario.addActionListener(this);
        this.vistaEliminar.bttEliminarBuscarProductoInventario.addActionListener(this);
        this.vistaEliminar.bttCancelarInventario.addActionListener(this);
        this.vistaModificar.bttAceptar.addActionListener(this);
        this.vistaModificar.bttCancelar.addActionListener(this);
        this.vistaModificar.bttBuscar.addActionListener(this);
        //this.vista.btnEliminar.addActionListener(this);
        //this.vista.btnLimpiar.addActionListener(this);
        //this.vista.btnBuscar.addActionListener(this);
        
    }

    public void iniciar() {
        menu.setTitle("StockWave");
        vista.setLocationRelativeTo(null);
        //vista.txtId.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Inicio botones del Tabbed Inventario
        if (e.getSource() == menu.bttAddProductoInventario) vista.setVisible(true);
        
        if (e.getSource() == vista.bttAddInventario) {
            
            try{
                modelo.setCodigo_producto(Integer.parseInt(vista.txtCodigoProductoInventario.getText()));
                modelo.setCategoria((vista.cbxCategoria.getItemAt(vista.cbxCategoria.getSelectedIndex()).getId()));
                modelo.setNombre(vista.txtNombreProductoInventario.getText());
                modelo.setCantidad(Integer.parseInt(vista.txtCantidadProductoInventario.getText()));
                //modelo.setCategoria(Integer.parseInt(vista.txtCategoriaProductoInventario.getText()));
                modelo.setValor_unitario(Double.parseDouble(vista.txtValorProductoInventario.getText()));
                modelo.setEstado(true);
                
                if(modelo.getCantidad()>=0){
                    if(modelo.getValor_unitario()>0){
                        if (consultas.registrar(modelo)) {
                            Object[] fila = {modelo.getCodigo_producto(),modelo.getCategoria(), modelo.getNombre(), modelo.getCantidad(), modelo.isEstado(), modelo.getValor_unitario()};
                            menu.getModeloInventario().addRow(fila);
                            menu.eliminarDatosTablaInventario();
                            menu.mostrarDatosTablaInventario();
                            JOptionPane.showMessageDialog(null, "Registro Guardado");
                            limpiar();
                            vista.setVisible(false);
                        }
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "El valor unitario debe ser mayor a 0", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                }else {
                    JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                }
            
            } catch (NumberFormatException z) {
                JOptionPane.showMessageDialog(null, "Verifique que el codigo, cantidad y valor sean valores numericos enteros.", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == vista.bttCancelarInventario) {
            limpiar();
            vista.setVisible(false);
        }
        

        if (e.getSource() == menu.bttEliminarProductoInventario) vistaEliminar.setVisible(true);
        
        if(e.getSource() == vistaEliminar.bttEliminarBuscarProductoInventario) {
            
            try{
                modelo.setCodigo_producto(Integer.parseInt(vistaEliminar.txtEliminarCodigoProductoInventario.getText()));
                if(consultas.buscar(modelo)){
                    //vistaEliminar.txtEliminarCategoriaProductoInventario.setText(String.valueOf(modelo.getCategoria()));
                    vistaEliminar.cbxCategoria.setSelectedIndex(modelo.getCategoria()-1);
                    vistaEliminar.txtEliminarNombreProductoInventario.setText(String.valueOf(modelo.getNombre()));
                    vistaEliminar.txtEliminarCantidadProductoInventario.setText(String.valueOf(modelo.getCantidad()));
                    vistaEliminar.txtEliminarValorProductoInventario.setText(String.valueOf((int) modelo.getValor_unitario()));
                }
                else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningun producto por el codigo: " + modelo.getCodigo_producto(), "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(NumberFormatException z){
                JOptionPane.showMessageDialog(null, "Verifique que el codigo, cantidad y valor sean valores numericos.", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
        if (e.getSource() == vistaEliminar.bttEliminarInventario){
            try{
                modelo.setCodigo_producto(Integer.parseInt(vistaEliminar.txtEliminarCodigoProductoInventario.getText()));
                
                if (consultas.eliminar(modelo)) {
                    vistaEliminar.txtEliminarCodigoProductoInventario.setText(null);
                    //vistaEliminar.txtEliminarCategoriaProductoInventario.setText(null);
                    vistaEliminar.txtEliminarNombreProductoInventario.setText(null);
                    vistaEliminar.txtEliminarValorProductoInventario.setText(null);
                    vistaEliminar.txtEliminarCantidadProductoInventario.setText(null);

                    for (int i = 0; i < menu.getModeloInventario().getRowCount(); i++) {
                        int codigo = (int) menu.getModeloInventario().getValueAt(i, 0);

                        if(codigo == modelo.getCodigo_producto()){
                            menu.getModeloInventario().removeRow(i);
                            menu.getModeloInventario().fireTableDataChanged();
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
                    vistaEliminar.setVisible(false);
                }
            } catch (NumberFormatException z){
                JOptionPane.showMessageDialog(null, "Verifique que el codigo sea un valor numerico entero", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
            }

        }
        
        if (e.getSource() == vistaEliminar.bttCancelarInventario) {
            vistaEliminar.txtEliminarCodigoProductoInventario.setText(null);
            vistaEliminar.setVisible(false);
        }
        
        if (e.getSource() == menu.bttModificarProductoInventario){
            vistaModificar.txtCodigoNuevoProductoInventario.setEnabled(false);
            vistaModificar.cbxCategoriaModificarInventario.setEnabled(false);
            vistaModificar.txtNombreProductoInventario.setEnabled(false);
            vistaModificar.txtCantidadProductoInventario.setEnabled(false);
            vistaModificar.txtVisibilidad.setEnabled(false);
            vistaModificar.txtValorProductoInventario.setEnabled(false);
            vistaModificar.setVisible(true);
        }
        
        if (e.getSource() == vistaModificar.bttBuscar){
            try{
                modelo.setCodigo_producto(Integer.parseInt(vistaModificar.txtCodigoProductoAntiguo.getText()));    
                if(consultas.buscar(modelo)){
                    vistaModificar.txtCodigoNuevoProductoInventario.setEnabled(true);
                    vistaModificar.cbxCategoriaModificarInventario.setEnabled(true);
                    vistaModificar.txtNombreProductoInventario.setEnabled(true);
                    vistaModificar.txtCantidadProductoInventario.setEnabled(true);
                    vistaModificar.txtVisibilidad.setEnabled(true);
                    vistaModificar.txtValorProductoInventario.setEnabled(true);
                    
                    vistaModificar.cbxCategoriaModificarInventario.setSelectedIndex(modelo.getCategoria()-1);
                    //vistaModificar.txtCategoriaProductoInventario.setText(String.valueOf(modelo.getCategoria()));
                    vistaModificar.txtNombreProductoInventario.setText(String.valueOf(modelo.getNombre()));
                    vistaModificar.txtCantidadProductoInventario.setText(String.valueOf(modelo.getCantidad()));
                    vistaModificar.txtVisibilidad.setText(String.valueOf(modelo.isEstado()));
                    vistaModificar.txtValorProductoInventario.setText(String.valueOf((int) modelo.getValor_unitario()));
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningun producto por el codigo: " + modelo.getCodigo_producto(), "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException z){
                JOptionPane.showMessageDialog(null, "Solo se pueden ingresar numero enteros");
            }
            
        }
        
        if(e.getSource() == vistaModificar.bttAceptar){
            
            try{
                modelo.setCodigo_producto(Integer.parseInt(vistaModificar.txtCodigoNuevoProductoInventario.getText()));
                modelo.setCategoria((vistaModificar.cbxCategoriaModificarInventario.getItemAt(vistaModificar.cbxCategoriaModificarInventario.getSelectedIndex()).getId()));
                //modelo.setCategoria(Integer.parseInt(vistaModificar.txtCategoriaProductoInventario.getText()));
                modelo.setNombre(String.valueOf(vistaModificar.txtNombreProductoInventario.getText()));
                modelo.setCantidad(Integer.parseInt(vistaModificar.txtCantidadProductoInventario.getText()));
                modelo.setEstado(Boolean.parseBoolean(vistaModificar.txtVisibilidad.getText()));
                modelo.setValor_unitario(Double.parseDouble(vistaModificar.txtValorProductoInventario.getText()));
                int codigoAntiguo = Integer.parseInt(vistaModificar.txtCodigoProductoAntiguo.getText());
                
                if(modelo.getCantidad()>=0){
                    if(modelo.getValor_unitario()>0){
                        if(consultas.modificar(modelo, codigoAntiguo))
                        {
                            for (int i = 0; i < menu.getModeloInventario().getRowCount(); i++) {
                                int codigo = (int) menu.getModeloInventario().getValueAt(i, 0);

                                if(codigo == codigoAntiguo){
                                menu.getModeloInventario().removeRow(i);
                                menu.getModeloInventario().fireTableDataChanged();
                                }   
                            }

                            Object[] fila = {modelo.getCodigo_producto(), modelo.getCategoria(), modelo.getNombre(), modelo.getCantidad(), modelo.isEstado(), modelo.getValor_unitario()};
                            menu.getModeloInventario().addRow(fila);
                            menu.eliminarDatosTablaInventario();
                            menu.mostrarDatosTablaInventario();

                            JOptionPane.showMessageDialog(null, "Se ha modificado correctamente.","Informacion",JOptionPane.INFORMATION_MESSAGE);
                            vistaModificar.txtCodigoNuevoProductoInventario.setText(null);
                            //vistaModificar.txtCategoriaProductoInventario.setText(null);
                            vistaModificar.txtNombreProductoInventario.setText(null);
                            vistaModificar.txtCantidadProductoInventario.setText(null);
                            vistaModificar.txtVisibilidad.setText(null);
                            vistaModificar.txtValorProductoInventario.setText(null);
                            vistaModificar.txtCodigoProductoAntiguo.setText(null);

                            vistaModificar.setVisible(false);
                        }
                        
                    }else {
                        JOptionPane.showMessageDialog(null, "El valor unitario debe ser mayor a 0", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch (NumberFormatException z) {
                JOptionPane.showMessageDialog(null, "Verifique que el codigo antiguo, el codigo nuevo, la cantidad y el valor sean valores numericos enteros", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        if(e.getSource() == vistaModificar.bttCancelar){
            vistaModificar.txtCodigoNuevoProductoInventario.setText(null);
            //vistaModificar.txtCategoriaProductoInventario.setText(null);
            vistaModificar.txtNombreProductoInventario.setText(null);
            vistaModificar.txtCantidadProductoInventario.setText(null);
            vistaModificar.txtVisibilidad.setText(null);
            vistaModificar.txtValorProductoInventario.setText(null);
            vistaModificar.txtCodigoProductoAntiguo.setText(null);
            vistaModificar.setVisible(false);
        }
        //Fin de botones Tabbed Inventario
        
        //Inicio Botones Tabbed Ventas
        if(e.getSource() == menu.bttAgregarVenta){
            System.out.println("hola");
            
            int cantidad = 0;
            try{
                modelo.setCodigo_producto(Integer.parseInt(menu.txtVentaCodigoProducto.getText()));
                cantidad = Integer.parseInt(menu.txtVentaCantidadProducto.getText());
                
                if(consultas.buscar(modelo)){
                    if(modelo.getCantidad()-cantidad<0)
                        System.out.println("sexo");
                } else {
                    JOptionPane.showMessageDialog(null, "El producto con codigo: "+modelo.getCodigo_producto()+" no existe");
                }
                
            }catch(NumberFormatException z){
                JOptionPane.showMessageDialog(null, "Verifique que el codigo y la cantidad sean valores numericos enteros", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
    }
        
    
    public void limpiar() {
        vista.txtCodigoProductoInventario.setText(null);
        //vista.txtCategoriaProductoInventario.setText(null);
        vista.txtNombreProductoInventario.setText(null);
        vista.txtCantidadProductoInventario.setText(null);
        vista.txtValorProductoInventario.setText(null);
    }
     
}
