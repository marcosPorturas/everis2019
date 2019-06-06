package com.app.hospital.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.core.dto.request.HospedajeRequest;
import com.app.hospital.core.dto.response.HospedajeResponse;
import com.app.hospital.core.entity.Bungalow;
import com.app.hospital.core.entity.EstBungalow;
import com.app.hospital.core.entity.EstHospedaje;
import com.app.hospital.core.entity.EstSocio;
import com.app.hospital.core.entity.Hospedaje;
import com.app.hospital.core.entity.Ingreso;
import com.app.hospital.core.entity.Socio;
import com.app.hospital.core.reposiroty.BungalowRepository;
import com.app.hospital.core.reposiroty.HospedajeRepository;
import com.app.hospital.core.reposiroty.IngresoRepository;
import com.app.hospital.core.reposiroty.SocioRepository;


@Service
public class HospedajeServiceImplement implements HospedajeService{

	@Autowired
	HospedajeRepository hospedajeRepository;
	
	@Autowired
	IngresoRepository ingresoRepository;
	
	@Autowired
	BungalowRepository bungalowRepository;
	
	@Autowired
	SocioRepository socioRepository;
	
	@Override
	public Integer generatedIdHospedaje() {
		// TODO Auto-generated method stub
		  Integer idhospedaje;
		  idhospedaje=hospedajeRepository.findLastIdHospedaje();
	      if(idhospedaje==null)idhospedaje=50000;
	      return idhospedaje+1;
	}


	@Override
	public Hospedaje addHospedaje(HospedajeRequest hospedajeRequest) {
		// TODO Auto-generated method stub
		Hospedaje hospedaje = new Hospedaje();
		Bungalow bungalow = bungalowRepository.findById(hospedajeRequest.getIdBungalow()).get();
		Ingreso ingreso = ingresoRepository.findById(hospedajeRequest.getIdIngreso()).get();
		Socio socio = socioRepository.findById(ingreso.getSocio().getIdsocio()).get();
		
		hospedaje.setIdhospedaje(generatedIdHospedaje());
		hospedaje.setIngreso(ingreso);
		hospedaje.setBungalow(bungalow);
		EstHospedaje estHospedaje = new EstHospedaje();
		estHospedaje.setIdestado(0);
		hospedaje.setEstado(estHospedaje);
		
		EstBungalow estBungalow = new EstBungalow();
		estBungalow.setIdestado(1);
		bungalow.setEstado(estBungalow);
	
		EstSocio estSocio = new EstSocio();
		estSocio.setIdestado(1);
		socio.setEstado(estSocio);
		
		bungalowRepository.save(bungalow);
		socioRepository.save(socio);
		
		return hospedajeRepository.save(hospedaje);
	}


	@Override
	public HospedajeResponse findHospedaje(Integer idHospedaje) {
		// TODO Auto-generated method stub
		HospedajeResponse hospedajeResp = new HospedajeResponse();
		Hospedaje hospedaje = hospedajeRepository.findById(idHospedaje).get();
		hospedajeResp.setIdHospedaje(hospedaje.getIdhospedaje());
		hospedajeResp.setFechSalida(hospedaje.getFech_salida());
		hospedajeResp.setHoraSalida(hospedaje.getHora_salida());
		hospedajeResp.setIdBungalow(hospedaje.getBungalow().getIdbungalow());
		hospedajeResp.setIdIngreso(hospedaje.getIngreso().getIdingreso());
		hospedajeResp.setCostoTotal(hospedaje.getCostohospedaje());
		hospedajeResp.setEstado(hospedaje.getEstado().getNombre());
		return hospedajeResp;
	}

	
	
}
