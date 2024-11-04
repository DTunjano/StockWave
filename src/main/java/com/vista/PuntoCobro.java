
package com.vista;

import com.controladores.CRUDS.CRUDCliente;
import com.controladores.CRUDS.CRUDEmpleado;
import com.modelo.Cliente;
import com.modelo.Empleado;
import java.util.ArrayList;


public class PuntoCobro extends javax.swing.JFrame {

    /**
     * Creates new form PuntoCobro
     */
    public PuntoCobro() {
        initComponents();
        mostrarClientes();
        mostrarEmpleados();
    }
    
    public void mostrarClientes(){
        CRUDCliente crudcliente = new CRUDCliente();
        
        ArrayList<Cliente> listaClientes = crudcliente.getClientes();
        
        cbxCliente.removeAllItems();
        
        for (int i = 0; i < listaClientes.size(); i++) {
            cbxCliente.addItem(new Cliente(listaClientes.get(i).getId_cliente(), listaClientes.get(i).getId(), listaClientes.get(i).getNombre_1(), listaClientes.get(i).getNombre_2(), listaClientes.get(i).getApellido_1(), listaClientes.get(i).getApellido_2(), listaClientes.get(i).getTipo_documento(), listaClientes.get(i).getDocumento(), listaClientes.get(i).getTelefono()));
        }
    }
    
    public void mostrarEmpleados(){
        CRUDEmpleado crudempleado = new CRUDEmpleado();
        
        ArrayList<Empleado> listaEmpleados = crudempleado.getEmpleado();
        
        cbxEmpleado.removeAllItems();
        
        for (int i = 0; i < listaEmpleados.size(); i++) {
            cbxEmpleado.addItem(new Empleado(listaEmpleados.get(i).getId_empleado(), listaEmpleados.get(i).getId_cargo(), listaEmpleados.get(i).getId(), listaEmpleados.get(i).getNombre_1(), 
                    listaEmpleados.get(i).getNombre_2(), listaEmpleados.get(i).getApellido_1(), listaEmpleados.get(i).getApellido_2(), listaEmpleados.get(i).getTipo_documento(),
                    listaEmpleados.get(i).getDocumento(), listaEmpleados.get(i).getTelefono()));
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtImpuesto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTotalCobro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPago = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbxCliente = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbxEmpleado = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        bttCancelar = new javax.swing.JButton();
        bttAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\dylan\\OneDrive\\Documents\\NetBeansProjects\\StockWave_V2\\src\\main\\java\\com\\imagenes\\3194591.png")); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel9.setText("PLACITA EL MONO");

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\dylan\\OneDrive\\Documents\\NetBeansProjects\\StockWave_V2\\src\\main\\java\\com\\imagenes\\1147934.png")); // NOI18N

        jPanel8.setBackground(new java.awt.Color(0, 102, 255));

        jLabel7.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PUNTO DE COBRO");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jLabel7))
        );

        jPanel1.setLayout(new java.awt.GridLayout(6, 2, 40, 0));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setText("Fecha:");
        jPanel1.add(jLabel2);

        txtFecha.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(txtFecha);

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setText("Impuesto (%):");
        jPanel1.add(jLabel5);

        txtImpuesto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(txtImpuesto);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setText("Total:");
        jPanel1.add(jLabel1);

        txtTotalCobro.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(txtTotalCobro);

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setText("Pago:");
        jPanel1.add(jLabel3);

        txtPago.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(txtPago);

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setText("Cliente:");
        jPanel1.add(jLabel6);

        cbxCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(cbxCliente);

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel10.setText("Empleado:");
        jPanel1.add(jLabel10);

        cbxEmpleado.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(cbxEmpleado);

        jPanel4.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        bttCancelar.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        bttCancelar.setIcon(new javax.swing.ImageIcon("C:\\Users\\dylan\\OneDrive\\Documents\\NetBeansProjects\\StockWave_V2\\src\\main\\java\\com\\imagenes\\11450177.png")); // NOI18N
        bttCancelar.setText("Cancelar");
        bttCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCancelarActionPerformed(evt);
            }
        });
        jPanel4.add(bttCancelar);

        bttAceptar.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        bttAceptar.setIcon(new javax.swing.ImageIcon("C:\\Users\\dylan\\OneDrive\\Documents\\NetBeansProjects\\StockWave_V2\\src\\main\\java\\com\\imagenes\\4303945.png")); // NOI18N
        bttAceptar.setText("Aceptar");
        bttAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttAceptarActionPerformed(evt);
            }
        });
        jPanel4.add(bttAceptar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bttCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bttCancelarActionPerformed

    private void bttAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bttAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(PuntoCobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PuntoCobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PuntoCobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PuntoCobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PuntoCobro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bttAceptar;
    public javax.swing.JButton bttCancelar;
    public javax.swing.JComboBox<Cliente> cbxCliente;
    public javax.swing.JComboBox<Empleado> cbxEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    public javax.swing.JTextField txtFecha;
    public javax.swing.JTextField txtImpuesto;
    public javax.swing.JTextField txtPago;
    public javax.swing.JTextField txtTotalCobro;
    // End of variables declaration//GEN-END:variables
}
