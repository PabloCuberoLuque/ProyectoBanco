package com.proyectoBanco.dao;

import com.proyectoBanco.dto.CuentaBancaria;
import com.proyectoBanco.persistence.connector.MySQLConnector;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CuentaBancariaDAO {
    private final static MySQLConnector connector = new MySQLConnector();

    public static void createCuentaBancaria(CuentaBancaria cuentaBancaria){
        try {
            Connection con = connector.getMySQLConnection();
            String sql = "INSERT INTO cuentabancaria VALUES (?, ? ,? )";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cuentaBancaria.getNumeroCuenta());
            stmt.setDate(2, Date.valueOf(String.valueOf(cuentaBancaria.getFechaCreacion())));
            stmt.setDouble(3,cuentaBancaria.getSaldo());

            stmt.execute();
            con.close();

        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public static void actualizarSaldo(double saldo,String numeroCuenta) {
        try {Connection con = connector.getMySQLConnection();
            String sql = "UPDATE cuentabancaria SET saldo = ? WHERE numeroCuenta = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDouble(1,saldo);
            stmt.setString(2,numeroCuenta);

            stmt.executeUpdate();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }




    public static void deleteCuentaBancaria(String numeroCuenta){
        try{Connection con = connector.getMySQLConnection();
            String sql = "DELETE FROM cuentaBancaria WHERE (numeroCuenta = ?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, numeroCuenta);
            stmt.execute();
            con.close();

        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }


    }
}
