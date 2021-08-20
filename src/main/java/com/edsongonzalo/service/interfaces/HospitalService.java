package com.edsongonzalo.service;
import java.util.Optional;

import com.edsongonzalo.model.Hospital;


public interface HospitalService {
		
	public Iterable<Hospital> findAll();
	
	
	public Hospital save(Hospital hospital);
	
	
	public Optional<Hospital> finById(Long id);
	
	
	public void delateById(Long id);
		

}
