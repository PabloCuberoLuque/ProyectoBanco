package com.proyectoBanco.dto;

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
    private Set<CuentaBancaria> cuentas;
    private Set<Usuario> usuarios;

    public Operacion(ResultSet result){
        try{
            this.codigoOperacion= result.getInt("codigoOperacion");
            this.tipoOperacion= TipoOperacion.valueOf(result.getString("tipoOperacion"));
            this.fechaRealizacion = result.getDate("fechaRealizacion").toLocalDate();
            this.cantidad= result.getDouble("cantidad");


        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
