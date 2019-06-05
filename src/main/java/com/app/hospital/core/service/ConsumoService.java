package com.app.hospital.core.service;

import java.util.List;

import com.app.hospital.core.dto.request.ConsumoRequest;
import com.app.hospital.core.dto.response.ConsumoResponse;

public interface ConsumoService {
	
	List<ConsumoResponse> allConsumoByIngreso(Integer idIngreso);
	ConsumoResponse addConsumo(ConsumoRequest consumoRequest);
	
	
}
