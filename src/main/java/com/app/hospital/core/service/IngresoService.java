package com.app.hospital.core.service;

import java.util.List;

import com.app.hospital.core.dto.request.IngresoRequest;
import com.app.hospital.core.dto.response.IngresoResponse;
import com.app.hospital.core.entity.Ingreso;

public interface IngresoService {
	
	Integer generatedIdIngreso();
	Ingreso addIngreso(IngresoRequest ingresoRequest);
	IngresoResponse findIngreso(Integer idIngreso);
	void pagarIngreso(Integer idIngreso,double monto);
	List<IngresoResponse> allIngreso();
	List<IngresoResponse> allIngresoByEstado(Integer idIngreso);
	
}
