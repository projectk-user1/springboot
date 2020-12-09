package com.example.example1.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.example1.dto.Address;

@RestController
@RequestMapping(value = "/address")
public class HomeController {

	@Value("${openmaps.api.url}")
	private String openMapsApiUrl;

	@GetMapping(path = "/postalCode/{postalCode}", produces = { "application/json", "application/xml" })
	List<Address> addressByPostalCode(@PathVariable(value = "postalCode") String postalCode) {
		// https://nominatim.openstreetmap.org/search?postalcode=500081&format=json

		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = openMapsApiUrl + postalCode;
		ResponseEntity<Address[]> response = restTemplate.getForEntity(fooResourceUrl, Address[].class);
		Address[] address = response.getBody();
		List<Address> list = Arrays.asList(address);
		return list;
	}
}
