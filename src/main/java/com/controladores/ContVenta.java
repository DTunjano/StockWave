
package com.controladores;

import com.controladores.CRUDS.CRUDFactura;
import com.controladores.CRUDS.CRUDProducto;
import com.controladores.CRUDS.CRUDVenta;
import com.modelo.Factura;
import com.modelo.Producto;
import com.modelo.Venta;
import com.vista.EliminarVenta;
import com.vista.Menu_Interfaz;
import com.vista.ModificarProductoVenta;
import com.vista.PuntoCobro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;


public class ContVenta implements ActionListener{
    private final Producto modelo;
    private final CRUDProducto consultas;
    private final Menu_Interfaz menu;
    private final ModificarProductoVenta modificarVenta;
    private final EliminarVenta eliminarVenta; 
    private final PuntoCobro puntoCobro;
    private final Venta venta;
    private final Factura factura;
    private final CRUDVenta consultasVenta;
    private final CRUDFactura consultasFactura;
    
    double total = 0;
    java.util.Date fechaActual = Calendar.getInstance().getTime();
    java.sql.Date sqlDate = new java.sql.Date(fechaActual.getTime());

    public ContVenta(Producto modelo, CRUDProducto consultas, Menu_Interfaz menu, ModificarProductoVenta modificarVenta, EliminarVenta eliminarVenta, PuntoCobro puntoCobro, Venta venta, Factura factura, CRUDVenta consultasVenta, CRUDFactura consultasFactura) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.menu = menu;
        this.modificarVenta = modificarVenta;
        this.eliminarVenta = eliminarVenta;
        this.puntoCobro = puntoCobro;
        this.venta = venta;
        this.factura = factura;
        this.consultasVenta = consultasVenta;
        this.consultasFactura = consultasFactura;
        
