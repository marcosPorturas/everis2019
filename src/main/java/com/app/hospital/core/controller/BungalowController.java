package com.app.hospital.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hospital.core.dto.response.BungalowResponse;
import com.app.hospital.core.service.BungalowService;

@RestController
@RequestMapping("/api/v1/bungalows")
public class BungalowController {

	
	@Autowired
	BungalowService bungalowService;
	
	@GetMapping
	public List<BungalowResponse> getAllBungalow(){
		return bungalowService.allBungalow();
	}
	
}
