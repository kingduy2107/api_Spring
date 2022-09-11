package com.example.final_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.final_spring.entity.Provider;
import com.example.final_spring.service.ProviderServiceImp;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/provider")
public class ProviderController {

	@Autowired
	ProviderServiceImp providerServiceImp;

	@GetMapping("")
	public ResponseEntity<?> getAllProvider() {
		List<Provider> providers = providerServiceImp.getAllProvider();
		return new ResponseEntity<List<Provider>>(providers, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> insertProvider(@RequestParam("email") String email, @RequestParam("phone") String phone){
		Provider provider = new Provider();
		provider.setEmail(email);
		provider.setPhone(phone);
		providerServiceImp.insertProvider(provider);
		return new ResponseEntity<String>(" ", HttpStatus.OK); 
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") int id) {
		providerServiceImp.deleteProductById(id);
		return new ResponseEntity<String>("", HttpStatus.OK);
	}

}
