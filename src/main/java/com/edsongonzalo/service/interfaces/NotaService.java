package com.edsongonzalo.service;
import java.util.Optional;

import com.edsongonzalo.model.Nota;


public interface NotaService {
		
	public Iterable<Nota> findAll();
	
	
	public Nota save(Nota nota);
	
	
	public Optional<Nota> finById(Long id);
	
	
	public void delateById(Long id);
		

}
