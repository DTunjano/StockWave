
package com.controladores.CRUDS;

import com.controladores.conexionbd.Conexion_postgreSQL;
import com.modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CRUDEmpleado {
    private final Conexion_postgreSQL conexionPostgres = Conexion_postgreSQL.getInstance();
    
    public ArrayList<Empleado> getEmpleado(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        Connection con = conexionPostgres.getConexion();

        String sql = "SELECT e.id, e.id_cargo, p.* FROM empleado as e JOIN persona as p ON e.id_persona = p.id";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setId_empleado(rs.getInt("id"));
                emp.setId_cargo(rs.getInt("id"));
                emp.setId(rs.getInt("id"));
                emp.setNombre_1(rs.getString("nombre_1"));
                emp.setNombre_2(rs.getString("nombre_2"));
                emp.setApellido_1(rs.getString("apellido_1"));
                emp.setApellido_2(rs.getString("apellido_2"));
                emp.setTipo_documento(rs.getString("tipo_documento"));
                emp.setDocumento(rs.getString("documento"));
                emp.setTelefono(rs.getString("telefono"));
                listaEmpleados.add(emp);
            }
            return listaEmpleados;
            
            
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
