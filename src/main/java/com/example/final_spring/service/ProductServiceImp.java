package com.example.final_spring.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.final_spring.entity.Product;
import com.example.final_spring.entity.Provider;



public interface ProductServiceImp {
	
	public List<Product> getAllProduct();
	public List<Map<String, ?>> GetProductByProvider();
//	public List<Product> getProductByName(String name);
//	public List<Map<String, ?>> GetProductByCatalog(Integer catalog_id);
	public void insertProduct(Product product);
	public void deleteProductById(Integer id);
	public Optional<Product> getProductById(int id);
	
	
}
