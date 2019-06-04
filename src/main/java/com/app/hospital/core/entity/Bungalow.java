package com.app.hospital.core.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bungalow {
	
  @Id
	private Integer idbungalow;
	private double precio;
	
	@ManyToOne
	@JoinColumn(name="idestado")
	private EstBungalow estado;
	
	@ManyToOne
	@JoinColumn(name="idcategoria")
	private Categoria categoria;

	
	
	
}
