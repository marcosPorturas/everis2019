package com.app.hospital.core.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngresoRequest {
	
	private Integer idIngreso;
	private Integer idSocio;
	private Integer numInvitado;
	private Double costIngreso;
	private Integer estado;
	

}
