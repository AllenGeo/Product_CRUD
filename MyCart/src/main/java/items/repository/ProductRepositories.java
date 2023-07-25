package items.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import items.model.Items;

public interface ProductRepositories extends MongoRepository<Items, String> {
	
	List<Items> findByCategoryIdAndSpecialProduct(String categoryId, boolean specialProduct);


	List<Items> findByCategoryId(String categoryId);

}
