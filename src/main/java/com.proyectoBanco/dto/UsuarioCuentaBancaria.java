package com.proyectoBanco.dto;

import com.proyectoBanco.persistence.manager.impl.ManagerCuentaBancariaImpl;
import com.proyectoBanco.persistence.manager.impl.ManagerUsuarioImpl;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCuentaBancaria {
    private Usuario usuario;
    private CuentaBancaria cuentaBancaria;

    public UsuarioCuentaBancaria(ResultSet result) {
        try {
            this.usuario = new ManagerUsuarioImpl().findByNif(result.getString("nif"));
            this.cuentaBancaria = new ManagerCuentaBancariaImpl().findByNumeroCuenta(result.getString("numeroCuenta"));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
