package com.app.hospital.core.service;

import java.util.List;

import com.app.hospital.core.dto.response.BungalowResponse;
import com.app.hospital.core.entity.Bungalow;

public interface BungalowService {

	List<BungalowResponse> allBungalow();
	Bungalow addBungalow(Bungalow bungalow);
	Bungalow findBungalow(Integer idbungalow);
	void deleteBungalow(Integer idbungalow);
	Integer generatedIdBungalow();
	
}
