package com.app.hospital.core.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsumoRequest {

	private Integer idIngreso;
	private Integer idProducto;
	private Integer cantidad;
	
	
}
