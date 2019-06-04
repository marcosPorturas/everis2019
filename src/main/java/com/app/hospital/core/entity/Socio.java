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
public class Socio {
	
	@Id
	private Integer idsocio;
	private String nombre;
	private String apellido;
	private String dni;
	private String telf;

	@ManyToOne
	@JoinColumn(name="idestado")
	private EstSocio estado=new EstSocio();


	
}
