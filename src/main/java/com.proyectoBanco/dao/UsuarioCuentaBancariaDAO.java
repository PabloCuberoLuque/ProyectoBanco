package com.proyectoBanco.dao;

import com.proyectoBanco.dto.CuentaBancaria;
import com.proyectoBanco.dto.Usuario;
import com.proyectoBanco.persistence.connector.MySQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioCuentaBancariaDAO {
    private final static MySQLConnector connector = new MySQLConnector();
    public static void createUsuarioCuentaBancaria(CuentaBancaria cuentaBancaria, Usuario usuario){
        try {
            Connection con = connector.getMySQLConnection();
            String sql = "INSERT INTO usuariosCuentaBancaria VALUES (?, ?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cuentaBancaria.getNumeroCuenta());
            stmt.setString(2,usuario.getNif());


            stmt.execute();
            con.close();

        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public static void addUsuario(String nif, String numeroCuenta) {
        try {Connection con = connector.getMySQLConnection();
            String sql = "INSERT INTO usuariosCuentaBancaria (numeroCuenta, nifUsuario) VALUES (?, ? );";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,numeroCuenta);
            stmt.setString(2,nif);

            stmt.executeUpdate();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUsuario(String nif, String numeroCuenta) {
        try {Connection con = connector.getMySQLConnection();
            String sql = "DELETE FROM usuariosCuentaBancaria WHERE numeroCuenta = ? AND nifUsuario = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,numeroCuenta);
            stmt.setString(2,nif);

            stmt.executeUpdate();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
