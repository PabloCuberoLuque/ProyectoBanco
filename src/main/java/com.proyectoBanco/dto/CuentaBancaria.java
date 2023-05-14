package com.proyectoBanco.dto;

import com.proyectoBanco.persistence.manager.impl.ManagerUsuarioImpl;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaBancaria {
    private String numeroCuenta;
    private LocalDate fechaCreacion;
    private double saldo= 0.0;
    private Set<Usuario> usuarios;

    public CuentaBancaria(ResultSet result){
        try{
            this.numeroCuenta= result.getString("numeroCuenta");
            this.fechaCreacion= result.getDate("fechaCreacion").toLocalDate();
            for (int i= 1;i<=30;i++ ){
                this.usuarios.add(new ManagerUsuarioImpl().findByNif(result.getString("user"+1)));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
