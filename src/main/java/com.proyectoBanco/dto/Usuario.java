package com.proyectoBanco.dto;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private String nif;
    private String apellidos;
    private String nombre;
    private int anoNacimiento;
    private String direccion;
    private String email;
    private String telefono;

    public Usuario(ResultSet result){
        try{
            this.nif= result.getString("nif");
            this.apellidos= result.getString("apellidos");
            this.nombre= result.getString("nombre");
            this.anoNacimiento= result.getInt("añoNacimiento");
            this.direccion= result.getString("direccion");
            this.email= result.getString("email");
            this.telefono= result.getString("telefono");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
