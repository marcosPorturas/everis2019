package com.app.hospital.core.service;

import java.util.List;

import com.app.hospital.core.dto.request.ConsumoRequest;
import com.app.hospital.core.dto.response.ConsumoResponse;

public interface ConsumoService {
	
	//Metodo Usado por el serviceIngreso para traer junto al ingreso
	//los consumos asociados al mismo
	List<ConsumoResponse> allConsumoByIngreso(Integer idIngreso);
	ConsumoResponse addConsumo(ConsumoRequest consumoRequest);
	void deleteConsumo(Integer idIngreso,Integer idProducto);
	
	
}
