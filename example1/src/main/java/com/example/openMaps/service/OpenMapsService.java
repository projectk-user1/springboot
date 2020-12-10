package com.example.openMaps.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.openMaps.dto.Address;

@Service
public class OpenMapsService {

	@Value("${openmaps.api.url}")
	private String openMapsApiUrl;

	@Autowired
	private RestTemplate restTemplate;

	Logger logger = LoggerFactory.getLogger(OpenMapsService.class);

	@Cacheable(value="address",key="#postalCode")
	public List<Address> addressByPostalCode(String postalCode) {
		logger.info(">>> Postal Code {}", postalCode);
		String fooResourceUrl = openMapsApiUrl + postalCode;
		ResponseEntity<Address[]> response = restTemplate.getForEntity(fooResourceUrl, Address[].class);
		Address[] address = response.getBody();
		List<Address> list = Arrays.asList(address);
		return list;
	}
}
