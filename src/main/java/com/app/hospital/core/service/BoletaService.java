package com.app.hospital.core.service;

import com.app.hospital.core.dto.response.MessageResponse;

public interface BoletaService {
	
	
	MessageResponse pagoBoleta(Integer idIngreso);
	double calculoIngresoBoleta(Integer idIngreso);
	double calculoHospedajeBoleta(Integer idIngreso);
	boolean verificarIngreso(Integer idIngreso);
	boolean verificarHospedaje(Integer idIngreso);

}
