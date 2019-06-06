package com.app.hospital.core.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.hospital.core.entity.Bungalow;

public interface BungalowRepository extends JpaRepository<Bungalow, Integer>{

	@Query("Select max(a.idbungalow) from Bungalow a")
	Integer findLastIdBungalow();
	
}
