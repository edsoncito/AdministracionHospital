package com.edsongonzalo.service;
import java.util.Optional;
import com.edsongonzalo.model.Especialidad;


public interface EspecialidadesService {
	
	public Iterable<Especialidad> findAll();
	
	public Especialidad save(Especialidad especialidad);
	
	public Optional<Especialidad> finById(Long id);
		
	public void delateById(Long id);
		
}

