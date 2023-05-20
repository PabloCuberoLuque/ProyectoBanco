package com.proyectoBanco.persistence.manager;

import com.proyectoBanco.dto.CuentaBancaria;
import com.proyectoBanco.dto.Usuario;
import com.proyectoBanco.dto.UsuarioCuentaBancaria;

import java.util.Set;

/**
 * Usuario Cuenta Bancaria DTO Manager.
 *
 * Contains all the queries used to consult and manipulate UsuarioCuentaBancaria data.
 *
 */
public interface ManagerUsuarioCuentaBancaria extends Manager<UsuarioCuentaBancaria>{

    /**
     * Busca la cuenta bancaria en la base de datos por un usuario.
     *
     * @param usuario Nif de usuarios  para buscar sus cuentas en la base de datos.
     * @return Un/a {@link CuentaBancaria}.
     */
    Set<CuentaBancaria> findByUsuarioCuentaBancaria(Usuario usuario);

    /**
     * Busca el dni de los usuarios de una cuenta bancaria en la base de datos.
     *
     * @param cuenta CuentaBancaria para buscar el dni de los usuarios.
     * @return Un/a {@link CuentaBancaria}.
     */
    Set<String> findByCuentaDni(CuentaBancaria cuenta);

}
