package com.app.hospital.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hospital.core.dto.response.SocioResponse;
import com.app.hospital.core.entity.Socio;
import com.app.hospital.core.service.SocioService;

@RestController
@RequestMapping("/api/v1/socios")
public class SocioController {

	@Autowired
	SocioService socioService;

	@GetMapping
	public List<SocioResponse> getAllSocio() {
		return socioService.allSocio();
	}
	
	@PostMapping
	public void addSocico(@RequestBody Socio socio) {
		socioService.addSocio(socio);
	}
	
	@PutMapping
	public void updateSocio(@RequestBody Socio socio) {
		socioService.addSocio(socio);
	}
	
	@DeleteMapping("/{idsocio}")
	public void deleteSocio(@PathVariable("idsocio")Integer idsocio) {
		socioService.deleteSocio(idsocio);
	}

}
