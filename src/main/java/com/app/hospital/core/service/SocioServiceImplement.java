package com.app.hospital.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.core.dto.response.SocioResponse;
import com.app.hospital.core.entity.EstSocio;
import com.app.hospital.core.entity.Socio;
import com.app.hospital.core.reposiroty.SocioRepository;

@Service
public class SocioServiceImplement implements SocioService{

  @Autowired
  SocioRepository socioRepository;
  
  @Override
  public List<SocioResponse> allSocio() {
    // TODO Auto-generated method stub
    List<SocioResponse> lstSocioResponse = new ArrayList<SocioResponse>();
    
    for(Socio socio :socioRepository.findAll()) {
    	SocioResponse socResp = new SocioResponse();
    	socResp.setIdSocio(socio.getIdsocio());
    	socResp.setNombre(socio.getNombre());
    	socResp.setApellido(socio.getApellido());
    	socResp.setDni(socio.getDni());
    	socResp.setTelf(socio.getTelf());
    	socResp.setEstado(socio.getEstado().getNombre());
    	lstSocioResponse.add(socResp);
    }
    return lstSocioResponse;
  }

  @Override
  public Socio addSocio(Socio socio) {
    // TODO Auto-generated method stub
	 if(socio.getIdsocio()== null) {
		 socio.setIdsocio(generatedIdSocio());
		 EstSocio estSocio=new EstSocio();
		 estSocio.setIdestado(1);
		 socio.setEstado(estSocio);
	}
    return socioRepository.save(socio);
  }

  @Override
  public Socio findSocio(Integer idsocio) {
    // TODO Auto-generated method stub
    return socioRepository.findById(idsocio).get();
  }

  @Override
  public void deleteSocio(Integer idsocio) {
    // TODO Auto-generated method stub
    socioRepository.deleteById(idsocio);
  }

  @Override
  public Integer generatedIdSocio() {
    // TODO Auto-generated method stub
    Integer idsocio;
      idsocio=socioRepository.findLastIdSocio();
      if(idsocio==null)idsocio=10000;
      return idsocio+1;
  }

  
  
}
