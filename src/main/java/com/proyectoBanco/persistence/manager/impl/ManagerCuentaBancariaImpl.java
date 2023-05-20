package com.proyectoBanco.persistence.manager.impl;

import com.proyectoBanco.dto.CuentaBancaria;
import com.proyectoBanco.persistence.connector.MySQLConnector;
import com.proyectoBanco.persistence.manager.ManagerCuentaBancaria;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ManagerCuentaBancariaImpl implements ManagerCuentaBancaria {
    private final static MySQLConnector connector= new MySQLConnector();
    @Override
    public Set<CuentaBancaria> findAll() {
        Set<CuentaBancaria> cuentasBancarias = new HashSet<>();
        String sql= "SELECT * FROM cuentaBancaria";

        try{
            Connection con = connector.getMySQLConnection();
            Statement stmt = con.createStatement();

            ResultSet result = stmt.executeQuery(sql);

            while(result.next()){
                cuentasBancarias.add(new CuentaBancaria(result));
            }

            con.close();

            return cuentasBancarias;

        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public CuentaBancaria findByNumeroCuenta(String numeroCuenta) {
        String sql= "SELECT * FROM cuentabancaria WHERE numeroCuenta = ?";

        try {
            Connection con = connector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement(sql);


            stmt.setString(1,numeroCuenta);

            ResultSet result = stmt.executeQuery();

            CuentaBancaria cuentaBancaria= null;

            while (result.next()) {
                    cuentaBancaria = new CuentaBancaria(result);
            }

            con.close();

            return cuentaBancaria;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Double findBySaldo(String numeroCuenta) {
        String sql= "SELECT saldo FROM cuentaBancaria WHERE numeroCuenta = ?";

        try {
            Connection con = connector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement(sql);


            stmt.setString(1,numeroCuenta);

            ResultSet result = stmt.executeQuery();

           double saldo= 0.0;

            while (result.next()) {
                saldo = result.getDouble("saldo");
            }

            con.close();

            return saldo;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
