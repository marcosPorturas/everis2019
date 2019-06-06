package com.app.hospital.core.service;

import com.app.hospital.core.dto.request.HospedajeRequest;
import com.app.hospital.core.dto.response.HospedajeResponse;
import com.app.hospital.core.entity.Hospedaje;

public interface HospedajeService {

	Hospedaje addHospedaje(HospedajeRequest hospedajeRequest);
	HospedajeResponse findHospedaje(Integer idHospedaje);
	Integer generatedIdHospedaje();
}
