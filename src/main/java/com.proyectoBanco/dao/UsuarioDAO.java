package com.proyectoBanco.dao;

import com.proyectoBanco.dto.Usuario;
import com.proyectoBanco.persistence.connector.MySQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class UsuarioDAO {
    private final static MySQLConnector connector = new MySQLConnector();

    public static void createUsuario(Usuario usuario){
        try {Connection con = connector.getMySQLConnection();
            String sql = "INSERT INTO usuario VALUES (?, ?, ?, ?, ?, ?, ? )";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNif());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getApellidos());
            stmt.setInt(4, usuario.getAnoNacimiento());
            stmt.setString(5, usuario.getDireccion());
            stmt.setString(6,usuario.getEmail());
            stmt.setString(7,usuario.getTelefono());

            stmt.execute();
            con.close();

        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

        public static void actualizarNombreUsuario(String nombre,String nif) {
        try {Connection con = connector.getMySQLConnection();
            String sql = "UPDATE usuario SET nombre = ? WHERE nif = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,nombre);
            stmt.setString(2,nif);

            stmt.executeUpdate();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public static void actualizarApellidosUsuario(String apellidos,String nif) {
        try {Connection con = connector.getMySQLConnection();
            String sql = "UPDATE usuario SET apellidos = ? WHERE nif = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,apellidos);
            stmt.setString(2,nif);

            stmt.executeUpdate();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void actualizarDireccionUsuario(String direccion,String nif) {
        try {Connection con = connector.getMySQLConnection();
            String sql = "UPDATE usuario SET direccion = ? WHERE nif = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,direccion);
            stmt.setString(2,nif);

            stmt.executeUpdate();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void actualizarEmailUsuario(String email,String nif) {
        try {Connection con = connector.getMySQLConnection();
            String sql = "UPDATE usuario SET email = ? WHERE nif = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,email);
            stmt.setString(2,nif);

            stmt.executeUpdate();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void actualizarTelefonoUsuario(String telefono,String nif) {
        try {Connection con = connector.getMySQLConnection();
            String sql = "UPDATE usuario SET telefono = ? WHERE nif = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,telefono);
            stmt.setString(2,nif);

            stmt.executeUpdate();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUsuario(String nif){
        try{Connection con = connector.getMySQLConnection();
            String sql = "DELETE FROM usuario WHERE (nif = ?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nif);
            stmt.execute();
            con.close();

        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }


}}
