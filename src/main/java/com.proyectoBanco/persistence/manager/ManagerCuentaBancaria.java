package com.proyectoBanco.persistence.manager;

import com.proyectoBanco.dto.CuentaBancaria;


/**
 * Cuenta Bancaria DTO Manager.
 *
 * Contains all the queries used to consult and manipulate CuentaBancaria data.
 *
 */
public interface ManagerCuentaBancaria extends Manager<CuentaBancaria>{

    /**
     * Busca la cuenta bancaria en la base de datos por un numero de cuenta.
     *
     * @param numeroCuenta Nif de un usuario especifico para buscarlo en la base de datos.
     * @return Un/a {@link CuentaBancaria}.
     */
    CuentaBancaria findByNumeroCuenta(String numeroCuenta);

    /**
     * Busca la cuenta bancaria en la base de datos por un numero de cuenta.
     *
     * @param numeroCuenta Nif de un usuario especifico para buscarlo en la base de datos.
     * @return Un/a {@link CuentaBancaria}.
     */
    Double findBySaldo(String numeroCuenta);
}
