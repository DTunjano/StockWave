package com.controladores.CRUDS;

import com.controladores.conexionbd.Conexion_postgreSQL;
import com.modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CRUDCategoria{
    private final Conexion_postgreSQL conexionPostgres = Conexion_postgreSQL.getInstance();
    
    public ArrayList<Categoria> getCategorias() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Categoria> listaCategorias = new ArrayList<>();
        Connection con = conexionPostgres.getConexion();

        String sql = "SELECT * FROM categoria";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("id"));
                cat.setDescripcion(rs.getString("descripcion"));
                listaCategorias.add(cat);
            }
            return listaCategorias;
            
            
        } catch (SQLException e) {
            System.err.println(e);
            return null;
            
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        
    }
}
