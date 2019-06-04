package com.app.hospital.core.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Boleta {
	
	@Id
	private Integer idboleta;
	private double pago;
	private Date fech_pago;
		
	@ManyToOne
	@JoinColumn(name="idingreso")
	private Ingreso ingreso;
	
	
	
	

}
