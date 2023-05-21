package com.proyectoBanco.dto;

import com.proyectoBanco.dao.CuentaBancariaDAO;
import com.proyectoBanco.dao.OperacionDAO;

import com.proyectoBanco.persistence.manager.impl.ManagerCuentaBancariaImpl;
import com.proyectoBanco.persistence.manager.impl.ManagerUsuarioCuentaBancariaImpl;
import com.proyectoBanco.persistence.manager.impl.ManagerUsuarioImpl;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operacion {
    private int codigoOperacion;
    private TipoOperacion tipoOperacion;
    private LocalDate fechaRealizacion;
    private double cantidad;
    private CuentaBancaria cuentaBancaria1;
    private CuentaBancaria cuentaBancaria2;
    private Usuario usuario;


    public Operacion(ResultSet result){
        try{
            this.codigoOperacion= result.getInt("codigoOperacion");
            this.tipoOperacion= TipoOperacion.valueOf(result.getString("tipoOperacion"));
            this.fechaRealizacion = result.getDate("fechaRealizacion").toLocalDate();
            this.cantidad= result.getDouble("cantidad");
            this.cuentaBancaria1= new ManagerCuentaBancariaImpl().findByNumeroCuenta(result.getString("numeroCuenta1"));
            this.cuentaBancaria2= new ManagerCuentaBancariaImpl().findByNumeroCuenta(result.getString("numeroCuenta1"));
            this.usuario = new ManagerUsuarioImpl().findByNif(result.getString("nifUsuario"));
        }catch (SQLException e){
            e.printStackTrace();
        }

    }


    public static void retirarDinero(Usuario u1 ,CuentaBancaria c1,double cantidad){
        Set<CuentaBancaria> cuentaBancarias=new ManagerUsuarioCuentaBancariaImpl().findByUsuarioCuentaBancaria(u1);
        Set<String> dnis= new ManagerUsuarioCuentaBancariaImpl().findByCuentaDni(c1);
        boolean a= false;
        for (String dni:
                dnis) {
            if(dni.equals(u1.getNif()) && cantidad<new ManagerCuentaBancariaImpl().findBySaldo(c1.getNumeroCuenta())){
                double saldoActual = new ManagerCuentaBancariaImpl().findBySaldo(c1.getNumeroCuenta());
                double saldoNuevo =saldoActual-cantidad;
                c1.setSaldo(saldoNuevo);
                CuentaBancariaDAO.actualizarSaldo(saldoNuevo,c1.getNumeroCuenta());
                Operacion o1= new Operacion();
                o1.setCodigoOperacion(0);
                o1.setCantidad(cantidad);
                TipoOperacion tipo = TipoOperacion.RETIRADA;
                o1.setTipoOperacion(tipo);
                LocalDate fecha= LocalDate.now();
                o1.setFechaRealizacion(fecha);
                o1.setCuentaBancaria1(c1);
                o1.setCuentaBancaria2(c1);
                o1.setUsuario(u1);
                OperacionDAO.createOperacion(o1);
                System.out.println("Retirada realizada con éxito");
                a=true;
            }
            if (cantidad>new ManagerCuentaBancariaImpl().findBySaldo(c1.getNumeroCuenta())){
                System.out.println("No se puede realizar la accion ya que la cantidad es mayor que el saldo que contiene esta cuenta");
            }
            if (!a){
                System.out.println("No se puede realizar la accion ya que el usuario no es titular de la cuenta");
            }
        }{

        }
    }


    public static void ingresarDinero(Usuario u1 ,CuentaBancaria c1,double cantidad){
        Set<CuentaBancaria> cuentaBancarias=new ManagerUsuarioCuentaBancariaImpl().findByUsuarioCuentaBancaria(u1);
        Set<String> dnis= new ManagerUsuarioCuentaBancariaImpl().findByCuentaDni(c1);
        for (String dni:
             dnis) {
            if(dni.equals(u1.getNif()) || cantidad>0){
                double saldoActual = new ManagerCuentaBancariaImpl().findBySaldo(c1.getNumeroCuenta());
                double saldoNuevo =saldoActual+cantidad;
                c1.setSaldo(saldoNuevo);
                CuentaBancariaDAO.actualizarSaldo(saldoNuevo,c1.getNumeroCuenta());
                Operacion o1= new Operacion();
                o1.setCodigoOperacion(0);
                o1.setCantidad(cantidad);
                TipoOperacion tipo = TipoOperacion.INGRESO;
                o1.setTipoOperacion(tipo);
                LocalDate fecha= LocalDate.now();
                o1.setFechaRealizacion(fecha);
                o1.setCuentaBancaria1(c1);
                o1.setCuentaBancaria2(c1);
                o1.setUsuario(u1);
                OperacionDAO.createOperacion(o1);
                System.out.println("Ingreso realizado con exito");
            }else{
                System.out.println("No se puede realizar la accion ya que el usuario no es titular de la cuenta");
            }
        }}

        public static void ingresarDineroT(Usuario u1,CuentaBancaria c1,double cantidad){
        double saldoActual = new ManagerCuentaBancariaImpl().findBySaldo(c1.getNumeroCuenta());
            if(cantidad>0){
                    double saldoNuevo =saldoActual+cantidad;
                    c1.setSaldo(saldoNuevo);
                    CuentaBancariaDAO.actualizarSaldo(saldoNuevo,c1.getNumeroCuenta());
                    Operacion o1= new Operacion();
                    o1.setCodigoOperacion(0);
                    o1.setCantidad(cantidad);
                    TipoOperacion tipo = TipoOperacion.INGRESO;
                    o1.setTipoOperacion(tipo);
                    LocalDate fecha= LocalDate.now();
                    o1.setFechaRealizacion(fecha);
                    o1.setCuentaBancaria1(c1);
                    o1.setCuentaBancaria2(c1);
                    o1.setUsuario(u1);
                    OperacionDAO.createOperacion(o1);
                    System.out.println("Ingreso realizado con exito");}
            else{
                System.out.println("Ingreso fallido");
            }
    }


    public static void transferencia(Usuario u1 ,CuentaBancaria c1,CuentaBancaria c2,double cantidad){
        Set<CuentaBancaria> cuentaBancarias=new ManagerUsuarioCuentaBancariaImpl().findByUsuarioCuentaBancaria(u1);
        Set<String> dnis= new ManagerUsuarioCuentaBancariaImpl().findByCuentaDni(c1);
        for (String dni:
                dnis) {
            if(dni.equals(u1.getNif()) && cantidad<new ManagerCuentaBancariaImpl().findBySaldo(c1.getNumeroCuenta())){
                Operacion.ingresarDineroT(u1,c2,cantidad);
                Operacion.retirarDinero(u1,c1,cantidad);

                Operacion o1= new Operacion();
                o1.setCodigoOperacion(0);
                o1.setCantidad(cantidad);
                TipoOperacion tipo = TipoOperacion.TRANSFERENCIA;
                o1.setTipoOperacion(tipo);
                LocalDate fecha= LocalDate.now();
                o1.setFechaRealizacion(fecha);
                o1.setCuentaBancaria1(c1);
                o1.setCuentaBancaria2(c2);
                o1.setUsuario(u1);
                OperacionDAO.createOperacion(o1);
                System.out.println("Transferencia realizada con éxito");
            }else{
                System.out.println("No se puede realizar la accion ya que el usuario no es titular de la cuenta");
            }
        }{

        }
    }

}
