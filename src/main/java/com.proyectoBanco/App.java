package com.proyectoBanco;

import com.proyectoBanco.dao.CuentaBancariaDAO;
import com.proyectoBanco.dao.UsuarioCuentaBancariaDAO;
import com.proyectoBanco.dao.UsuarioDAO;
import com.proyectoBanco.dto.*;
import com.proyectoBanco.persistence.manager.impl.ManagerCuentaBancariaImpl;
import com.proyectoBanco.persistence.manager.impl.ManagerOperacionImpl;
import com.proyectoBanco.persistence.manager.impl.ManagerUsuarioCuentaBancariaImpl;
import com.proyectoBanco.persistence.manager.impl.ManagerUsuarioImpl;


import java.time.LocalDate;
import java.util.Scanner;


public class App {
    public static void main( String[] args ){
        App.menu();
    }

    public static void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------------------BANCO PABLO---------------------------------------------------------------------------------");
        System.out.println("Bienvenido. ¿Que desea hacer? \nPara funcionalidades con el usuario, introduzca 1. \nPara funcionalidades con la cuenta, introduzca 2. \nPara consultar informacion, introduzca 3.\nPara realizar operaciones, introduzca 4. \nPara salir del programa, introduzca 5.");
        System.out.println("---------------------------------------------------------------------------------BANCO PABLO---------------------------------------------------------------------------------");
        int opcion=0;
        while (opcion != 5 ){
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion){
                case 1:
                    funcionalidadesUsuario();
                    App.menu();
                    break;
                case 2:
                    funcionalidadesCuenta();
                    App.menu();
                    break;
                case 3:
                    App.consultas();
                    App.menu();
                    break;
                case 4:
                    App.realizarOperaciones();
                    App.menu();
                    break;
                case 5:
                    System.out.println("Cerrando el programa. Gracias por utilizar nuestro servicios.");
                    break;
            }
            opcion=5;
        }
        System.out.println("Programa cerrado.");
    }
    public static void funcionalidadesUsuario(){
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        System.out.println("Introduzca 1 para crear un nuevo usuario. \nIntroduzca 2 para modificar los datos de un usuario.\nIntroduzca 3 para borrar un usuario.\nIntroduzca 4 para salir del menu de usuario.");
        while (opcion != 4 ){
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion){
                case 1:
                    System.out.println("Introduzca tu nif.(max 9 caracteres)");
                    String nif =sc.nextLine();
                    System.out.println("Introduzca tu nombre.");
                    String nombre =sc.nextLine();
                    System.out.println("Introduzca tus apellidos.");
                    String apellidos =sc.nextLine();
                    System.out.println("Introduzca tu año de nacimiento.");
                    int ano =Integer.parseInt(sc.nextLine());
                    System.out.println("Introduzca tu direccion.");
                    String direccion =sc.nextLine();
                    System.out.println("Introduzca tu email.");
                    String email =sc.nextLine();
                    System.out.println("Introduzca tu telefono.");
                    String telefono =sc.nextLine();
                    Usuario u1 = new Usuario(nif,nombre,apellidos,ano,direccion,email,telefono);
                    UsuarioDAO.createUsuario(u1);
                    System.out.println("Usuario creado con éxito");
                    break;
                case 2:
                    App.cambiarDatosUsuario();
                    break;
                case 3:
                    System.out.println("Introduzca el dni del usuario que desea eliminar.");
                    String nifD=sc.nextLine();
                    UsuarioDAO.deleteUsuario(nifD);
                    System.out.println("Usuario eliminado con éxito");
                    break;
                case 4:
                    System.out.println("Saliendo del menu de usuario.");
                    System.out.println("-----------------------------------------------");
                    break;

            }
        }



        }
    public static void cambiarDatosUsuario() {
        ManagerUsuarioImpl manager = new ManagerUsuarioImpl();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        System.out.println("Este es el menu de edicion de usuario.\n Para cambiar el nombre pulse 1\n Para cambiar los apellidos pulse 2\n Para cambiar la direccion pulse 3\n Para cambiar el email pulse 4\n Para cambiar el telefono pulse 5\nPara salir del menu pulse 6");
        while (opcion != 4) {
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    System.out.println("Introduzca el nuevo nombre y el dni.");
                    String nombre = sc.nextLine();
                    String nifN = sc.nextLine();
                    UsuarioDAO.actualizarNombreUsuario(nombre, nifN);
                    System.out.println("Actualizado con éxito");
                    break;
                case 2:
                    System.out.println("Introduzca los nuevos apellidos y el dni.");
                    String apellidos = sc.nextLine();
                    String nifA = sc.nextLine();
                    UsuarioDAO.actualizarApellidosUsuario(apellidos, nifA);
                    System.out.println("Actualizado con éxito");
                    break;
                case 3:
                    System.out.println("Introduzca la nueva direccion y el dni.");
                    String direccion = sc.nextLine();
                    String nifD = sc.nextLine();
                    UsuarioDAO.actualizarDireccionUsuario(direccion, nifD);
                    System.out.println("Actualizado con éxito");
                    break;
                case 4:
                    System.out.println("Introduzca el nuevo email y el dni.");
                    String email = sc.nextLine();
                    String nifE = sc.nextLine();
                    UsuarioDAO.actualizarDireccionUsuario(email, nifE);
                    System.out.println("Actualizado con éxito");
                    break;
                case 5:
                    System.out.println("Introduzca el nuevo telefono y el dni.");
                    String telefono = sc.nextLine();
                    String nifT = sc.nextLine();
                    UsuarioDAO.actualizarDireccionUsuario(telefono, nifT);
                    System.out.println("Actualizado con éxito");
                    break;

                case 6:
                    System.out.println("Saliendo del menu de edición de usuario.");
                    System.out.println("--------------------------------------------------");
            }
        }

    }

    public static void funcionalidadesCuenta(){
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        System.out.println("Introduzca 1 para crear una nueva cuenta. \nIntroduzca 2 para borrar una cuenta.\nIntroduzca 3 para añadir un usario a una cuenta.\nIntroduzca 4 para borrar un usuario de una cuenta.\nIntroduzca 5 para salir del menu de cuenta.");
        while (opcion != 5 ){
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion){
                case 1:
                    System.out.println("Introduzca el numero de cuenta.(max 20 caracteres)");
                    String numeroCuenta =sc.nextLine();
                    System.out.println("Introduzca la fecha de hoy.(formato: yyyy-MM-dd)");
                    String fechaTexto =sc.nextLine();
                    LocalDate fecha =LocalDate.parse(fechaTexto);
                    System.out.println("Por último, introduzca el nif del usuario al que le pertenece.");
                    String nifUsuario= sc.nextLine();

                    CuentaBancaria c1 = new CuentaBancaria(numeroCuenta,fecha,0.0);
                    CuentaBancariaDAO.createCuentaBancaria(c1);
                    UsuarioCuentaBancariaDAO.createUsuarioCuentaBancaria(c1,new ManagerUsuarioImpl().findByNif(nifUsuario));
                    System.out.println("Cuenta creada con éxito");
                    break;
                case 2:
                    System.out.println("Introduzca el numero de cuenta que desea eliminar.");
                    String nCuenta= sc.nextLine();
                    CuentaBancariaDAO.deleteCuentaBancaria(nCuenta);
                    System.out.println("Cuenta eliminada con éxito");
                    break;
                case 3:
                    System.out.println("Introduzca el nif del usuario que deseas añadir y el numero de cuenta.");
                    String nifC=sc.nextLine();
                    String numeroCuentaA= sc.nextLine();
                    UsuarioCuentaBancariaDAO.addUsuario(nifC,numeroCuentaA);
                    App.menu();
                    break;

                case 4:
                    System.out.println("Introduzca el nif del usuario que deseas borrar y el numero de cuenta.");
                    String nifB=sc.nextLine();
                    String numeroCuentaB= sc.nextLine();
                    UsuarioCuentaBancariaDAO.deleteUsuario(nifB,numeroCuentaB);;
                    App.menu();
                    break;
                case 5:
                    System.out.println("Saliendo del menu de cuenta.");
                    System.out.println("-----------------------------------------------");
                    App.menu();
                    break;


            }
        }




    }
    public static void consultas(){
        Scanner sc = new Scanner(System.in);
        ManagerUsuarioImpl mu = new ManagerUsuarioImpl();
        ManagerOperacionImpl mo= new ManagerOperacionImpl();
        ManagerUsuarioCuentaBancariaImpl muc= new ManagerUsuarioCuentaBancariaImpl();
        ManagerCuentaBancariaImpl mc = new ManagerCuentaBancariaImpl();
        System.out.println("Este es el menu de consultas. \nPara realizar una consulta sobre algún usuario, pulse 1.\nPara realizar una consulta sobre alguna cuenta, pulse 2.\nPara realizar una consulta sobre alguna operacion, pulse 3.\nPara salir del menu pulse 4");
        int opcion=0;
        while (opcion != 4 ){
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion){
                case 1:
                    App.consultasUsuario();
                    App.menu();
                    break;
                case 2:
                    App.consultasCuentas();
                    App.menu();
                    break;
                case 3:
                    App.consultasOperaciones();
                    App.menu();
                    break;
                case 4:
                    System.out.println("Saliendo del menu");
                    System.out.println("-----------------------------------------------");
                    App.menu();
                    break;

            }
        }
    }//TODO
    public static void consultasUsuario(){
        Scanner sc = new Scanner(System.in);
        ManagerUsuarioImpl mu = new ManagerUsuarioImpl();
        System.out.println("Este es el menu de consultas de usuario. \nPara saber todos los clientes del banco, pulse 1.\nPara saber la información de un usuario específico, pulse 2.\nPara salir del menu pulse 3");
        int opcion=0;
        while (opcion != 3 ){
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion){
                case 1:
                    System.out.println(mu.findAll());
                    App.consultas();
                   break;
                case 2:
                    App.consultasUsuarioEspecifico();
                    App.consultas();
                    break;
                case 3:
                    System.out.println("Saliendo del menu de consultas de usuario.");
                    System.out.println("-----------------------------------------------");
                    App.consultas();
                    break;

            }
        }
    }
    public static void consultasUsuarioEspecifico(){
        Scanner sc = new Scanner(System.in);
        ManagerUsuarioImpl mu = new ManagerUsuarioImpl();
        System.out.println("Si quieres buscar un usuario por nif pulse 1\nPor nombre pulse 2.\nPor apellidos pulse 3. \nPor email pulse 4.\nPor telefono pulse 5.\nPara salir de este menu pulse 6.");
        int opcion=0;
        while (opcion != 6 ){
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion){
                case 1:
                    System.out.println("Introduzca el nif.");
                    String nif= sc.nextLine();
                    System.out.println(mu.findByNif(nif));
                    App.consultasUsuario();
                    break;
                case 2:
                    System.out.println("Introduzca el nombre.");
                    String nombre = sc.nextLine();
                    System.out.println(mu.findByNombre(nombre));
                    App.consultasUsuario();
                    break;
                case 3:
                    System.out.println("Introduzca los apellidos.");
                    String apellidos= sc.nextLine();
                    System.out.println(mu.findByApellidos(apellidos));
                    App.consultasUsuario();
                    break;
                case 4:
                    System.out.println("Introduzca el email.");
                    String email= sc.nextLine();
                    System.out.println(mu.findByEmail(email));
                    App.consultasUsuario();
                    break;
                case 5:
                    System.out.println("Introduzca el telefono.");
                    String telefono= sc.nextLine();
                    System.out.println(mu.findByTelefono(telefono));
                    App.consultasUsuario();
                    break;
                case 6:
                    System.out.println("Saliendo del menu.");
                    System.out.println("-----------------------------------------------");
                    App.consultasUsuario();
                    break;
            }
        }
    }
    public static void consultasCuentas(){
        Scanner sc = new Scanner(System.in);
        ManagerCuentaBancariaImpl mc = new ManagerCuentaBancariaImpl();
        ManagerUsuarioCuentaBancariaImpl muc= new ManagerUsuarioCuentaBancariaImpl();
        System.out.println("Este es el menu de consultas de cuentas. \nPara saber todos las cuentas del banco, pulse 1.\nPara buscar una cuenta por numero de cuenta, pulse 2.\nPara buscar una cuenta de un determinado usuario, pulse 3.\nPara salir del menu pulse 3");
        int opcion=0;
        while (opcion != 3 ){
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion){
                case 1:
                    System.out.println(mc.findAll());
                    App.consultas();
                    break;
                case 2:
                    System.out.println("Introduzca el numero de cuenta.");
                    String numeroCuenta= sc.nextLine();
                    System.out.println(mc.findByNumeroCuenta(numeroCuenta));
                    App.consultas();
                    break;
                case 3:
                    System.out.println("Introduzca el nif del usuario.");
                    String nif= sc.nextLine();
                    System.out.println(muc.findByUsuarioCuentaBancaria(new ManagerUsuarioImpl().findByNif(nif)));
                    App.consultas();
                    break;
                case 4:
                    System.out.println("Saliendo del menu de consultas de cuentas.");
                    System.out.println("-----------------------------------------------");
                    App.consultas();
                    break;

            }
        }
    }
    private static void realizarOperaciones() {
        ManagerOperacionImpl mo=new ManagerOperacionImpl();
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        System.out.println("Este es el menu para realizar operaciones. \nIntroduzca 1 para hacer un ingreso.\nIntroduzca 2 para hacer una retirada .\nIntroduzca 3 para hacer una transferencia.\nIntroduzca 4 para salir del menu de cuenta.");
        while (opcion != 4 ){
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion){
                case 1:
                    System.out.println("Introduzca el nif de tu usuario,el numero de cuenta en la que deseas realizar el ingreso y la cantidad que deseas ingresar");
                    String nifI= sc.nextLine();
                    String numeroCuentaI= sc.nextLine();
                    double cantidadI=sc.nextDouble();
                    Operacion.ingresarDinero(new ManagerUsuarioImpl().findByNif(nifI),new ManagerCuentaBancariaImpl().findByNumeroCuenta(numeroCuentaI),cantidadI);
                    App.realizarOperaciones();
                    break;
                case 2:
                    System.out.println("Introduzca el nif de tu usuario,el numero de cuenta en la que deseas realizar la retirada y la cantidad que deseas retirar");
                    String nifR= sc.nextLine();
                    String numeroCuentaR= sc.nextLine();
                    double cantidadR=sc.nextDouble();
                    Operacion.retirarDinero(new ManagerUsuarioImpl().findByNif(nifR),new ManagerCuentaBancariaImpl().findByNumeroCuenta(numeroCuentaR),cantidadR);
                    App.realizarOperaciones();
                    break;
                case 3:
                    System.out.println("Introduzca el nif de tu usuario,el numero de cuenta en la que deseas retirar el dinero , el numero de cuenta en la que deseas ingresar el dinero y la cantidad que deseas transferir,");
                    String nif= sc.nextLine();
                    String numeroCuenta1= sc.nextLine();
                    String numeroCuenta2 = sc.nextLine();
                    double cantidad1=sc.nextDouble();
                    Operacion.transferencia(new ManagerUsuarioImpl().findByNif(nif),new ManagerCuentaBancariaImpl().findByNumeroCuenta(numeroCuenta1),new ManagerCuentaBancariaImpl().findByNumeroCuenta(numeroCuenta2),cantidad1);
                    App.realizarOperaciones();
                    break;
                case 4:
                    System.out.println("Saliendo del menu de operaciones.");
                    System.out.println("-----------------------------------------------");
                    App.menu();
                    break;

            }}}
    public static void consultasOperaciones(){
        Scanner sc = new Scanner(System.in);
        ManagerOperacionImpl mo = new ManagerOperacionImpl();
        System.out.println("Este es el menu de consultas de operaciones. \nPara saber todos las operaciones del banco, pulse 1.\nPara buscar las operaciones de una cuenta específica, pulse 2.\nPara salir del menú pulse 3");
        int opcion=0;
        while (opcion != 3 ){
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion){
                case 1:
                    System.out.println(mo.findAll());
                    App.consultas();
                    break;
                case 2:
                    System.out.println("Introduzca el numero de cuentas del que desee ver el historial de operaciones.");
                    String numeroCuenta=sc.nextLine();
                    System.out.println(mo.findByOperacionesCuentaBancaria(new ManagerCuentaBancariaImpl().findByNumeroCuenta(numeroCuenta)));
                    App.consultas();
                    break;
                case 3:
                    System.out.println("Saliendo del menu de consultas de operaciones .");
                    System.out.println("-----------------------------------------------");
                    App.consultas();
                    break;

            }
        }
    }


}
