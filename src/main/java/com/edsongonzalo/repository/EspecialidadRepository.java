package com.edsongonzalo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.edsongonzalo.model.Especialidad;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long>{
	
}
