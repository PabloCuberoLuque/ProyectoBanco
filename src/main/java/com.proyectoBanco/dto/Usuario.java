package com.proyectoBanco.dto;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private String nif;
    private String nombre;
    private String apellidos;
    private int anoNacimiento;
    private String direccion;
    private String email;
    private String telefono;

    public Usuario(ResultSet result){
        try{
            this.nif= result.getString("nif");
            this.nombre= result.getString("nombre");
            this.apellidos= result.getString("apellidos");
            this.anoNacimiento= result.getInt("anoNacimiento");
            this.direccion= result.getString("direccion");
            this.email= result.getString("email");
            this.telefono= result.getString("telefono");

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

}
