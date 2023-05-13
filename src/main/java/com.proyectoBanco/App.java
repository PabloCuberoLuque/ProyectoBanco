package com.proyectoBanco;

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
        System.out.println(new ManagerUsuarioImpl().findByNombre("Pablo"));


    }}