        this.menu.bttAgregarVenta.addActionListener(this);
        this.menu.bttEliminarVenta.addActionListener(this);
        this.menu.bttModificarVenta.addActionListener(this);
        this.menu.bttLimpiarVenta.addActionListener(this);
        this.menu.bttCobrarVenta.addActionListener(this);
        this.modificarVenta.bttAceptar.addActionListener(this);
        this.modificarVenta.bttBuscar.addActionListener(this);
        this.modificarVenta.bttCancelar.addActionListener(this);
        this.eliminarVenta.bttAceptar.addActionListener(this);
        this.eliminarVenta.bttBuscar.addActionListener(this);
        this.eliminarVenta.bttCancelar.addActionListener(this);
        this.puntoCobro.bttAceptar.addActionListener(this);
        this.puntoCobro.bttCancelar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == menu.bttAgregarVenta){
            int cantidad;
            double subtotal;
            total = 0;
            boolean validador = false;
            boolean validaDuplicidad = false;
            
            try{
                modelo.setCodigo_producto(Integer.parseInt(menu.txtVentaCodigoProducto.getText()));
                cantidad = Integer.parseInt(menu.txtVentaCantidadProducto.getText());
                
                if(consultas.buscar(modelo)){
                    
                    for (int i = 0; i < menu.getModeloInventario().getRowCount(); i++) {
                        
                        if((int) menu.getModeloInventario().getValueAt(i, 0) == modelo.getCodigo_producto()){
                            if((int) menu.getModeloInventario().getValueAt(i, 3) - cantidad >= 0){
                                validador = true;
                                break;
                            }
                        }
                    }
                    
                    for (int i = 0; i < menu.getModeloVenta().getRowCount(); i++) {
                        if((int) menu.getModeloVenta().getValueAt(i, 0) == modelo.getCodigo_producto()){
                            validaDuplicidad = true;
                        }
                        
                    }
                    if (cantidad>0){
                        if(!validaDuplicidad){
                            if(validador){
                                subtotal = cantidad * modelo.getValor_unitario();
                                Object[] fila = {modelo.getCodigo_producto(), modelo.getNombre(), cantidad, modelo.getValor_unitario(), subtotal};
                                menu.getModeloVenta().addRow(fila);
                                menu.getModeloVenta().fireTableDataChanged();

                                for (int i = 0; i < menu.getModeloVenta().getRowCount(); i++) {
                                    total += (double) menu.getModeloVenta().getValueAt(i, 4);
                                }

                                menu.txtTotal.setText(String.valueOf(total));
                                
                                menu.txtVentaCodigoProducto.setText(null);
                                menu.txtVentaCantidadProducto.setText(null);
                                System.out.println(menu.getModeloVenta().getRowCount());

                            } else {
                                JOptionPane.showMessageDialog(null, "No hay las suficientes existencias del producto: "+modelo.getNombre(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Ya se ha registrado un producto: "+modelo.getCodigo_producto()+". Si quiere modificar este producto, pulse el boton Modificar");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "La cantidad del producto tiene que ser mayor a 0");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El producto con codigo: "+modelo.getCodigo_producto()+" no existe");
                }
                
            }catch(NumberFormatException z){
                JOptionPane.showMessageDialog(null, "Verifique que el codigo y la cantidad sean valores numericos enteros", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        if(e.getSource() == menu.bttModificarVenta){
            modificarVenta.setVisible(true);
            modificarVenta.txtCantidad.setEnabled(false);
            modificarVenta.txtNombre.setEnabled(false);
            modificarVenta.txtValorUnitario.setEnabled(false);
        }
        
        if(e.getSource() == modificarVenta.bttBuscar){
            try{
                modelo.setCodigo_producto(Integer.parseInt(modificarVenta.txtCodigo.getText()));
                
                if(menu.getModeloVenta().getRowCount()> 0){
                    
                    for (int i = 0; i < menu.getModeloVenta().getRowCount(); i++) {
                        if((int) menu.getModeloVenta().getValueAt(i, 0) == modelo.getCodigo_producto()){
                            modificarVenta.txtCantidad.setEnabled(true);
                            modificarVenta.txtNombre.setText(String.valueOf(menu.getModeloVenta().getValueAt(i, 1)));
                            modificarVenta.txtCantidad.setText(String.valueOf(menu.getModeloVenta().getValueAt(i, 2)));
                            modificarVenta.txtValorUnitario.setText(String.valueOf(menu.getModeloVenta().getValueAt(i, 3)));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró ningun producto: "+modelo.getCodigo_producto()+" registrado en el punto de venta ", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } 
                } else{
                    JOptionPane.showMessageDialog(null, "No hay productos registrados en el punto de venta");
                }
                
            } catch (NumberFormatException z){
                JOptionPane.showMessageDialog(null, "Verifique que el codigo y la cantidad sean valores numericos enteros", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        if(e.getSource() == modificarVenta.bttAceptar){
            double subtotal;
            total = 0;
            boolean validador = false;
            
            try{
                modelo.setCodigo_producto(Integer.parseInt(modificarVenta.txtCodigo.getText()));
                
                if(Integer.parseInt(modificarVenta.txtCantidad.getText())>0){
                    
                    
                    
                    modelo.setNombre(modificarVenta.txtNombre.getText());
                    modelo.setCantidad(Integer.parseInt(modificarVenta.txtCantidad.getText()));
                    modelo.setValor_unitario(Double.parseDouble(modificarVenta.txtValorUnitario.getText()));
                    subtotal = modelo.getCantidad()*modelo.getValor_unitario();
                    
                    for (int i = 0; i < menu.getModeloInventario().getRowCount(); i++) {
                        
                        if((int) menu.getModeloInventario().getValueAt(i, 0) == modelo.getCodigo_producto()){
                            if((int) menu.getModeloInventario().getValueAt(i, 3) - modelo.getCantidad() >= 0){
                                validador = true;
                                break;
                            }
                        }
                    }
                    
                    if(validador){
                        Object[] fila = {modelo.getCodigo_producto(), modelo.getNombre(), modelo.getCantidad(), modelo.getValor_unitario(), subtotal};

                        for (int i = 0; i < menu.getModeloVenta().getRowCount(); i++) {
                            if((int) menu.getModeloVenta().getValueAt(i, 0) == modelo.getCodigo_producto()){
                                menu.getModeloVenta().removeRow(i);
                                menu.getModeloVenta().insertRow(i, fila);
                                menu.getModeloVenta().fireTableDataChanged();
                                break;
                            }
                        }

                        for (int i = 0; i < menu.getModeloVenta().getRowCount(); i++) {
                            total += (double) menu.getModeloVenta().getValueAt(i, 4);
                        }

                        modificarVenta.txtCodigo.setText(null);
                        modificarVenta.txtNombre.setText(null);
                        modificarVenta.txtCantidad.setText(null);
                        modificarVenta.txtValorUnitario.setText(null);
                        menu.txtTotal.setText(String.valueOf(total));
                        modificarVenta.setVisible(false);
                        
                    } else{
                        JOptionPane.showMessageDialog(null, "No hay las suficientes existencias del producto: "+modelo.getNombre(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(NumberFormatException z){
                JOptionPane.showMessageDialog(null, "Verifique que el codigo y la cantidad sean valores numericos enteros", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        if(e.getSource() == modificarVenta.bttCancelar){
            modificarVenta.txtCodigo.setText(null);
            modificarVenta.txtNombre.setText(null);
            modificarVenta.txtCantidad.setText(null);
            modificarVenta.txtValorUnitario.setText(null);
            modificarVenta.setVisible(false);
        }
        
        if(e.getSource() == menu.bttEliminarVenta){
            eliminarVenta.txtNombre.setEnabled(false);
            eliminarVenta.txtCantidad.setEnabled(false);
            eliminarVenta.txtValorUnitario.setEnabled(false);
            eliminarVenta.setVisible(true);
        }
        
        if(e.getSource() == eliminarVenta.bttBuscar){
            try{
                modelo.setCodigo_producto(Integer.parseInt(eliminarVenta.txtCodigo.getText()));
                
                if(menu.getModeloVenta().getRowCount()> 0){
                    
                    for (int i = 0; i < menu.getModeloVenta().getRowCount(); i++) {
                        if((int) menu.getModeloVenta().getValueAt(i, 0) == modelo.getCodigo_producto()){
                            eliminarVenta.txtNombre.setText(String.valueOf(menu.getModeloVenta().getValueAt(i, 1)));
                            eliminarVenta.txtCantidad.setText(String.valueOf(menu.getModeloVenta().getValueAt(i, 2)));
                            eliminarVenta.txtValorUnitario.setText(String.valueOf(menu.getModeloVenta().getValueAt(i, 3)));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró ningun producto: "+modelo.getCodigo_producto()+" registrado en el punto de venta ", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } 
                } else{
                    JOptionPane.showMessageDialog(null, "No hay productos registrados en el punto de venta");
                }
            } catch (NumberFormatException z) {
                JOptionPane.showMessageDialog(null, "Verifique que el codigo sea un valor numerico entero", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        if(e.getSource() == eliminarVenta.bttAceptar){
            total = 0;
            
            try{
                modelo.setCodigo_producto(Integer.parseInt(eliminarVenta.txtCodigo.getText()));
                
                if(menu.getModeloVenta().getRowCount()> 0){
                    
                    for (int i = 0; i < menu.getModeloVenta().getRowCount(); i++) {
                        if((int) menu.getModeloVenta().getValueAt(i, 0) == modelo.getCodigo_producto()){
                            menu.getModeloVenta().removeRow(i);
                            menu.getModeloVenta().fireTableDataChanged();
                            break;
                        }
                    }
                    
                    for (int i = 0; i < menu.getModeloVenta().getRowCount(); i++) {
                        total += (double) menu.getModeloVenta().getValueAt(i, 4);
                    }
                    
                    eliminarVenta.txtCodigo.setText(null);
                    eliminarVenta.txtNombre.setText(null);
                    eliminarVenta.txtCantidad.setText(null);
                    eliminarVenta.txtValorUnitario.setText(null);
                    menu.txtTotal.setText(String.valueOf(total));
                    eliminarVenta.setVisible(false);
                    
                } else{
                    JOptionPane.showMessageDialog(null, "No hay productos registrados en el punto de venta");
                }
            }catch(NumberFormatException z){
                JOptionPane.showMessageDialog(null, "Verifique que el codigo sea un valor numerico entero", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        if(e.getSource() == eliminarVenta.bttCancelar){
            eliminarVenta.txtCodigo.setText(null);
            eliminarVenta.txtNombre.setText(null);
            eliminarVenta.txtCantidad.setText(null);
            eliminarVenta.txtValorUnitario.setText(null);
            eliminarVenta.setVisible(false);
        }
        
        if(e.getSource() == menu.bttLimpiarVenta){
            
            for (int i = menu.getModeloVenta().getRowCount() - 1; i >= 0; i--) {
                menu.getModeloVenta().removeRow(i);
            }
            
            menu.txtVentaCodigoProducto.setText(null);
            menu.txtVentaCantidadProducto.setText(null);
            menu.txtTotal.setText("0");
            total = 0;
        }
        
        if(e.getSource() == menu.bttCobrarVenta){
            if(total>0){
                puntoCobro.txtFecha.setText(menu.fecha());
                puntoCobro.txtImpuesto.setText("19");
                puntoCobro.txtTotalCobro.setText(String.valueOf(total));
                puntoCobro.txtFecha.setEnabled(false);
                puntoCobro.txtImpuesto.setEnabled(false);
                puntoCobro.txtTotalCobro.setEnabled(false);
                puntoCobro.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "No hay productos en el punto de venta para cobrar", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }   
        }
        
        if(e.getSource() == puntoCobro.bttAceptar){
            double pago;
            int codigo;
            int cantidad;
            
            try{
                pago = Double.parseDouble(puntoCobro.txtPago.getText());
                total = Double.parseDouble(puntoCobro.txtTotalCobro.getText());
                
                if(pago>=Double.parseDouble(puntoCobro.txtTotalCobro.getText()))
                {   
                    venta.setFecha(sqlDate);  
                    System.out.println(total);
                    venta.setTotal(total);
                    consultasVenta.registrar(venta);
                    
                    int idVenta = consultasVenta.registrarVentaGeneral();
                    
                    for (int i = 0; i < menu.getModeloVenta().getRowCount(); i++) {
                        modelo.setCodigo_producto((int) menu.getModeloVenta().getValueAt(i, 0));
                        consultas.buscar(modelo);
                        factura.setId_cliente(puntoCobro.cbxCliente.getItemAt(puntoCobro.cbxCliente.getSelectedIndex()).getId_cliente());
                        factura.setId_empleado(puntoCobro.cbxEmpleado.getItemAt(puntoCobro.cbxEmpleado.getSelectedIndex()).getId_empleado());
                        factura.setId_producto(modelo.getId());
                        factura.setId_venta(idVenta);
                        factura.setImpuesto(Double.parseDouble(puntoCobro.txtImpuesto.getText()));
                        factura.setSubtotal((double) menu.getModeloVenta().getValueAt(i, 4));
                        consultasFactura.registrar(factura);
                        
                        cantidad = modelo.getCantidad() - (int) menu.getModeloVenta().getValueAt(i, 2);
                        modelo.setCantidad(cantidad);
                        consultas.modificarCantidad(modelo, modelo.getCodigo_producto());
                        
                        for (int j = 0; j < menu.getModeloInventario().getRowCount(); j++) {
                            if(modelo.getCodigo_producto() == (int)menu.getModeloInventario().getValueAt(j, 0)){
                                menu.getModeloInventario().removeRow(j);
                                Object[] fila = {modelo.getCodigo_producto(), modelo.getCategoria(), modelo.getNombre(), modelo.getCantidad(), modelo.isEstado(), modelo.getValor_unitario()};
                                menu.getModeloInventario().insertRow(j, fila);
                            }
                        }
                    }
                    
                    for (int i = menu.getModeloVenta().getRowCount() - 1; i >= 0; i--) {
                        menu.getModeloVenta().removeRow(i);
                    }

                    menu.txtVentaCodigoProducto.setText(null);
                    menu.txtVentaCantidadProducto.setText(null);
                    menu.txtTotal.setText("0");
                    puntoCobro.txtFecha.setText(null);
                    puntoCobro.txtImpuesto.setText(null);
                    puntoCobro.txtPago.setText(null);
                    puntoCobro.txtTotalCobro.setText(null);
                    
                    puntoCobro.setVisible(false);
                    
                    
                } else {
                    JOptionPane.showMessageDialog(null, "El pago no puede ser menor al total a pagar", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                }
                
            } catch (NumberFormatException z){
                JOptionPane.showMessageDialog(null, "Verifique que el pago sea un valor numerico entero", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        if(e.getSource() == puntoCobro.bttCancelar){
            puntoCobro.txtFecha.setText(null);
            puntoCobro.txtImpuesto.setText(null);
            puntoCobro.txtPago.setText(null);
            puntoCobro.txtTotalCobro.setText(null);
            puntoCobro.setVisible(false);
        }
    }
}
