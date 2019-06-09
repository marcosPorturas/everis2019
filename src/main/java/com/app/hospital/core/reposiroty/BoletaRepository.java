package com.app.hospital.core.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.hospital.core.entity.Boleta;

public interface BoletaRepository extends JpaRepository<Boleta,Integer>{

  @Query("Select max(a.idboleta) from Boleta a")
  Integer findLastIdBoleta();
  
  
}
