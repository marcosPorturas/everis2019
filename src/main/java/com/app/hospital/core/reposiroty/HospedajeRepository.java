package com.app.hospital.core.reposiroty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.hospital.core.entity.Hospedaje;

public interface HospedajeRepository extends JpaRepository<Hospedaje, Integer>{

	@Query("Select max(a.idhospedaje) from Hospedaje a")
	Integer findLastIdHospedaje();
	
	List<Hospedaje> findAllByEstadoIdestado(Integer idEstado);
	
}
