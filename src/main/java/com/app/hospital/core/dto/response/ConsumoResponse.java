package com.app.hospital.core.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsumoResponse {

	private Integer idIngreso;
	private Integer idProducto;
	private Integer cantidad;
	private Double precio;
}
