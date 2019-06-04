package com.app.hospital.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.core.dto.response.BungalowResponse;
import com.app.hospital.core.entity.Bungalow;
import com.app.hospital.core.entity.EstBungalow;
import com.app.hospital.core.reposiroty.BungalowRepository;

@Service
public class BungalowServiceImplement implements BungalowService{

	@Autowired
	BungalowRepository bungalowRepository;
	
	
	@Override
	public List<BungalowResponse> allBungalow() {
		// TODO Auto-generated method stub
		ArrayList<BungalowResponse> lstBungalowDto = new ArrayList<BungalowResponse>();
		for(Bungalow bungalow:bungalowRepository.findAll()) {
			BungalowResponse bungalowResp= new BungalowResponse();
			bungalowResp.setIdbungalow(bungalow.getIdbungalow());
			bungalowResp.setCategoria(bungalow.getCategoria().getNomcategoria());
			bungalowResp.setPrecio(bungalow.getPrecio());
			bungalowResp.setEstado(bungalow.getEstado().getNombre());
			lstBungalowDto.add(bungalowResp);
		}
		return lstBungalowDto;
	}

	@Override
	public Bungalow addBungalow(Bungalow bungalow) {
		// TODO Auto-generated method stub
		if(bungalow.getIdbungalow()==null) {
			bungalow.setIdbungalow(generatedIdBungalow());
			EstBungalow estbungalow= new EstBungalow();
			estbungalow.setIdestado(0);
			bungalow.setEstado(estbungalow);
		}
		switch(bungalow.getCategoria().getIdcategoria()) {
			case 0:bungalow.setPrecio(100);break;
			case 1:bungalow.setPrecio(200);break;
			case 2:bungalow.setPrecio(500);break;
		}	
		return bungalowRepository.save(bungalow);
	}

	@Override
	public Bungalow findBungalow(Integer idbungalow) {
		// TODO Auto-generated method stub
		return bungalowRepository.findById(idbungalow).get();
	}

	@Override
	public void deleteBungalow(Integer idbungalow) {
		// TODO Auto-generated method stub
		bungalowRepository.deleteById(idbungalow);
	}

	@Override
	public Integer generatedIdBungalow() {
		// TODO Auto-generated method stub
		return bungalowRepository.findLastIdBungalow()+1;
	}

	
	
}
