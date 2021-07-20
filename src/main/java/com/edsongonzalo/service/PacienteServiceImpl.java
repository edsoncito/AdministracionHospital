package com.edsongonzalo.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.edsongonzalo.model.Paciente;
import com.edsongonzalo.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Paciente> findAll() {
		return pacienteRepository.findAll();
	}

	@Override
	@Transactional
	public Paciente save(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Paciente> finById(Long id) {		
		return pacienteRepository.findById(id);
	}

	@Override
	@Transactional
	public void delateById(Long id) {
		pacienteRepository.deleteById(id);		
	}

}
