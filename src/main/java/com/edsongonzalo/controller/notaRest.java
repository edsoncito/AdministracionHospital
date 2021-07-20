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
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsongonzalo.model.Nota;
import com.edsongonzalo.service.NotaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/notas")
public class notaRest {
	
	@Autowired
	private NotaService notaService;
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Nota nota) {
		return ResponseEntity.status(HttpStatus.CREATED).body(notaService.save(nota));
	}
	
	
	@GetMapping
	public List<Nota> getAll() {
		List<Nota> nota = StreamSupport
				.stream(notaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return nota;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable(value = "id") Long id_nota) {
		Optional<Nota> doctor = notaService.finById(id_nota);

		if(!doctor.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(doctor);
	}
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<?> update(@RequestBody Doctor doctorDetail, @PathVariable(value = "id") Long idDoctor) {
//		
//		Optional<Doctor> doctor = doctorService.finById(idDoctor);
//		
//		if(!doctor.isPresent()) {
//			return ResponseEntity.notFound().build();
//		}		
//		doctor.get().setNombre(doctorDetail.getNombre());
//		doctor.get().setApellido(doctorDetail.getApellido());
//		doctor.get().setDireccion(doctorDetail.getDireccion());
//		doctor.get().setFecha_nac(doctorDetail.getFecha_nac());
//		doctor.get().setCreate_on(doctorDetail.getCreate_on());
//		doctor.get().setUpdate_on(doctorDetail.getUpdate_on());
//		doctor.get().setCreadopor(doctorDetail.getCreadopor());
//		doctor.get().setActualizadopor(doctorDetail.getActualizadopor());
//		
//		return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.save(doctor.get()));
//		
//	}
	
}
