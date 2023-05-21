package com.proyectoBanco.persistence.manager.impl;

import com.proyectoBanco.dto.CuentaBancaria;
import com.proyectoBanco.dto.Operacion;
import com.proyectoBanco.persistence.connector.MySQLConnector;
import com.proyectoBanco.persistence.manager.ManagerOperacion;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ManagerOperacionImpl implements ManagerOperacion {
    private final static MySQLConnector connector= new MySQLConnector();
    @Override
    public Set<Operacion> findAll() {
        Set<Operacion> operaciones = new HashSet<>();
        String sql= "SELECT * FROM operacion";

        try{
            Connection con = connector.getMySQLConnection();
            Statement stmt = con.createStatement();

            ResultSet result = stmt.executeQuery(sql);

            while(result.next()){
                operaciones.add(new Operacion(result));
            }

            con.close();

            return operaciones;

        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Set<Operacion> findByOperacionesCuentaBancaria(CuentaBancaria cuenta) {
        String sql= "SELECT * FROM operacion WHERE numeroCuenta1 = ? OR numeroCuenta2 = ?";
        try{
            Connection con = connector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, cuenta.getNumeroCuenta());
            stmt.setString(2,cuenta.getNumeroCuenta());

            ResultSet result = stmt.executeQuery();

            Set<Operacion> operaciones = new HashSet<>();

            while(result.next()){
                operaciones.add(new Operacion(result));
            }

            con.close();

            return operaciones;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    }

