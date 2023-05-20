package com.proyectoBanco.persistence.manager.impl;

import com.proyectoBanco.dto.CuentaBancaria;
import com.proyectoBanco.dto.Usuario;
import com.proyectoBanco.dto.UsuarioCuentaBancaria;
import com.proyectoBanco.persistence.connector.MySQLConnector;
import com.proyectoBanco.persistence.manager.ManagerUsuarioCuentaBancaria;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ManagerUsuarioCuentaBancariaImpl implements ManagerUsuarioCuentaBancaria {
    private final static MySQLConnector connector= new MySQLConnector();
    @Override
    public Set<UsuarioCuentaBancaria> findAll() {
        Set<UsuarioCuentaBancaria> usuariosCuentasBancarias = new HashSet<>();
        String sql= "SELECT * FROM usuariosCuentaBancaria";

        try{
            Connection con = connector.getMySQLConnection();
            Statement stmt = con.createStatement();

            ResultSet result = stmt.executeQuery(sql);

            while(result.next()){
                usuariosCuentasBancarias.add(new UsuarioCuentaBancaria(result));
            }

            con.close();

            return usuariosCuentasBancarias;

        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return null;
        }

    }


    @Override
    public Set<CuentaBancaria> findByUsuarioCuentaBancaria(Usuario usuario) {
        String sql= "SELECT cuentaBancaria.* FROM cuentaBancaria JOIN usuariosCuentaBancaria ON cuentaBancaria.numeroCuenta = usuariosCuentaBancaria.numeroCuenta JOIN usuario ON usuariosCuentaBancaria.nifUsuario = usuario.nif WHERE usuario.nif = ?";

        try{
            Connection con = connector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1,usuario.getNif());

            ResultSet result = stmt.executeQuery();

            Set<CuentaBancaria> cuentas = new HashSet<>();

            while(result.next()){
               cuentas.add(new CuentaBancaria(result));
            }

            if(cuentas.isEmpty()){
                System.out.println("Este usuario no tiene ninguna cuenta bancaria.");
            }
            con.close();

            return cuentas;

        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Set<String> findByCuentaDni(CuentaBancaria cuenta) {
        String sql= "SELECT usuario.nif FROM usuario JOIN usuariosCuentaBancaria ON usuario.nif = usuariosCuentaBancaria.nifUsuario JOIN cuentaBancaria ON usuariosCuentaBancaria.numeroCuenta = cuentaBancaria.numeroCuenta WHERE cuentaBancaria.numeroCuenta = ? ";

        try{
            Connection con = connector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1,cuenta.getNumeroCuenta());

            ResultSet result = stmt.executeQuery();

            Set<String> dnis= new HashSet<>();

            while(result.next()){
                String nif = result.getString("nif");
                dnis.add(nif);
            }

            con.close();

            return dnis;

        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
