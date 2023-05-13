package com.proyectoBanco.persistence.manager;

import com.proyectoBanco.dto.Usuario;


import java.util.List;
import java.util.Set;

/**
 * Usuario DTO Manager.
 *
 * Contains all the queries used to consult and manipulate Usuario data.
 *
 */
public interface ManagerUsuario extends Manager<Usuario> {


    /**
     * Busca el usuario en la base de datos por un Nif.
     *
     * @param nif Nif de un usuario especifico para buscarlo en la base de datos.
     * @return Un {@link Set }Un/a {@link Usuario}.
     */
    Usuario findById(String nif);


    /**
     * Busca el usuario en la base de datos por un nombre.
     *
     * @param nombre Nombre y apellidos de un usuario especifico para buscarlo en la base de datos.
     * @return Un {@link Set }Un/a {@link Usuario}.
     */
    Set<Usuario> findByNombre(String nombre);

    /**
     * Busca el usuario en la base de datos por unos apellidos especificos .
     *
     * @param apellidos Apellidos de un usuario especifico para buscarlo en la base de datos.
     * @return Un {@link Set }Un/a {@link Usuario}.
     */
    Set<Usuario> findByApellidos(String apellidos);


    /**
     * Busca el usuario en la base de datos de un email.
     *
     * @param email email de un usuario especifico para buscarlo en la base de datos.
     * @return Un {@link Set }Un/a {@link Usuario}.
     */
    Usuario findByEmail(String email);

    /**
     * Busca el usuario en la base de datos por un telefono.
     *
     * @param telefono email de un usuario especifico para buscarlo en la base de datos.
     * @return Un {@link Set }Un/a {@link Usuario}.
     */
    Usuario findByTelefono(String telefono);

}
