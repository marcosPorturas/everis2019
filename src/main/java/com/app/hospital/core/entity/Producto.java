package com.app.hospital.core.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Producto {
	
	@Id
	private Integer idproducto;
	private String detalle;
	private int stock;
	private double precio;
	
	

}
