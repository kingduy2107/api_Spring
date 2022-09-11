package com.example.final_spring.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.final_spring.entity.Product;

@Repository

public interface ProductRepository extends JpaRepository<Product, Integer> {

//	@Query(value = "call GetProductByCatalog(:catalog_id)", nativeQuery = true)
//	List<Map<String, ?>> GetProductByCatalog(@Param("catalog_id") Integer catalog_id);

	List<Product> findByName(String name);
//	@Procedure("GetProductByProvider")
	@Query(value = "call GetProductByProvider", nativeQuery = true)
	List<Map<String, ?>> GetProductByProvider();
	
}
