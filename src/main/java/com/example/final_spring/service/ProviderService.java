package com.example.final_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.final_spring.entity.Provider;
import com.example.final_spring.repository.ProviderRepository;

@Service
public class ProviderService implements ProviderServiceImp{
	
	@Autowired
	ProviderRepository providerRepository;
	
	@Override
	public List<Provider> getAllProvider() {
		// TODO Auto-generated method stub
		return providerRepository.findAll();
	}

	@Override
	public void insertProvider(Provider provider) {
		// TODO Auto-generated method stub
		providerRepository.save(provider);
	}

	@Override
	public void deleteProductById(Integer id) {
		// TODO Auto-generated method stub
		providerRepository.deleteById(id);
	}
	

}
