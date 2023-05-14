package com.proyectoBanco;

import com.proyectoBanco.dao.UsuarioDAO;
import com.proyectoBanco.dto.Usuario;
import com.proyectoBanco.persistence.connector.MySQLConnector;
import com.proyectoBanco.persistence.manager.impl.ManagerUsuarioImpl;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws SQLException, ClassNotFoundException {
        Connection con = new MySQLConnector().getMySQLConnection();
        //System.out.println(new ManagerUsuarioImpl().findByNombre("Pablo"));
        //System.out.println(new ManagerUsuarioImpl().findAll());
        //System.out.println(new ManagerUsuarioImpl().findByNif("1234567F"));
        //System.out.println(new ManagerUsuarioImpl().findByApellidos("Cubero Luque"));
        //System.out.println(new ManagerUsuarioImpl().findByEmail("pablo@gmail.com"));
        //System.out.println(new ManagerUsuarioImpl().findByTelefono("61262646241"));


        //System.out.println(new ManagerUsuarioImpl().findAll());
        //UsuarioDAO.deleteUsuario("95128253F");
        //System.out.println(new ManagerUsuarioImpl().findAll());
    }}
