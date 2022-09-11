package com.example.final_spring.service;

import java.util.List;

import com.example.final_spring.entity.Provider;

public interface ProviderServiceImp {
	public List<Provider> getAllProvider();
	
	public void insertProvider(Provider provider);
	
	public void deleteProductById(Integer id);
	
}
