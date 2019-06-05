package com.app.hospital.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hospital.core.dto.request.ConsumoRequest;
import com.app.hospital.core.service.ConsumoService;

@RestController
@RequestMapping("/api/v1/consumos")
public class ConsumoController {

	@Autowired
	ConsumoService consumoService;
	
	@PostMapping
	public void addConsumo(@RequestBody ConsumoRequest consumoRequest) {
		consumoService.addConsumo(consumoRequest);
	}
	
	@DeleteMapping("{idingreso}/{idproducto}")
	public void deleteConsumo(@PathVariable("idingreso")Integer idIngreso,
			@PathVariable("idproducto")Integer idProducto) {
		consumoService.deleteConsumo(idIngreso,idProducto);
	}
		
}
