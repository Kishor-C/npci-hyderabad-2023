package com.npci.firstms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/first")
public class FirstController {

	@Value("${server.port}")
	private String port;
	
	@GetMapping(path = "/{account}")
	public ResponseEntity<Object> fetchAccount(
			@PathVariable("account") long acc) {
		Map<String, Object> map = new HashMap<>();
		map.put("account", acc);
		map.put("balance", acc * 31);
		map.put("port", port);
		return ResponseEntity.status(200).body(map);
	}
}
