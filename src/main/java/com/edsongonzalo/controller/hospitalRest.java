package com.edsongonzalo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsongonzalo.model.Hospital;
import com.edsongonzalo.service.HospitalService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/hospitales")
public class hospitalRest {
	
	@Autowired
	private HospitalService hospitalService;
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Hospital hospital) {
		return ResponseEntity.status(HttpStatus.CREATED).body(hospitalService.save(hospital));
	}
	
	
	@GetMapping
	public List<Hospital> getAll() {
		List<Hospital> hospital = StreamSupport
				.stream(hospitalService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return hospital;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable(value = "id") Long idHospital) {
		Optional<Hospital> hospital = hospitalService.finById(idHospital);

		if(!hospital.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(hospital);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Hospital hospitalDetail, @PathVariable(value = "id") Long idHospital) {
		
		Optional<Hospital> hospital = hospitalService.finById(idHospital);
		
		if(!hospital.isPresent()) {
			return ResponseEntity.notFound().build();
		}		
		hospital.get().setNombre(hospitalDetail.getNombre());
		hospital.get().setTelefono(hospitalDetail.getTelefono());
		hospital.get().setDireccion(hospitalDetail.getDireccion());
		hospital.get().setCreate_on(hospitalDetail.getCreate_on());
		hospital.get().setUpdate_on(hospitalDetail.getUpdate_on());
		hospital.get().setCreadopor(hospitalDetail.getCreadopor());
		hospital.get().setActualizadopor(hospitalDetail.getActualizadopor());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(hospitalService.save(hospital.get()));
		
	}
	
}
