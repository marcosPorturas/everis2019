package com.app.hospital.core.entity;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Consumo {

	@EmbeddedId
	private ProductoHasIngresoPK pk;
	@Column(name="cantidad")
	private int cantidad;
	@Column(name="precio_venta")
	private double precio_venta;
	
	@ManyToOne
	@JoinColumn(name="idingreso", 
			referencedColumnName="idingreso",
			insertable=false, updatable=false)
	private Ingreso ingreso;
	
	@ManyToOne
	@JoinColumn(name="idproducto", 
			referencedColumnName="idproducto",
			insertable=false, updatable=false)
	private Producto producto;

	
	
}
