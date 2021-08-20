package com.edsongonzalo.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.edsongonzalo.model.Hospital;
import com.edsongonzalo.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService{

	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Hospital> findAll() {
		return hospitalRepository.findAll();
	}

	@Override
	@Transactional
	public Hospital save(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Hospital> finById(Long id) {		
		return hospitalRepository.findById(id);
	}

	@Override
	@Transactional
	public void delateById(Long id) {
		hospitalRepository.deleteById(id);		
	}
}
