package com.app.hospital.core.dto.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoletaResponse {
	
	private Integer idBoleta;
	private Date fechPago;
	private Integer idIngreso;
	private Double totalBoleta;

}
