package com.edsongonzalo.service;
import java.util.Optional;
import com.edsongonzalo.model.Paciente;

public interface PacienteService {
		
	public Iterable<Paciente> findAll();
	
	
	public Paciente save(Paciente paciente);
	
	
	public Optional<Paciente> finById(Long id);
	
	
	public void delateById(Long id);
		

}
