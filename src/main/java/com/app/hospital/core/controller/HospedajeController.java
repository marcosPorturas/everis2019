package com.app.hospital.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hospital.core.dto.request.HospedajeRequest;
import com.app.hospital.core.dto.response.HospedajeResponse;
import com.app.hospital.core.service.HospedajeService;


@RestController
@RequestMapping("/api/v1/hospedajes")
public class HospedajeController {
	
	@Autowired
	HospedajeService hospedajeService;
	
	
	@PostMapping
	public void addHospedaje(@RequestBody HospedajeRequest hospedajeRequest) {
		hospedajeService.addHospedaje(hospedajeRequest);
	}
	
	@GetMapping("/{idhospedaje}")
	public HospedajeResponse findHospedaje(@PathVariable("idhospedaje")Integer idhospedaje) {
		return hospedajeService.findHospedaje(idhospedaje);
	}

}
