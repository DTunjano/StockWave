
package com.vista;

import com.controladores.CRUDS.CRUDCategoria;
import com.modelo.Categoria;
import java.util.ArrayList;


public class EliminarProducto extends javax.swing.JFrame {

    public EliminarProducto() {
        initComponents();
        mostrarCategorias();
    }
    
    public void mostrarCategorias(){
        CRUDCategoria CRUDcat = new CRUDCategoria();
        ArrayList<Categoria> listaCategorias = CRUDcat.getCategorias();
        
        cbxCategoria.removeAllItems();
        
        for (int i = 0; i < listaCategorias.size(); i++) {
            cbxCategoria.addItem(new Categoria(listaCategorias.get(i).getId(), listaCategorias.get(i).getDescripcion()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtEliminarCodigoProductoInventario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtEliminarNombreProductoInventario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEliminarCantidadProductoInventario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEliminarValorProductoInventario = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        bttCancelarInventario = new javax.swing.JButton();
        bttEliminarBuscarProductoInventario = new javax.swing.JButton();
        bttEliminarInventario = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel8.setBackground(new java.awt.Color(0, 102, 255));

        jLabel7.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ELIMINAR PRODUCTO");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(jLabel7))
        );

        jPanel1.setLayout(new java.awt.GridLayout(5, 2, 4, 4));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setText("Codigo del producto");
        jPanel1.add(jLabel1);

        txtEliminarCodigoProductoInventario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(txtEliminarCodigoProductoInventario);

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setText("Categoria del producto");
        jPanel1.add(jLabel3);

        cbxCategoria.setEnabled(false);
        jPanel1.add(cbxCategoria);

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setText("Nombre del producto");
        jPanel1.add(jLabel5);

        txtEliminarNombreProductoInventario.setEditable(false);
        txtEliminarNombreProductoInventario.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(txtEliminarNombreProductoInventario);

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setText("Cantidad del producto");
        jPanel1.add(jLabel6);

        txtEliminarCantidadProductoInventario.setEditable(false);
        txtEliminarCantidadProductoInventario.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(txtEliminarCantidadProductoInventario);

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setText("Valor unitario del producto");
        jPanel1.add(jLabel2);

        txtEliminarValorProductoInventario.setEditable(false);
        txtEliminarValorProductoInventario.setBackground(new java.awt.Color(204, 204, 204));
        txtEliminarValorProductoInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEliminarValorProductoInventarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtEliminarValorProductoInventario);

        jPanel4.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        bttCancelarInventario.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        bttCancelarInventario.setIcon(new javax.swing.ImageIcon("C:\\Users\\dylan\\OneDrive\\Documents\\NetBeansProjects\\StockWave_V2\\src\\main\\java\\com\\imagenes\\11450177.png")); // NOI18N
        bttCancelarInventario.setText("Cancelar");
        bttCancelarInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttCancelarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCancelarInventarioActionPerformed(evt);
            }
        });
        jPanel4.add(bttCancelarInventario);

        bttEliminarBuscarProductoInventario.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        bttEliminarBuscarProductoInventario.setIcon(new javax.swing.ImageIcon("C:\\Users\\dylan\\OneDrive\\Documents\\NetBeansProjects\\StockWave_V2\\src\\main\\java\\com\\imagenes\\1265907.png")); // NOI18N
        bttEliminarBuscarProductoInventario.setText("Buscar");
        bttEliminarBuscarProductoInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(bttEliminarBuscarProductoInventario);

        bttEliminarInventario.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        bttEliminarInventario.setIcon(new javax.swing.ImageIcon("C:\\Users\\dylan\\OneDrive\\Documents\\NetBeansProjects\\StockWave_V2\\src\\main\\java\\com\\imagenes\\4303945.png")); // NOI18N
        bttEliminarInventario.setText("Aceptar");
        bttEliminarInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttEliminarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttEliminarInventarioActionPerformed(evt);
            }
        });
        jPanel4.add(bttEliminarInventario);

        jLabel9.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel9.setText("PLACITA EL MONO");

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\dylan\\OneDrive\\Documents\\NetBeansProjects\\StockWave_V2\\src\\main\\java\\com\\imagenes\\3194591.png")); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\dylan\\OneDrive\\Documents\\NetBeansProjects\\StockWave_V2\\src\\main\\java\\com\\imagenes\\1147934.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(63, 63, 63)
                        .addComponent(jLabel8)
                        .addGap(17, 17, 17))))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEliminarValorProductoInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEliminarValorProductoInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEliminarValorProductoInventarioActionPerformed

    private void bttEliminarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttEliminarInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bttEliminarInventarioActionPerformed

    private void bttCancelarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCancelarInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bttCancelarInventarioActionPerformed

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
            java.util.logging.Logger.getLogger(EliminarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bttCancelarInventario;
    public javax.swing.JButton bttEliminarBuscarProductoInventario;
    public javax.swing.JButton bttEliminarInventario;
    public javax.swing.JComboBox<Categoria> cbxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    public javax.swing.JTextField txtEliminarCantidadProductoInventario;
    public javax.swing.JTextField txtEliminarCodigoProductoInventario;
    public javax.swing.JTextField txtEliminarNombreProductoInventario;
    public javax.swing.JTextField txtEliminarValorProductoInventario;
    // End of variables declaration//GEN-END:variables
}
