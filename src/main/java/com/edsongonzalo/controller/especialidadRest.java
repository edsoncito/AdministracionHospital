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

import com.edsongonzalo.model.Especialidad;
import com.edsongonzalo.service.EspecialidadesService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/especialidades")
public class especialidadRest {
	
	@Autowired
	private EspecialidadesService especialidadService;
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Especialidad especialidad) {
		return ResponseEntity.status(HttpStatus.CREATED).body(especialidadService.save(especialidad));
	}
	
	
	@GetMapping
	public List<Especialidad> getAll() {
		List<Especialidad> especialidad = StreamSupport
				.stream(especialidadService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return especialidad;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable(value = "id") Long idEspecialidad) {
		Optional<Especialidad> especialidad = especialidadService.finById(idEspecialidad);

		if(!especialidad.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(especialidad);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Especialidad especialidadDetail, @PathVariable(value = "id") Long idEspecialidad) {
		
		Optional<Especialidad> especialidad = especialidadService.finById(idEspecialidad);
		
		if(!especialidad.isPresent()) {
			return ResponseEntity.notFound().build();
		}		
		especialidad.get().setNombre(especialidadDetail.getNombre());
		especialidad.get().setDescripcion(especialidadDetail.getDescripcion());
		especialidad.get().setCreate_on(especialidadDetail.getCreate_on());
		especialidad.get().setUpdate_on(especialidadDetail.getUpdate_on());
		especialidad.get().setCreadopor(especialidadDetail.getCreadopor());
		especialidad.get().setActualizadopor(especialidadDetail.getActualizadopor());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(especialidadService.save(especialidad.get()));
		
	}
	
}
