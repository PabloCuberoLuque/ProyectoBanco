package com.proyectoBanco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaBancaria {
    private String numeroCuenta;
    private LocalDate fechaCreacion;
    private double saldo= 0.0;


    public CuentaBancaria(ResultSet result){
        try{
            this.numeroCuenta= result.getString("numeroCuenta");
            this.fechaCreacion= result.getDate("fechaCreacion").toLocalDate();
            this.saldo= result.getDouble("saldo");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }





}
