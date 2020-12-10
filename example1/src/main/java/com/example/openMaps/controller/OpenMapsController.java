package com.example.openMaps.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.openMaps.dto.Address;
import com.example.openMaps.service.OpenMapsService;

@RestController
@RequestMapping(value = "/address")
public class OpenMapsController {

	@Autowired
	private OpenMapsService openMapsService;

	Logger logger = LoggerFactory.getLogger(OpenMapsController.class);

	@GetMapping(path = "/postalCode/{postalCode}")
	public List<Address> addressByPostalCode(@PathVariable(value = "postalCode") String postalCode) {
		logger.info(">>> postalCode {}", postalCode);
		// https://nominatim.openstreetmap.org/search?postalcode=500081&format=json
		return openMapsService.addressByPostalCode(postalCode);
	}

}
