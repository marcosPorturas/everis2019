package com.app.hospital.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hospital.core.dto.response.MessageResponse;
import com.app.hospital.core.service.BoletaService;

@RestController
@RequestMapping("/api/v1/boletas")
public class BoletaController {

	@Autowired
	BoletaService boletaService;
	
	
	@GetMapping("/pagar/{idIngreso}")
	public MessageResponse agregarBoleta(@PathVariable("idIngreso")Integer idIngreso) {
		return boletaService.pagoBoleta(idIngreso);
	}
	
	@GetMapping("/ingreso/{idIngreso}")
	public void pagarIngresoBoleta(@PathVariable("idIngreso")Integer idIngreso) {
		boletaService.calculoIngresoBoleta(idIngreso);
	}
	
	@GetMapping("/hospedaje/{idIngreso}")
	public void pagarHospedajeBoleta(@PathVariable("idIngreso")Integer idIngreso) {
		boletaService.calculoHospedajeBoleta(idIngreso);
	}
}
