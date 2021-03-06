package com.app.hospital.core.reposiroty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.hospital.core.entity.Ingreso;

public interface IngresoRepository extends JpaRepository<Ingreso,Integer>{

	  @Query("Select max(a.idingreso) from Ingreso a")
	  Integer findLastIdIngreso();
	
	  //Lista de Ingresos para consulta segun sus estados
	  List<Ingreso> findAllByEstadoIdestado(Integer Idestado);
}
