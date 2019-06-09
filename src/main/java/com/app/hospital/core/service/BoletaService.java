package com.app.hospital.core.service;

import java.util.List;

import com.app.hospital.core.dto.response.BoletaDetalladaResponse;
import com.app.hospital.core.dto.response.BoletaResponse;
import com.app.hospital.core.dto.response.HospedajeBoletaResponse;
import com.app.hospital.core.dto.response.IngresoBoletaResponse;
import com.app.hospital.core.dto.response.MessageResponse;

public interface BoletaService {
	
	List<BoletaResponse> allBoleta();
	BoletaDetalladaResponse getBoletaDetalla(Integer idboleta);
	MessageResponse pagoBoleta(Integer idIngreso);
	IngresoBoletaResponse getIngreso(Integer idIngreso);
	HospedajeBoletaResponse getHospedaje(Integer idIngreso);
	double calculoIngresoBoleta(Integer idIngreso);
	double calculoHospedajeBoleta(Integer idHospedaje);
	double calculoConsumoBoleta(Integer idIngreso);
	boolean verificarIngreso(Integer idIngreso);
	boolean verificarHospedaje(Integer idIngreso);
	Integer generatedIdBoleta();
	

}
