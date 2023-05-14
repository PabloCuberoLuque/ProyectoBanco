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
    public static void actualizarUsuario(Usuario usuario) {
        try {Connection con = connector.getMySQLConnection();
            String sql = "UPDATE usuario SET nif = ? , nombre = ? , apellidos = ? , añoNacimiento = ? , direccion = ? , email = ? , telefono = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNif());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getApellidos());
            stmt.setInt(4, usuario.getAnoNacimiento());
            stmt.setString(5, usuario.getDireccion());
            stmt.setString(6,usuario.getEmail());
            stmt.setString(7,usuario.getTelefono());

            stmt.executeUpdate(sql);
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
            stmt.executeUpdate();
            con.close();

        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }


}}
