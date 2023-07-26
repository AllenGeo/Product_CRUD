package com.items.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.items.model.Items;

public interface ProductRepository extends MongoRepository<Items, String>{

	List<Items> findByCategoryIdAndSpecialProduct(String categoryId, boolean specialProduct);
	
	List<Items> findByCategoryId(String categoryId);
	
}
