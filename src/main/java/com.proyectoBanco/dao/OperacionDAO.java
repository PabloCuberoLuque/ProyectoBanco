package com.proyectoBanco.dao;

import com.proyectoBanco.dto.Operacion;
import com.proyectoBanco.persistence.connector.MySQLConnector;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OperacionDAO {
    private final static MySQLConnector connector = new MySQLConnector();

    public static void createOperacion(Operacion operacion){
        try {
            Connection con = connector.getMySQLConnection();
            String sql = "INSERT INTO operacion VALUES (?, ? ,? ,? ,? ,? , ? )";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, operacion.getCodigoOperacion());
            stmt.setString(2, String.valueOf(operacion.getTipoOperacion()));
            stmt.setDate(3, Date.valueOf(operacion.getFechaRealizacion()));
            stmt.setDouble(4, operacion.getCantidad());
            stmt.setString(5,operacion.getCuentaBancaria1().getNumeroCuenta());
            stmt.setString(6,operacion.getCuentaBancaria2().getNumeroCuenta());
            stmt.setObject(7,operacion.getUsuario().getNif());

            stmt.execute();
            con.close();


        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }


    public static void deleteOperacion(int codigoOperacion){
        try{Connection con = connector.getMySQLConnection();
            String sql = "DELETE FROM operacion WHERE (codigoOperacion = ?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, codigoOperacion);
            stmt.execute();
            con.close();

        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }


    }


}
