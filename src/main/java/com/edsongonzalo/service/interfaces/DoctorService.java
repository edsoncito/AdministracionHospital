package com.edsongonzalo.service;
import java.util.List;
import java.util.Optional;

import com.edsongonzalo.model.Doctor;
import org.springframework.stereotype.Service;

@Service
public interface DoctorService {
		
	public Iterable<Doctor> findAll();
	
	
	public Doctor save(Doctor doctor);

	public Doctor saveAll(List<Doctor> doctor);

	public Optional<Doctor> finById(Long id);

	
	public void delateById(Long id);


}
