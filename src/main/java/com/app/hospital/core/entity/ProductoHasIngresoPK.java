package com.app.hospital.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class ProductoHasIngresoPK implements Serializable{

	/**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Column(name="idingreso")
	private int idingreso;
	
	@Column(name="idproducto")
	private int idproducto;

	
	
	
	
}
