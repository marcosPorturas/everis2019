package com.app.hospital.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hospital.core.dto.response.BoletaDetalladaResponse;
import com.app.hospital.core.dto.response.BoletaResponse;
import com.app.hospital.core.dto.response.MessageResponse;
import com.app.hospital.core.service.BoletaService;
import com.app.hospital.core.service.HospedajeService;
import com.app.hospital.core.service.IngresoService;

@RestController
@RequestMapping("/api/v1/boletas")
public class BoletaController {

	@Autowired
	BoletaService boletaService;
	
	@Autowired
	IngresoService ingresoService;
	
	@Autowired
	HospedajeService hospedajeService;
	
	
	@GetMapping("/{idboleta}")
  public BoletaDetalladaResponse getBoletaDetails(@PathVariable("idboleta")Integer idboleta){
    return boletaService.getBoletaDetalla(idboleta);
  }
	
	@GetMapping
	public List<BoletaResponse> allBoletas(){
	  return boletaService.allBoleta();
	}
	
	@GetMapping("/pagar/{idIngreso}")
	public MessageResponse agregarBoleta(@PathVariable("idIngreso")Integer idIngreso) {
		return boletaService.pagoBoleta(idIngreso);
	}
	
	@GetMapping("/ingreso/{idIngreso}")
	public void pagarIngresoBoleta(@PathVariable("idIngreso")Integer idIngreso) {
		double monto = boletaService.calculoIngresoBoleta(idIngreso);
		ingresoService.pagarIngreso(idIngreso, monto);
	}
	
	@GetMapping("/hospedaje/{idHospedaje}")
	public void pagarHospedajeBoleta(@PathVariable("idHospedaje")Integer idHospedaje) {
	  double monto = boletaService.calculoHospedajeBoleta(idHospedaje);
	  hospedajeService.pagarHospedaje(idHospedaje, monto);
	}
}
