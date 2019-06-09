package com.app.hospital.core.dto.response;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HospedajeResponse {

	private Integer idHospedaje;
	private Integer idBungalow;
	private String socio;
	private Integer idIngreso;
	@Temporal(TemporalType.DATE)
	private Date fechIngreso;
	private Date fechSalida;
	private Double costoHospedaje;
	private String estado;

	
}
