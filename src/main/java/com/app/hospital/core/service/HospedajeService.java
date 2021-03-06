package com.app.hospital.core.service;

import java.util.List;

import com.app.hospital.core.dto.request.HospedajeRequest;
import com.app.hospital.core.dto.response.HospedajeResponse;
import com.app.hospital.core.entity.Hospedaje;

public interface HospedajeService {

	Integer generatedIdHospedaje();
	void pagarHospedaje(Integer idHospedaje,double monto);
	List<HospedajeResponse> allHospedajeByEstado(Integer idEstado);
	Hospedaje addHospedaje(HospedajeRequest hospedajeRequest);
	HospedajeResponse findHospedaje(Integer idHospedaje);
	
}
