package com.app.hospital.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.core.dto.request.IngresoRequest;
import com.app.hospital.core.dto.response.IngresoResponse;
import com.app.hospital.core.entity.EstIngreso;
import com.app.hospital.core.entity.Ingreso;
import com.app.hospital.core.entity.Socio;
import com.app.hospital.core.reposiroty.IngresoRepository;
import com.app.hospital.core.reposiroty.SocioRepository;
import com.app.hospital.core.util.Utilitario;


@Service
public class IngresoServiceImplement implements IngresoService{

	@Autowired
	IngresoRepository ingresoRepository;
	
	@Autowired
	SocioRepository socioRepository;
	
	
	@Override
	public Ingreso addIngreso(IngresoRequest ingresoRequest) {
		// TODO Auto-generated method stub
		Ingreso ingreso = new Ingreso();
		ingreso.setIdingreso(generatedIdIngreso());
		ingreso.setFech_ingreso(Utilitario.getActualDate());
		ingreso.setHora_ingreso(Utilitario.getActualTime());
		ingreso.setCostoingreso(25);
		ingreso.setNuminvitado(ingresoRequest.getNumInvitado());
		EstIngreso estado = new EstIngreso();
		estado.setIdestado(ingresoRequest.getEstado());
		ingreso.setEstado(estado);
		return ingreso;
	}

	@Override
	public List<IngresoResponse> allIngreso() {
		// TODO Auto-generated method stub
		List<IngresoResponse> listIngreso = new ArrayList<IngresoResponse>();
		for(Ingreso ingreso : ingresoRepository.findAll()) {
			Socio socio = socioRepository.findById(ingreso.getSocio().getIdsocio()).get();
			IngresoResponse ingresoResp = new IngresoResponse();
			ingresoResp.setIdIngreso(ingreso.getIdingreso());
			ingresoResp.setSocio(socio.getNombre()+", "+socio.getApellido());
			ingresoResp.setFechIngreso(ingreso.getFech_ingreso());
			ingresoResp.setHoraIngreso(ingreso.getHora_ingreso());
			ingresoResp.setNumInvitado(ingreso.getNuminvitado());
			ingresoResp.setCostIngreso(25.00);
			ingresoResp.setEstado(ingreso.getEstado().getNombre());
			listIngreso.add(ingresoResp);
		}
		return listIngreso;
	}

	@Override
	public Integer generatedIdIngreso() {
		// TODO Auto-generated method stub
		  Integer idingreso;
	      idingreso=ingresoRepository.findLastIdIngreso();
	      if(idingreso==null)idingreso=40000;
	      return idingreso+1;
	}

	
	
}
