package com.app.hospital.core.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocioResponse {

	private Integer idSocio;
	private String nombre;
	private String apellido;
	private String dni;
	private String telf;
	private String estado;

}
