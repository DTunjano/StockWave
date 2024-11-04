
package com.controladores.CRUDS;

import com.controladores.conexionbd.Conexion_postgreSQL;
import com.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CRUDProducto  {
    
    private final Conexion_postgreSQL conexionPostgres = Conexion_postgreSQL.getInstance();
    
    public boolean registrar(Producto pro) {
        
        boolean validador = false;
        boolean codigo = verificaNombre(pro);
        PreparedStatement ps = null;
        Connection con = conexionPostgres.getConexion();

        String sql = "INSERT INTO producto (codigo, id_categoria, nombre, cantidad, estado, valor_unitario) VALUES(?,?,?,?,?,?)";
        
        if (codigo){
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1, pro.getCodigo_producto());
                ps.setInt(2, pro.getCategoria());
                ps.setString(3, pro.getNombre());
                ps.setInt(4, pro.getCantidad());
                ps.setBoolean(5, pro.isEstado());
                ps.setDouble(6, pro.getValor_unitario());
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
        }
        return validador;
    }

    public boolean modificar(Producto pro, int n) {
        PreparedStatement ps = null;
        Connection con = conexionPostgres.getConexion();

        String sql = "UPDATE producto SET codigo=?, id_categoria=?, nombre=?, cantidad=?, estado=?, valor_unitario=? WHERE codigo=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getCodigo_producto());
            ps.setInt(2, pro.getCategoria());
            ps.setString(3, pro.getNombre());
            ps.setInt(4, pro.getCantidad());
            ps.setBoolean(5, pro.isEstado());
            ps.setDouble(6, pro.getValor_unitario());
            ps.setInt(7, n);
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
            
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificarCantidad(Producto pro, int codigo) {
        PreparedStatement ps = null;
        Connection con = conexionPostgres.getConexion();

        String sql = "UPDATE producto SET cantidad=? WHERE codigo=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getCantidad());
            ps.setInt(2, codigo);
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
            
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminar(Producto pro) {
        PreparedStatement ps = null;
        Connection con = conexionPostgres.getConexion();

        String sql = "DELETE FROM producto WHERE codigo=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getCodigo_producto());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
            
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean buscar(Producto pro) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexionPostgres.getConexion();

        String sql = "SELECT * FROM producto WHERE codigo=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getCodigo_producto());
            rs = ps.executeQuery();

            if (rs.next()) {
                pro.setId(Integer.parseInt(rs.getString("id")));
                pro.setCodigo_producto(Integer.parseInt(rs.getString("codigo")));
                pro.setCategoria(Integer.parseInt(rs.getString("id_categoria")));
                pro.setNombre(rs.getString("nombre"));
                pro.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                String estado = rs.getString("estado").toLowerCase();
                pro.setEstado(estado.equals("true") || estado.equals("1") || estado.equals("t"));
                //pro.setEstado(Boolean.parseBoolean(rs.getString("estado")));
                pro.setValor_unitario(Double.parseDouble(rs.getString("valor_unitario")));
                return true;
            }
            return false;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
            
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean verificaNombre(Producto pro){
        
        boolean validador = true;
        
        if(pro.getNombre() == null){
            JOptionPane.showMessageDialog(null, "El nombre no puede ir vacio");
            validador = false;
        }
        
        if(buscar(pro)){
            JOptionPane.showMessageDialog(null, "El producto ya existe", "INFORMACION",JOptionPane.INFORMATION_MESSAGE);
            validador=false;
        }
        return validador;
    }
}
