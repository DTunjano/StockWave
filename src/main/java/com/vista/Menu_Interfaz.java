
package com.vista;

import com.controladores.conexionbd.Conexion_postgreSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Menu_Interfaz extends javax.swing.JFrame {
    
    DefaultTableModel modeloInventario = new DefaultTableModel();
    DefaultTableModel modeloVenta = new DefaultTableModel();
    TableRowSorter<DefaultTableModel> sorter;
    private final Conexion_postgreSQL conexionPostgres = Conexion_postgreSQL.getInstance();

    public Menu_Interfaz() {
        initComponents();
        sorter = new TableRowSorter<>(modeloInventario);
        tbl_inventario.setRowSorter(sorter);
        formaTablaInventario();
        mostrarDatosTablaInventario();
        formaTablaVenta();
    }
    
    public String fecha(){
        Date fecha = new Date();
        SimpleDateFormat df = new SimpleDateFormat("YYYY/MM/dd");
        return df.format(fecha);
    }
    
    public void buscarProducto(String buscar){
        sorter.setRowFilter(RowFilter.regexFilter(buscar));
    }
    
    public final void formaTablaInventario()
    {
        modeloInventario.addColumn("Codigo");
        modeloInventario.addColumn("Categoria");
        modeloInventario.addColumn("Nombre");
        modeloInventario.addColumn("Cantidad");
        modeloInventario.addColumn("Visible");
        modeloInventario.addColumn("Valor unitario");
        tbl_inventario.setModel(modeloInventario);
        
        tbl_inventario.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl_inventario.getColumnModel().getColumn(1).setPreferredWidth(75);
        tbl_inventario.getColumnModel().getColumn(2).setPreferredWidth(270);
        tbl_inventario.getColumnModel().getColumn(3).setPreferredWidth(70);
        tbl_inventario.getColumnModel().getColumn(4).setPreferredWidth(50);
        tbl_inventario.getColumnModel().getColumn(5).setPreferredWidth(100);
    }
    
    public final void formaTablaVenta(){
        modeloVenta.addColumn("Codigo");
        modeloVenta.addColumn("Nombre");
        modeloVenta.addColumn("Cantidad");
        modeloVenta.addColumn("Valor unitario");
        modeloVenta.addColumn("Subtotal");
        tblVenta.setModel(modeloVenta);
        
        tblVenta.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblVenta.getColumnModel().getColumn(1).setPreferredWidth(270);
        tblVenta.getColumnModel().getColumn(2).setPreferredWidth(75);
        tblVenta.getColumnModel().getColumn(3).setPreferredWidth(70);
        tblVenta.getColumnModel().getColumn(4).setPreferredWidth(75);
    }
    
    public final void mostrarDatosTablaInventario()
    {
        try
        {   
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conexion = conexionPostgres.getConexion();
            
            String sql = "SELECT p.codigo, c.descripcion as categoria, p.nombre, p.cantidad, p.estado, p.valor_unitario FROM producto as p JOIN categoria as c on p.id_categoria = c.id ORDER BY p.codigo ASC";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantColumna =rsMd.getColumnCount();
            
            while(rs.next())
            {
                Object[] filas = new Object[cantColumna];
                 
                for (int i = 0; i < filas.length; i++) {
                    filas[i]= rs.getObject(i + 1);
                }
                
                modeloInventario.addRow(filas);
            }
        } catch (SQLException e){
            System.err.println(e);
        } 
    }
    
    public DefaultTableModel getModeloInventario()
    {
        return modeloInventario;
    }
    
    public DefaultTableModel getModeloVenta() {
        return modeloVenta;
    }
    
    public void eliminarDatosTablaInventario(){
        modeloInventario.setRowCount(0);
        tbl_inventario.setModel(modeloInventario);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panel_ventas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtFechaActualVenta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtVentaCodigoProducto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtVentaCantidadProducto = new javax.swing.JTextField();
        bttAgregarVenta = new javax.swing.JButton();
        bttCobrarVenta = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        bttModificarVenta = new javax.swing.JButton();
        bttEliminarVenta = new javax.swing.JButton();
        bttLimpiarVenta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenta = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        panel_inventario = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_inventario = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        bttAddProductoInventario = new javax.swing.JButton();
        bttModificarProductoInventario = new javax.swing.JButton();
        bttEliminarProductoInventario = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        nombre_negocio = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFechaInv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscarProducto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\dylan\\OneDrive\\Documentos\\NetBeansProjects\\StockWave_V2\\src\\main\\java\\com\\imagenes\\cesta-de-la-compra1.png")); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel6.setText("PLACITA EL MONO");

        jLabel8.setFont(new java.awt.Font("Nirmala UI", 2, 18)); // NOI18N
        jLabel8.setText("Carrera 43 #83-03 Sur brr. Villa Juliana");

        txtFechaActualVenta.setEditable(false);
        txtFechaActualVenta.setBackground(new java.awt.Color(0, 0, 153));
        txtFechaActualVenta.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtFechaActualVenta.setForeground(new java.awt.Color(255, 255, 255));
        txtFechaActualVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel9.setText("Fecha actual");

        jPanel9.setBackground(new java.awt.Color(0, 102, 255));

        jLabel10.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("PUNTO DE VENTA");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(jLabel10))
        );

        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 40, 0));

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel11.setText("Codigo del producto:");
        jPanel2.add(jLabel11);
        jPanel2.add(txtVentaCodigoProducto);

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel12.setText("Cantidad del producto:");
        jPanel2.add(jLabel12);
        jPanel2.add(txtVentaCantidadProducto);

        bttAgregarVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        bttAgregarVenta.setIcon(new javax.swing.ImageIcon("C:\\Users\\dylan\\OneDrive\\Documentos\\NetBeansProjects\\StockWave_V2\\src\\main\\java\\com\\imagenes\\anadir-al-carrito.png")); // NOI18N
        bttAgregarVenta.setText("Añadir");
        jPanel2.add(bttAgregarVenta);

        bttCobrarVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        bttCobrarVenta.setIcon(new javax.swing.ImageIcon("C:\\Users\\dylan\\OneDrive\\Documentos\\NetBeansProjects\\StockWave_V2\\src\\main\\java\\com\\imagenes\\caja-registradora.png")); // NOI18N
        bttCobrarVenta.setText("Cobrar");

        jPanel18.setBackground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel3.setLayout(new java.awt.GridLayout(1, 0, 30, 0));

        bttModificarVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        bttModificarVenta.setIcon(new javax.swing.ImageIcon("C:\\Users\\dylan\\OneDrive\\Documentos\\NetBeansProjects\\StockWave_V2\\src\\main\\java\\com\\imagenes\\modificado.png")); // NOI18N
        bttModificarVenta.setText("Modificar");
        bttModificarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttModificarVentaActionPerformed(evt);
            }
        });
        jPanel3.add(bttModificarVenta);

        bttEliminarVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        bttEliminarVenta.setIcon(new javax.swing.ImageIcon("C:\\Users\\dylan\\OneDrive\\Documentos\\NetBeansProjects\\StockWave_V2\\src\\main\\java\\com\\imagenes\\quitar-del-carrito.png")); // NOI18N
        bttEliminarVenta.setText("Eliminar");
        jPanel3.add(bttEliminarVenta);

        bttLimpiarVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        bttLimpiarVenta.setIcon(new javax.swing.ImageIcon("C:\\Users\\dylan\\OneDrive\\Documentos\\NetBeansProjects\\StockWave_V2\\src\\main\\java\\com\\imagenes\\escoba.png")); // NOI18N
        bttLimpiarVenta.setText("Limpiar venta");
        bttLimpiarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttLimpiarVentaActionPerformed(evt);
            }
        });
        jPanel3.add(bttLimpiarVenta);

        tblVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblVenta);

        jPanel19.setBackground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(153, 153, 255));
        jPanel5.setLayout(new java.awt.GridLayout(2, 1, 20, 0));

        jLabel14.setBackground(new java.awt.Color(153, 153, 255));
        jLabel14.setFont(new java.awt.Font("Roboto", 3, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("TOTAL A PAGAR");
        jPanel5.add(jLabel14);

        txtTotal.setFont(new java.awt.Font("Roboto", 3, 24)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(0, 0, 153));
        txtTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotal.setText("$ 0.0");
        jPanel5.add(txtTotal);

        javax.swing.GroupLayout panel_ventasLayout = new javax.swing.GroupLayout(panel_ventas);
        panel_ventas.setLayout(panel_ventasLayout);
        panel_ventasLayout.setHorizontalGroup(
            panel_ventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(panel_ventasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
            .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_ventasLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(59, 59, 59)
                .addGroup(panel_ventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(panel_ventasLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_ventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaActualVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addGroup(panel_ventasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bttCobrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_ventasLayout.setVerticalGroup(
            panel_ventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ventasLayout.createSequentialGroup()
                .addGroup(panel_ventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_ventasLayout.createSequentialGroup()
                        .addGroup(panel_ventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_ventasLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ventasLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_ventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaActualVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ventasLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel_ventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_ventasLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel_ventasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_ventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(bttCobrarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(16, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Ventas", panel_ventas);

        tbl_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbl_inventario);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 50, 0));

        bttAddProductoInventario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        bttAddProductoInventario.setIcon(new javax.swing.ImageIcon("C:\\Users\\dylan\\OneDrive\\Documentos\\NetBeansProjects\\StockWave_V2\\src\\main\\java\\com\\imagenes\\agregar-paquete1.png")); // NOI18N
        bttAddProductoInventario.setText("Añadir producto");
        bttAddProductoInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttAddProductoInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttAddProductoInventarioActionPerformed(evt);
            }
        });
        jPanel1.add(bttAddProductoInventario);

        bttModificarProductoInventario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        bttModificarProductoInventario.setIcon(new javax.swing.ImageIcon("C:\\Users\\dylan\\OneDrive\\Documentos\\NetBeansProjects\\StockWave_V2\\src\\main\\java\\com\\imagenes\\editar1.png")); // NOI18N
        bttModificarProductoInventario.setText("Modificar producto");
        bttModificarProductoInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(bttModificarProductoInventario);

        bttEliminarProductoInventario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        bttEliminarProductoInventario.setIcon(new javax.swing.ImageIcon("C:\\Users\\dylan\\OneDrive\\Documentos\\NetBeansProjects\\StockWave_V2\\src\\main\\java\\com\\imagenes\\4381695.png")); // NOI18N
        bttEliminarProductoInventario.setText("Eliminar producto");
        bttEliminarProductoInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(bttEliminarProductoInventario);

        jPanel15.setBackground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel17.setBackground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(0, 102, 255));

        jLabel7.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("INVENTARIO DE PRODUCTOS");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(jLabel7))
        );

        nombre_negocio.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        nombre_negocio.setText("PLACITA EL MONO");

        jLabel2.setFont(new java.awt.Font("Nirmala UI Semilight", 2, 18)); // NOI18N
        jLabel2.setText("Carrera 43 #83-03 Sur brr. Villa Juliana");

        txtFechaInv.setEditable(false);
        txtFechaInv.setBackground(new java.awt.Color(0, 0, 153));
        txtFechaInv.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtFechaInv.setForeground(new java.awt.Color(255, 255, 255));
        txtFechaInv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaInvActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel3.setText("Fecha actual");

        txtBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarProductoActionPerformed(evt);
            }
        });
        txtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel5.setText("Buscar producto");

        javax.swing.GroupLayout panel_inventarioLayout = new javax.swing.GroupLayout(panel_inventario);
        panel_inventario.setLayout(panel_inventarioLayout);
        panel_inventarioLayout.setHorizontalGroup(
            panel_inventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_inventarioLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addGroup(panel_inventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_inventarioLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(nombre_negocio))
                    .addGroup(panel_inventarioLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addGroup(panel_inventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaInv, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
            .addGroup(panel_inventarioLayout.createSequentialGroup()
                .addGroup(panel_inventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_inventarioLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_inventarioLayout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_inventarioLayout.setVerticalGroup(
            panel_inventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_inventarioLayout.createSequentialGroup()
                .addGroup(panel_inventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_inventarioLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(panel_inventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_inventarioLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFechaInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_inventarioLayout.createSequentialGroup()
                                .addComponent(nombre_negocio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel2))))
                    .addGroup(panel_inventarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_inventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inventario", panel_inventario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyReleased
        buscarProducto(txtBuscarProducto.getText());
    }//GEN-LAST:event_txtBuscarProductoKeyReleased

    private void txtBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProductoActionPerformed

    private void txtFechaInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaInvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaInvActionPerformed

    private void bttAddProductoInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttAddProductoInventarioActionPerformed

    }//GEN-LAST:event_bttAddProductoInventarioActionPerformed

    private void bttLimpiarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttLimpiarVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bttLimpiarVentaActionPerformed

    private void bttModificarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttModificarVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bttModificarVentaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu_Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bttAddProductoInventario;
    public javax.swing.JButton bttAgregarVenta;
    public javax.swing.JButton bttCobrarVenta;
    public javax.swing.JButton bttEliminarProductoInventario;
    public javax.swing.JButton bttEliminarVenta;
    public javax.swing.JButton bttLimpiarVenta;
    public javax.swing.JButton bttModificarProductoInventario;
    public javax.swing.JButton bttModificarVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel nombre_negocio;
    private javax.swing.JPanel panel_inventario;
    private javax.swing.JPanel panel_ventas;
    public javax.swing.JTable tblVenta;
    public javax.swing.JTable tbl_inventario;
    private javax.swing.JTextField txtBuscarProducto;
    public javax.swing.JTextField txtFechaActualVenta;
    public javax.swing.JTextField txtFechaInv;
    public javax.swing.JLabel txtTotal;
    public javax.swing.JTextField txtVentaCantidadProducto;
    public javax.swing.JTextField txtVentaCodigoProducto;
    // End of variables declaration//GEN-END:variables
}
