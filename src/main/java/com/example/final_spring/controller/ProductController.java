package com.example.final_spring.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.final_spring.entity.Catalog;
import com.example.final_spring.entity.Product;
import com.example.final_spring.entity.Provider;
import com.example.final_spring.service.FileSystemStorageServiceImp;

import com.example.final_spring.service.ProductServiceImp;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductServiceImp productServiceImp;

	@Autowired
	FileSystemStorageServiceImp fileSystemStorageServiceImp;

	@GetMapping("")
	public ResponseEntity<?> getAll() {
		List<Product> products = productServiceImp.getAllProduct();
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping("/provider")
	public ResponseEntity<?> index() {
		List<Map<String, ?>> list = productServiceImp.GetProductByProvider();
		return new ResponseEntity<List<Map<String, ?>>>(list, HttpStatus.OK);
	}

//	@GetMapping("/{name}")
//	public ResponseEntity<?> getProductByName(@PathVariable("name") String name) {
//		return new ResponseEntity<List<Product>>(productServiceImp.getProductByName(name), HttpStatus.OK);
//	}
	
	@PostMapping("")
	public ResponseEntity<?> insertProduct(@RequestParam("file") MultipartFile file, @RequestParam("name") String name,
			@RequestParam("price") int price, @RequestParam("description") String description,
			@RequestParam("catalog_id") int catalog_id, @RequestParam("inventory") int inventory,
			@RequestParam("total_sell") int total_sell, @RequestParam("provider_id") int provider_id,
			@RequestParam("status") String status) {
		fileSystemStorageServiceImp.init();
		if (fileSystemStorageServiceImp.saveFile(file)) {
			Product product = new Product();
			product.setName(name);
			product.setPrice(price);
			product.setDescription(description);
			product.setInventory(inventory);
			product.setTotalSell(total_sell);
			Catalog catalog = new Catalog();
			catalog.setId(catalog_id);
			product.setCatalog(catalog);
			Provider provider = new Provider();
			provider.setId(provider_id);
			product.setProvider(provider);
			product.setStatus(status);
			product.setImage(file.getOriginalFilename());
			productServiceImp.insertProduct(product);
		}
		return new ResponseEntity<String>("", HttpStatus.OK);
	}

	@GetMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
		productServiceImp.deleteProductById(id);
		return new ResponseEntity<String>("", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") int id) {
		Optional<Product> optional = productServiceImp.getProductById(id);
		if (optional.isPresent()) {
			return new ResponseEntity<>(optional, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable("id") int id) {
		Optional<Product> proOptional = productServiceImp.getProductById(id);
		Product product2 = proOptional.get();
		System.out.println(product2.getCatalog());
		product2.setName(product.getName());
		product2.setPrice(product.getPrice());
		product2.setDescription(product.getDescription());
		product2.setInventory(product.getInventory());
		product2.setTotalSell(product.getTotalSell());
		Catalog catalog = new Catalog();
		catalog.setId(product.getCatalog().getId());
		product2.setCatalog(catalog);
		Provider provider = new Provider();
		provider.setId(product.getProvider().getId());
		product2.setProvider(provider);
		product2.setStatus(product.getStatus());
		productServiceImp.insertProduct(product2);
		return new ResponseEntity<>("", HttpStatus.OK);
	}
	


}
