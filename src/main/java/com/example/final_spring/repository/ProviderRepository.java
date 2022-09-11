package com.example.final_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.final_spring.entity.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer>{
	 

}
