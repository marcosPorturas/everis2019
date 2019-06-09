package com.app.hospital.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hospital.core.dto.request.IngresoRequest;
import com.app.hospital.core.dto.response.IngresoResponse;
import com.app.hospital.core.service.IngresoService;

@RestController
@RequestMapping("/api/v1/ingresos")
public class IngresoController {

	@Autowired
	IngresoService ingresoService;
	
	
	@GetMapping
	public List<IngresoResponse> allIngreso() {
		return ingresoService.allIngreso();
	}
	
	@GetMapping("/{idingreso}/consumos")
	public IngresoResponse findIngresoWitchConsumo(@PathVariable("idingreso")Integer idIngreso) {
		return ingresoService.findIngreso(idIngreso);
	}
	
	@GetMapping("/pagados")
	public List<IngresoResponse> findIngresoPagados() {
		return ingresoService.allIngresoByEstado(1);
	}
	
	@GetMapping("/pendientes")
	public List<IngresoResponse> findIngresoPemdientes() {
		return ingresoService.allIngresoByEstado(0);
	}
	
	@PostMapping
	public void addIngreso(@RequestBody IngresoRequest ingresoRequest) {
		ingresoService.addIngreso(ingresoRequest);
	}
	
}
