package com.controladores.conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion_postgreSQL {
    private static Conexion_postgreSQL instance;
    private Connection conexion;
    
    private final String usuario = "dylan_tunjano_admin";
    private final String password = "1234";
    private final String db = "placita_el_mono_v3";
    private final String ip = "localhost";
    private final String puerto = "5432";
    private final String cadena = "jdbc:postgresql://" + ip + ":" + puerto + "/" + db;

    
    private Conexion_postgreSQL() {
        cargarControlador();
        establecerConexion();
    }
    
    private void establecerConexion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                conexion = DriverManager.getConnection(cadena, usuario, password);
            }
        } catch (SQLException e) {
            System.err.println("Error al establecer la conexión con la base de datos: " + e.getMessage());
        }
    }
    
    private void cargarControlador() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador de PostgreSQL: " + e.getMessage());
        }
    }

    
    public static Conexion_postgreSQL getInstance(){
        if (instance == null) {
            instance = new Conexion_postgreSQL();
        } else try {
            if (instance.getConexion() == null || instance.getConexion().isClosed()) {
                instance = new Conexion_postgreSQL();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion_postgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance;
    }

    
    public Connection getConexion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                establecerConexion();
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar o restablecer la conexión: " + e.getMessage());
        }
        return conexion;
    }
}
