package com.app.hospital.core.dto.response;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngresoResponse {
	
	private Integer idIngreso;
	private String socio;
	private Date fechIngreso;
	private String horaIngreso;
	private Integer numInvitado;
	private Double costIngreso;
	private String estado;
	
	private List<ConsumoResponse> consumos;

}
