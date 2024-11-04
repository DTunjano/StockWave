
package com.controladores.CRUDS;

import com.controladores.conexionbd.Conexion_postgreSQL;
import com.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CRUDCliente {
    
    private final Conexion_postgreSQL conexionPostgres = Conexion_postgreSQL.getInstance();
    
    public ArrayList<Cliente> getClientes(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        Connection con = conexionPostgres.getConexion();

        String sql = "SELECT c.id, p.* FROM cliente as c JOIN persona as p ON c.id_persona = p.id";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id"));
                cliente.setId(rs.getInt("id"));
                cliente.setNombre_1(rs.getString("nombre_1"));
                cliente.setNombre_2(rs.getString("nombre_2"));
                cliente.setApellido_1(rs.getString("apellido_1"));
                cliente.setApellido_2(rs.getString("apellido_2"));
                cliente.setTipo_documento(rs.getString("tipo_documento"));
                cliente.setDocumento(rs.getString("documento"));
                cliente.setTelefono(rs.getString("telefono"));
                listaClientes.add(cliente);
            }
            return listaClientes;
            
            
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
