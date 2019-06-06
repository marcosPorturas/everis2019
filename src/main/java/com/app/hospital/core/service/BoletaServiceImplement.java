package com.app.hospital.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.hospital.core.dto.response.MessageResponse;
import com.app.hospital.core.entity.Bungalow;
import com.app.hospital.core.entity.Consumo;
import com.app.hospital.core.entity.EstBungalow;
import com.app.hospital.core.entity.EstHospedaje;
import com.app.hospital.core.entity.EstSocio;
import com.app.hospital.core.entity.Hospedaje;
import com.app.hospital.core.entity.Ingreso;
import com.app.hospital.core.entity.Socio;
import com.app.hospital.core.reposiroty.BungalowRepository;
import com.app.hospital.core.reposiroty.ConsumoRepository;
import com.app.hospital.core.reposiroty.HospedajeRepository;
import com.app.hospital.core.reposiroty.IngresoRepository;
import com.app.hospital.core.reposiroty.SocioRepository;
import com.app.hospital.core.util.Utilitario;

@Service
public class BoletaServiceImplement implements BoletaService{

	@Autowired
	HospedajeRepository hospedajeRepository;
	
	@Autowired
	IngresoRepository ingresoRepository;

	@Autowired
	ConsumoRepository consumoRepository;
	
	@Autowired
	BungalowRepository bungalowRepository;
	
	@Autowired
	SocioRepository socioRepository;
	

	@Override
	public MessageResponse pagoBoleta(Integer idIngreso) {
		// TODO Auto-generated method stub
		Integer numIngreso=null;
		String msj="";
		MessageResponse messageResponse = new MessageResponse();
		try {
			//Siempre se debe verificar que
			//el ingreso este pagado
			if(verificarIngreso(idIngreso)) {
				Hospedaje hospedaje = hospedajeRepository.findByIngresoIdingreso(idIngreso);
				if(hospedaje == null) {
					//generar boleta pues no hay hospedaje
					numIngreso = idIngreso;
					msj = "Generar Boleta, solo hay ingreso que se Pago";
				}else {
					if(hospedaje.getEstado().getIdestado()==1) {
						//generar boleta porque pago hospedaje e ingreso
						numIngreso = idIngreso;
						msj = "Generar Boleta, se pago ingreso y hospedaje";
					}else {
						//No generar Boleta hasta pagar el hostedaje
						numIngreso = idIngreso;
						msj = "No Generar Boleta, el hospedaje no se pago";
					}
				}	
			}
			else {
				numIngreso = idIngreso;
				msj = "No se pago aun el Ingreso";
			}
		}catch(Exception e) {
			msj = "No se encontro el Id";
		}
		messageResponse.setIdIngreso(numIngreso);
		messageResponse.setMensaje(msj);
		return messageResponse;
	}

	@Override
	public boolean verificarIngreso(Integer idIngreso) {
		// TODO Auto-generated method stub
			Ingreso ingreso = ingresoRepository.findById(idIngreso).get();
			if(ingreso.getEstado().getIdestado() == 1) {
				return true;
			}else {
			return false;
			}
	}

	@Override
	public boolean verificarHospedaje(Integer idIngreso) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double calculoIngresoBoleta(Integer idIngreso) {
		// TODO Auto-generated method stub
		double sumaTotal=0;
		List<Consumo> lstConsumo = new ArrayList<Consumo>();
		lstConsumo = consumoRepository.findAllByPkIdingreso(idIngreso);
		for(Consumo consumo : lstConsumo) {
			sumaTotal = sumaTotal + (consumo.getPrecio_venta()*consumo.getCantidad());
		}
		return sumaTotal;
	}

	@Override
	public double calculoHospedajeBoleta(Integer idIngreso) {
		// TODO Auto-generated method stub
		double totalHospedaje = 0;
		Hospedaje hospedaje =  hospedajeRepository.findByIngresoIdingreso(idIngreso);
		hospedaje.setFech_salida(new Date());
		hospedaje.setHora_salida(Utilitario.getActualTime());
		Integer dias = (int) ((hospedaje.getFech_salida().getTime()-hospedaje.getIngreso().getFech_ingreso().getTime())/86400000);
		Double costo = hospedaje.getBungalow().getPrecio();
		totalHospedaje = dias*costo;
		hospedaje.setCostohospedaje(totalHospedaje);
		
		EstHospedaje estHospedaje = new EstHospedaje();
		estHospedaje.setIdestado(1);
		hospedaje.setEstado(estHospedaje);
		
		Bungalow bungalow = bungalowRepository.findById(hospedaje.getBungalow().getIdbungalow()).get();	
		EstBungalow estBungalow = new EstBungalow();
		estBungalow.setIdestado(0);
		bungalow.setEstado(estBungalow);
		
		Socio socio = socioRepository.findById(hospedaje.getIngreso().getSocio().getIdsocio()).get();
		EstSocio estSocio = new EstSocio();
		estSocio.setIdestado(0);
		socio.setEstado(estSocio);
		
		socioRepository.save(socio);
		bungalowRepository.save(bungalow);
		hospedajeRepository.save(hospedaje);
		
		return totalHospedaje;
	}

	
	
	
}
