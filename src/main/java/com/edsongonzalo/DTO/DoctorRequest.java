package com.edsongonzalo.DTO;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
public class DoctorDTO implements Serializable {

    private Long idDoctor;
    private String nombre;
    private String apellido;
    private String direccion;
    private LocalDate fecha_nac;
    private String foto;
    private Date create_on;
    private Date update_on;
    private String creadopor;
    private String actualizadopor;

}
