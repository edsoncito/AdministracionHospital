package com.edsongonzalo.service;
import java.util.Optional;

import com.edsongonzalo.model.Doctor;


public interface DoctorService {
		
	public Iterable<Doctor> findAll();
	
	
	public Doctor save(Doctor doctor);
	
	
	public Optional<Doctor> finById(Long id);
	
	
	public void delateById(Long id);
		

}
