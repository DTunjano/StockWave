
package com.controladores.CRUDS;

import com.controladores.conexionbd.Conexion_postgreSQL;
import com.modelo.Venta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CRUDVenta{
    
    private final Conexion_postgreSQL conexionPostgres = Conexion_postgreSQL.getInstance();
    
    public boolean registrar(Venta ven) {
        
        boolean validador = false;
        //boolean codigo = verificaNombre(ven);
        PreparedStatement ps = null;
        Connection con = conexionPostgres.getConexion();

        String sql = "INSERT INTO venta (fecha, total) VALUES(?,?)";
        
        //if (codigo){
            try {
                ps = con.prepareStatement(sql);
                ps.setDate(1, (Date) ven.getFecha());
                ps.setDouble(2, ven.getTotal());
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
    
    public int registrarVentaGeneral() {
        int idVenta=0;
        PreparedStatement ps = null;
        Connection con = conexionPostgres.getConexion();

        String sql = "Select v.id from venta as v order by v.id desc limit 1";

        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                idVenta = rs.getInt(1);
            }
            
        } catch (SQLException e) {
            System.err.println(e);
            
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return idVenta;
    }

}
