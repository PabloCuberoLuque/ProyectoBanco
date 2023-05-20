package com.proyectoBanco.persistence.manager;

import com.proyectoBanco.dto.CuentaBancaria;
import com.proyectoBanco.dto.Operacion;

import java.util.Set;

/**
 * Operacion DTO Manager.
 *
 * Contains all the queries used to consult and manipulate Usuario data.
 *
 */

public interface ManagerOperacion extends Manager<Operacion>{

    /**
     * Busca las operaciones en la base de datos de una determinada cuenta.
     *
     * @param cuenta Cuenta para buscar sus operaciones en la base de datos.
     * @return Un/a {@link CuentaBancaria}.
     */
    Set<Operacion> findByOperacionesCuentaBancaria(CuentaBancaria cuenta);


}
