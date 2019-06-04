package com.app.hospital.core.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.hospital.core.entity.Socio;

public interface SocioRepository extends JpaRepository<Socio,Integer>{

  @Query("Select max(a.idsocio) from Socio a")
  Integer findLastIdSocio();
  
  
}
