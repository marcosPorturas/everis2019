package com.app.hospital.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.core.dto.request.IngresoRequest;
import com.app.hospital.core.dto.response.ConsumoResponse;
import com.app.hospital.core.dto.response.IngresoResponse;
import com.app.hospital.core.entity.EstIngreso;
import com.app.hospital.core.entity.EstSocio;
import com.app.hospital.core.entity.Ingreso;
import com.app.hospital.core.entity.Socio;
import com.app.hospital.core.reposiroty.IngresoRepository;
import com.app.hospital.core.reposiroty.SocioRepository;
import com.app.hospital.core.util.Utilitario;


@Service
public class IngresoServiceImplement implements IngresoService{

	@Autowired
	ConsumoService consumoService;
	
	@Autowired
	IngresoRepository ingresoRepository;
	
	@Autowired
	SocioRepository socioRepository;
	
	
	@Override
	public Ingreso addIngreso(IngresoRequest ingresoRequest) {
		// TODO Auto-generated method stub
		Ingreso ingreso = new Ingreso();
		ingreso.setIdingreso(generatedIdIngreso());
		ingreso.setHora_ingreso(Utilitario.getActualTime());
		ingreso.setCostoingreso(25.00);
		ingreso.setNuminvitado(ingresoRequest.getNumInvitado());
		
		EstSocio estSocio = new EstSocio();
		estSocio.setIdestado(2);
		
		Socio socio = socioRepository.findById(ingresoRequest.getIdSocio()).get();
		socio.setEstado(estSocio);
		
		EstIngreso estIngreso = new EstIngreso();
		estIngreso.setIdestado(0);
		
		ingreso.setSocio(socio);
		ingreso.setEstado(estIngreso);
		
		ingresoRepository.save(ingreso);
		socioRepository.save(socio);
		
		
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

	@Override
	public IngresoResponse findIngreso(Integer idIngreso) {
		// TODO Auto-generated method stub
		Double costoTotal=0.0;
		Double costoConsumo=0.0;
		Double costoInvitado=0.0;
		
		IngresoResponse ingresoResponse = new IngresoResponse();
		Ingreso ingreso = ingresoRepository.findById(idIngreso).get();
		Socio socio = socioRepository.findById(ingreso.getSocio().getIdsocio()).get();
		ingresoResponse.setIdIngreso(ingreso.getIdingreso());
		ingresoResponse.setSocio(socio.getNombre()+", "+socio.getApellido());
		ingresoResponse.setFechIngreso(ingreso.getFech_ingreso());
		ingresoResponse.setHoraIngreso(ingreso.getHora_ingreso());
		ingresoResponse.setNumInvitado(ingreso.getNuminvitado());
		ingresoResponse.setCostIngreso(ingreso.getCostoingreso());
		ingresoResponse.setEstado(ingreso.getEstado().getNombre());
		ingresoResponse.setConsumos(consumoService.allConsumoByIngreso(ingreso.getIdingreso()));
		for(ConsumoResponse consumoResp:consumoService.allConsumoByIngreso(ingreso.getIdingreso())) {
			costoConsumo = (consumoResp.getCantidad()*consumoResp.getPrecio()) + costoConsumo;
		}
		costoInvitado = 25.00*ingreso.getNuminvitado();
		costoTotal = costoConsumo + costoInvitado;
		
		ingresoResponse.setTotalConsumo(costoConsumo);
		ingresoResponse.setTotalInvitado(costoInvitado);
		ingresoResponse.setTotalPagar(costoTotal);
		return ingresoResponse;
	}

	
	
}
