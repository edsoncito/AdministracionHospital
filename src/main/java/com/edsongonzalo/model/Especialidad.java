package com.edsongonzalo.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="especialidad")
public class Especialidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEspecialidad;
	
	@Column(name = "nombre" , length = 50)
	private String nombre;
	
	@Column(name = "Descripcion" , length = 50)
	private String Descripcion;
	
	@Column(name = "create_on" , columnDefinition = "DATE")
	private LocalDate create_on;
	
	@Column(name = "update_on" , columnDefinition = "DATE")
	private LocalDate update_on;
	
	@Column(name = "creadopor" , length = 50)
	private String creadopor;
	
	@Column(name = "actualizadopor" , length = 50)
	private String actualizadopor;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public LocalDate getCreate_on() {
		return create_on;
	}

	public void setCreate_on(LocalDate create_on) {
		this.create_on = create_on;
	}

	public LocalDate getUpdate_on() {
		return update_on;
	}

	public void setUpdate_on(LocalDate update_on) {
		this.update_on = update_on;
	}

	public String getCreadopor() {
		return creadopor;
	}

	public void setCreadopor(String creadopor) {
		this.creadopor = creadopor;
	}

	public String getActualizadopor() {
		return actualizadopor;
	}

	public void setActualizadopor(String actualizadopor) {
		this.actualizadopor = actualizadopor;
	}	
	
}
