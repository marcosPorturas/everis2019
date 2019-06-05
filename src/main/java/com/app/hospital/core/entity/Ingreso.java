package com.app.hospital.core.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ingreso {
	
	@Id
	private Integer idingreso;
	
	@Temporal(TemporalType.DATE)
	private Date fech_ingreso;
	
	private String hora_ingreso;
	private int numinvitado;
	private Double costoingreso=25.00;
	
	@PrePersist
	public void setearFecha() {
		fech_ingreso = new Date();
	}
	
	@ManyToOne
	@JoinColumn(name="idestado")
	private EstIngreso estado;
	
	@ManyToOne
	@JoinColumn(name="idsocio")
	private Socio socio;
	
	
}
