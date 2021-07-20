package com.edsongonzalo.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "paciente")

public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPaciente;

	@Column(name = "nombre", length = 50)
	private String nombre;

	@Column(name = "apellido", length = 50)
	private String apellido;

	@Column(name = "direccion", length = 50)
	private String direccion;

	@JsonFormat(pattern="MM-dd-yyy")
	@Column(name = "fecha_nac", columnDefinition = "DATE")
	private LocalDate fecha_nac;

	@Column(name = "foto", length = 50)
	private String foto;

	@JsonFormat(pattern="MM-dd-yyy")
	@Column(name = "create_on", columnDefinition = "DATE")
	private LocalDate create_on;

	@JsonFormat(pattern="MM-dd-yyy")
	@Column(name = "update_on", columnDefinition = "DATE")
	private LocalDate update_on;

	@Column(name = "creadopor", length = 50)
	private String creadopor;

	@Column(name = "actualizadopor", length = 50)
	private String actualizadopor;


	public Paciente() {

	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public LocalDate getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(LocalDate fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
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

	public Long getIdPaciente() {
		return idPaciente;
	}


	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}


	public String getActualizadopor() {
		return actualizadopor;
	}

	public void setActualizadopor(String actualizadopor) {
		this.actualizadopor = actualizadopor;
	}

}
