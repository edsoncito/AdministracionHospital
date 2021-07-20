package com.edsongonzalo.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.edsongonzalo.model.Doctor;
import com.edsongonzalo.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Doctor> findAll() {
		return doctorRepository.findAll();
	}

	@Override
	@Transactional
	public Doctor save(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Doctor> finById(Long id) {		
		return doctorRepository.findById(id);
	}

	@Override
	@Transactional
	public void delateById(Long id) {
		doctorRepository.deleteById(id);		
	}

}
