package com.edsongonzalo.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.edsongonzalo.model.Nota;
import com.edsongonzalo.repository.NotaRepository;

@Service
public class NotaServiceImpl implements NotaService{

	@Autowired
	private NotaRepository notaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Nota> findAll() {
		return notaRepository.findAll();
	}

	@Override
	@Transactional
	public Nota save(Nota nota) {
		return notaRepository.save(nota);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Nota> finById(Long id) {		
		return notaRepository.findById(id);
	}

	@Override
	@Transactional
	public void delateById(Long id) {
		notaRepository.deleteById(id);		
	}

}
