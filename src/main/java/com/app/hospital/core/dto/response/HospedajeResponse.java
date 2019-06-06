package com.app.hospital.core.dto.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HospedajeResponse {

	private Integer idHospedaje;
	private Integer idBungalow;
	private Integer idIngreso;
	private Date fechSalida;
	private String horaSalida;
	private Double costoTotal;
	private String estado;
	
}
