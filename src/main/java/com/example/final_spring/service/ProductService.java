package com.example.final_spring.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.final_spring.entity.Product;
import com.example.final_spring.entity.Provider;
import com.example.final_spring.repository.ProductRepository;

@Service
@Transactional
public class ProductService implements ProductServiceImp {
	@Autowired
	ProductRepository productRepository;
	
	
	

	@Override
	public List<Map<String, ?>> GetProductByProvider() {
		// TODO Auto-generated method stub
//		return productRepository.findAll();
		return productRepository.GetProductByProvider();
	}

//	@Override
//	public List<Product> getProductByName(String name) {
//		return productRepository.findByName(name);
//	}

	@Override
	public void insertProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}

	@Override
	public void deleteProductById(Integer id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProductById(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	

	

//	@Override
//	public List<Map<String, ?>> GetProductByCatalog(Integer catalog_id) {
//		// TODO Auto-generated method stub
//		return productRepository.GetProductByCatalog(catalog_id);
//	}

	

//	Nơi gọi lấy db

}
