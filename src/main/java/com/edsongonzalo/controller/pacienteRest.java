package com.edsongonzalo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsongonzalo.model.Paciente;
import com.edsongonzalo.service.PacienteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/pacientes")
public class pacienteRest {
	
	@Autowired
	private PacienteService pacienteService;
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Paciente paciente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(paciente));
	}
	
	
	@GetMapping
	public List<Paciente> getAll() {
		List<Paciente> pacientes = StreamSupport
				.stream(pacienteService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return pacientes;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable(value = "id") Long idPaciente) {
		Optional<Paciente> oPaciente = pacienteService.finById(idPaciente);

		if(!oPaciente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oPaciente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Paciente pacienteDetail, @PathVariable(value = "id") Long idPaciente) {
		
		Optional<Paciente> paciente = pacienteService.finById(idPaciente);
		
		if(!paciente.isPresent()) {
			return ResponseEntity.notFound().build();
		}		
		paciente.get().setNombre(pacienteDetail.getNombre());
		paciente.get().setApellido(pacienteDetail.getApellido());
		paciente.get().setDireccion(pacienteDetail.getDireccion());
		paciente.get().setFecha_nac(pacienteDetail.getFecha_nac());
		paciente.get().setCreate_on(pacienteDetail.getCreate_on());
		paciente.get().setUpdate_on(pacienteDetail.getUpdate_on());
		paciente.get().setCreadopor(pacienteDetail.getCreadopor());
		paciente.get().setActualizadopor(pacienteDetail.getActualizadopor());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(paciente.get()));
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long idPaciente){
		
		if(!pacienteService.finById(idPaciente).isPresent()) {			
			return ResponseEntity.notFound().build();
		}
		pacienteService.delateById(idPaciente);
		return ResponseEntity.ok().build();				
	}
	
	
	
}
