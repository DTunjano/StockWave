
package com.controladores.CRUDS;

import com.controladores.conexionbd.Conexion_postgreSQL;
import com.modelo.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CRUDFactura {
    private final Conexion_postgreSQL conexionPostgres = Conexion_postgreSQL.getInstance();
    
    public boolean registrar(Factura fac) {
        
        boolean validador = false;
        //boolean codigo = verificaNombre(pro);
        PreparedStatement ps = null;
        Connection con = conexionPostgres.getConexion();

        String sql = "INSERT INTO facturas (id_empleado, id_venta, id_cliente, id_producto, subtotal, impuesto) VALUES(?,?,?,?,?,?)";
        
        //if (codigo){
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1, fac.getId_empleado());
                ps.setInt(2, fac.getId_venta());
                ps.setInt(3, fac.getId_cliente());
                ps.setInt(4, fac.getId_producto());
                ps.setDouble(5, fac.getSubtotal());
                ps.setDouble(6, fac.getImpuesto());
                ps.execute();
                validador = true;

            } catch (SQLException e) {
                System.err.println(e);
                validador = false;

            } finally {
                try {
                    if (ps != null) ps.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        //}
        return validador;
    }
}
