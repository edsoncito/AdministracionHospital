package com.edsongonzalo.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.edsongonzalo.model.Especialidad;
import com.edsongonzalo.repository.EspecialidadRepository;

@Service
public class EspecialidadServiceImpl implements EspecialidadesService{

	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Especialidad> findAll() {
		return especialidadRepository.findAll();
	}

	@Override
	@Transactional
	public Especialidad save(Especialidad especialidad) {
		return especialidadRepository.save(especialidad);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Especialidad> finById(Long id) {		
		return especialidadRepository.findById(id);
	}

	@Override
	@Transactional
	public void delateById(Long id) {
		especialidadRepository.deleteById(id);		
	}
}
