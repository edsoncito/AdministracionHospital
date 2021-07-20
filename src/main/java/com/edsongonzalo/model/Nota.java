package com.edsongonzalo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "nota")
public class Nota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNota;

	@Column(name = "descripcion", length = 50)
	private String descripcion;

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

	@ManyToOne
	@JoinColumn(name = "hospital_id")
	Hospital hospital;

	@ManyToOne
	@JoinColumn(name = "paciente_id")
	Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	Doctor doctor;

	@ManyToOne
	@JoinColumn(name = "especialidad_id")
	Especialidad especialidad;

	public Nota() {		
	}	
	
	

	public Long getIdNota() {
		return idNota;
	}



	public void setIdNota(Long idNota) {
		this.idNota = idNota;
	}



	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}	
	

}
