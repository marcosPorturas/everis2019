package com.app.hospital.core.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.hospital.core.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Integer>{

	  @Query("Select max(a.idproducto) from Producto a")
	  Integer findLastIdProducto();
	
}
