package com.proyectoBanco.persistence.manager.impl;


import com.proyectoBanco.dto.Usuario;
import com.proyectoBanco.persistence.connector.MySQLConnector;
import com.proyectoBanco.persistence.manager.ManagerUsuario;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ManagerUsuarioImpl implements ManagerUsuario {
    private final static MySQLConnector connector= new MySQLConnector();
    @Override
    public Set<Usuario> findAll() {
        Set<Usuario> usuarios = new HashSet<>();

        try{
            Connection con = connector.getMySQLConnection();
            Statement stmt = con.createStatement();

            ResultSet result = stmt.executeQuery("SELECT * FROM usuario");

            while(result.next()){
                usuarios.add(new Usuario(result));
            }

            con.close();

            return usuarios;

        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Usuario findByNif(String nif) {
        String sql= "SELECT * FROM usuario WHERE nif = ?";

        try {
            Connection con = connector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement(sql);


            stmt.setString(1,nif);

            ResultSet result = stmt.executeQuery();

            Usuario usuario= null;

            while (result.next()) {
                usuario = new Usuario(result);
            }

            con.close();

            return usuario;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Set<Usuario> findByNombre(String nombre) {
        String sql= "SELECT * FROM usuario WHERE nombre = ?";

        try{
            Connection con = connector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement(sql);


            stmt.setString(1,nombre);

            ResultSet result = stmt.executeQuery();



            Set<Usuario> usuarios = new HashSet<>();

            while(result.next()){
                usuarios.add(new Usuario(result));
            }

            con.close();

            return usuarios;

        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Set<Usuario> findByApellidos(String apellidos) {
        String sql= "SELECT * FROM usuario WHERE apellidos = ?";

        try{
            Connection con = connector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement(sql);


            stmt.setString(1,apellidos);

            ResultSet result = stmt.executeQuery();


            Set<Usuario> usuarios = new HashSet<>();


            while(result.next()){
                usuarios.add(new Usuario(result));
            }

            con.close();

            return usuarios;

        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Usuario findByEmail(String email) {
        String sql= "SELECT * FROM usuario WHERE email = ?";

        try{
            Connection con = connector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement(sql);


            stmt.setString(1,email);

            ResultSet result = stmt.executeQuery();



            //Inicializo variable
            Usuario usuario = null;

            while (result.next()){
                //Inicializo un usuario para cada resultado
                usuario = new Usuario(result);
            }

            con.close();

            return usuario;

        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Usuario findByTelefono(String telefono) {
        String sql= "SELECT * FROM usuario WHERE telefono = ?";

        try{
            Connection con = connector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1,telefono);

            ResultSet result = stmt.executeQuery();

            //Inicializo variable
            Usuario usuario = null;

            while (result.next()){
                //Inicializo un usuario para cada resultado
                usuario = new Usuario(result);
            }

            con.close();

            return usuario;

        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return null;
        }
    }


}
