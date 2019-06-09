package com.app.hospital.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.core.dto.response.BoletaDetalladaResponse;
import com.app.hospital.core.dto.response.BoletaResponse;
import com.app.hospital.core.dto.response.ConsumoResponse;
import com.app.hospital.core.dto.response.HospedajeBoletaResponse;
import com.app.hospital.core.dto.response.IngresoBoletaResponse;
import com.app.hospital.core.dto.response.MessageResponse;
import com.app.hospital.core.entity.Boleta;
import com.app.hospital.core.entity.Consumo;
import com.app.hospital.core.entity.Hospedaje;
import com.app.hospital.core.entity.Ingreso;
import com.app.hospital.core.entity.Socio;
import com.app.hospital.core.reposiroty.BoletaRepository;
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
	
	@Autowired
	BoletaRepository boletaRepository;
	
	@Autowired
	ConsumoService consumoService;
	
	@Autowired
	IngresoService ingresoService;
	
	@Autowired
	HospedajeService hospedajeService;
	@Override
	public MessageResponse pagoBoleta(Integer idIngreso) {
		// TODO Auto-generated method stub
		Integer numIngreso=null;
		String msj="";
		MessageResponse messageResponse = new MessageResponse();
		Boleta boleta = new Boleta();
		try {

			if(verificarIngreso(idIngreso)) {
				Hospedaje hospedaje = hospedajeRepository.findByIngresoIdingreso(idIngreso);
				if(hospedaje == null) {

					numIngreso = idIngreso;
					msj = "Generar Boleta, solo hay ingreso que se Pago";
					boleta.setIdboleta(generatedIdBoleta());
					boleta.setPago(calculoConsumoBoleta(idIngreso)+calculoIngresoBoleta(idIngreso));
				}else {
					if(hospedaje.getEstado().getIdestado()==1) {
						numIngreso = idIngreso;
						msj = "Generar Boleta, se pago ingreso y hospedaje";
						boleta.setIdboleta(generatedIdBoleta());
	          boleta.setPago(calculoConsumoBoleta(idIngreso)+calculoIngresoBoleta(idIngreso)+calculoHospedajeBoleta(idIngreso));
					}else {
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
		double sumaIngreso=0;		
		Ingreso ingreso = ingresoRepository.findById(idIngreso).get();
		sumaIngreso = ingreso.getCostoingreso()*ingreso.getNuminvitado();
		return sumaIngreso;
	}
 
	@Override
	public double calculoHospedajeBoleta(Integer idHospedaje) {
		// TODO Auto-generated method stub
		double totalHospedaje = 0;
		try {
		Hospedaje hospedaje =  hospedajeRepository.findById(idHospedaje).get();
		hospedaje.setFech_salida(new Date());
		hospedaje.setHora_salida(Utilitario.getActualTime());
		Integer dias = Utilitario.calculoDias(hospedaje.getIngreso().getFech_ingreso(),hospedaje.getFech_salida());
		Double costo = hospedaje.getBungalow().getPrecio();
		totalHospedaje = dias*costo;
		}catch(Exception e) {
		  
		}
		return totalHospedaje;
	}

  @Override
  public List<BoletaResponse> allBoleta() {
    // TODO Auto-generated method stub
    List<BoletaResponse> lstBoletaResponse = new ArrayList<BoletaResponse>();
    
    for(Boleta boleta : boletaRepository.findAll()) {
      Socio socio = socioRepository.findById(boleta.getIngreso().getSocio().getIdsocio()).get();
      BoletaResponse boletaResponse = new BoletaResponse();
      boletaResponse.setIdBoleta(boleta.getIdboleta());
      boletaResponse.setIdIngreso(boleta.getIngreso().getIdingreso());
      boletaResponse.setFechPago(boleta.getFech_pago());
      boletaResponse.setSocio(socio.getApellido()+", "+socio.getNombre());
      boletaResponse.setTotalBoleta(boleta.getPago());
      lstBoletaResponse.add(boletaResponse);
    }
    return lstBoletaResponse;
  }

  @Override
  public IngresoBoletaResponse getIngreso(Integer idIngreso) {
    // TODO Auto-generated method stub
    Ingreso ingreso = ingresoRepository.findById(idIngreso).get();
    Socio socio = socioRepository.findById(ingreso.getSocio().getIdsocio()).get();
    IngresoBoletaResponse ingresoResp = new IngresoBoletaResponse();
    ingresoResp.setIdIngreso(ingreso.getIdingreso());
    ingresoResp.setSocio(socio.getApellido()+", "+socio.getNombre());
    ingresoResp.setNumInvitado(ingreso.getNuminvitado());
    ingresoResp.setCostoInvitado(25);
    ingresoResp.setCostoIngreso(ingreso.getNuminvitado()*25);
    return ingresoResp;
  }

  @Override
  public HospedajeBoletaResponse getHospedaje(Integer idIngreso) {
    // TODO Auto-generated method stub
    try {
    HospedajeBoletaResponse hospedajeResp = new HospedajeBoletaResponse();
    Hospedaje hospedaje = hospedajeRepository.findByIngresoIdingreso(idIngreso);
    hospedajeResp.setIdHospedaje(hospedaje.getIdhospedaje());
    hospedajeResp.setIdBungalow(hospedaje.getBungalow().getIdbungalow());
    hospedajeResp.setFechIngreso(hospedaje.getIngreso().getFech_ingreso());
    hospedajeResp.setFechSalida(hospedaje.getFech_salida());
    hospedajeResp.setDias(Utilitario.calculoDias(hospedajeResp.getFechIngreso(),hospedajeResp.getFechSalida()));
    hospedajeResp.setCostoBungalow(hospedaje.getBungalow().getPrecio());
    hospedajeResp.setCostoHospedaje(hospedajeResp.getDias()*hospedajeResp.getCostoBungalow());
    return hospedajeResp;
    }catch(Exception e) {
      return null;
    }
  }

  @Override
  public double calculoConsumoBoleta(Integer idIngreso) {
    // TODO Auto-generated method stub
    double sumaConsumo = 0;
    List<Consumo> lstConsumo = new ArrayList<Consumo>();

    lstConsumo = consumoRepository.findAllByPkIdingreso(idIngreso);
    for(Consumo consumo : lstConsumo) {
      sumaConsumo = sumaConsumo + (consumo.getPrecio_venta()*consumo.getCantidad());
    }
    
    return sumaConsumo;
  }

  @Override
  public BoletaDetalladaResponse getBoletaDetalla(Integer idboleta) {
       
      Boleta boleta = boletaRepository.findById(idboleta).get();
      BoletaDetalladaResponse boletaResponse = new BoletaDetalladaResponse();
      boletaResponse.setIdBoleta(boleta.getIdboleta());
      boletaResponse.setFechPago(boleta.getFech_pago());
      boletaResponse.setTotalBoleta(boleta.getPago());
      IngresoBoletaResponse ingBolResponse = getIngreso(boleta.getIngreso().getIdingreso());
      HospedajeBoletaResponse hosBolResponse = getHospedaje(boleta.getIngreso().getIdingreso());
      boletaResponse.setIngreso(ingBolResponse);
      boletaResponse.setHospedaje(hosBolResponse);
      List<ConsumoResponse> lstConsumo = consumoService.allConsumoByIngreso(boleta.getIngreso().getIdingreso());
      boletaResponse.setConsumos(lstConsumo);
      boletaResponse.setTotalIngreso(calculoIngresoBoleta(boleta.getIngreso().getIdingreso()));
      boletaResponse.setTotalConsumo(calculoConsumoBoleta(boleta.getIngreso().getIdingreso()));
      boletaResponse.setTotalHospedaje(calculoHospedajeBoleta(boleta.getIngreso().getIdingreso()));  
    
      return boletaResponse;
  }

  @Override
  public Integer generatedIdBoleta() {
    // TODO Auto-generated method stub
    Integer idboleta;
    idboleta=boletaRepository.findLastIdBoleta();
    if(idboleta==null)idboleta=60000;
    return idboleta+1;
  }

	
	
	
}
