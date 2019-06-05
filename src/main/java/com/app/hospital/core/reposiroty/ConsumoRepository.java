package com.app.hospital.core.reposiroty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.hospital.core.entity.Consumo;
import com.app.hospital.core.entity.ProductoHasIngresoPK;

public interface ConsumoRepository extends JpaRepository<Consumo,ProductoHasIngresoPK>{

	List<Consumo> findAllByPkIdingreso(Integer idIngreso);
	
}
