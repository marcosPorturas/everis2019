package com.app.hospital.core.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Hospedaje {
	
	@Id
	private Integer idhospedaje;
	@Temporal(TemporalType.DATE)
	private Date fech_salida;
	private String hora_salida;
	private double costohospedaje;
	
	@ManyToOne
	@JoinColumn(name="idestado")
	private EstHospedaje estado;
	
	@ManyToOne
	@JoinColumn(name="idingreso")
	private Ingreso ingreso;
	
	@ManyToOne
	@JoinColumn(name="idbungalow")
	private Bungalow bungalow;
	
	
	
	
}
