package items.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import items.model.Items;
import items.model.stockDetails;
import items.model.inventory.ItemInventory;
import items.model.inventory.Stock;
import items.repository.ProductRepositories;
import items.resources.ProductRequest;

@RestController
public class ProductController {
	
	@Autowired
	private final ProductRepositories productRepository;
	
	public ProductController(ProductRepositories productRepository) {
		this.productRepository = productRepository;
	}
	
	@GetMapping("/products")
	
	public ResponseEntity<List<Items>> getAllProducts(){
		return ResponseEntity.ok(this.productRepository.findAll());
	}
	
	@PostMapping("/products")
	
	public ResponseEntity<Items> createProduct(@RequestBody ProductRequest productRequest) {
	    Items product = new Items();
	    Optional<Items> element = this.productRepository.findById(productRequest.get_id());

	    if (!element.isPresent()) {
	        product.set_id(productRequest.get_id());
	        product.setItemName(productRequest.getItemName());
	        product.setCategoryId(productRequest.getCategoryId());
	        product.setLastUpdateDate(productRequest.getLastUpdateDate());
	        product.setItemPrice(productRequest.getItemPrice());
	        product.setStockDetails(productRequest.getStockDetails());
	        product.setSpecialProduct(productRequest.isSpecialProduct());
	        product.setReview(productRequest.getReview());
	        return ResponseEntity.ok(this.productRepository.save(product));
	    } else {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
	    }
	}

	@GetMapping("/products/{_id}")
	
	public ResponseEntity  getAllProductsById(@PathVariable String _id){
		
		Optional<Items> product = this.productRepository.findById(_id);
		
		if(!product.isEmpty()) {
			return ResponseEntity.ok(product.get());
		} else {
			return ResponseEntity.ok("Product with id "+ _id + " not found");
		}
	}
	
	@GetMapping("/products/category/{categoryId}")
	public ResponseEntity<List<Items>> getProductsByCategoryId(
	        @PathVariable String categoryId,
	        @RequestParam(required = false) Boolean includeSpecial) {

	    List<Items> products;

	    if (includeSpecial != null && includeSpecial) {
	        products = this.productRepository.findByCategoryIdAndSpecialProduct(categoryId, true);
	    } else {
	        products = this.productRepository.findByCategoryId(categoryId);
	    }

	    if (!products.isEmpty()) {
	        return ResponseEntity.ok(products);
	    } else {
	        return ResponseEntity.ok(Collections.emptyList());
	    }
	}
	
	 @PutMapping("/products/updateStock")
	    public ResponseEntity<String> updateStock(@RequestBody Map<String, List<ItemInventory>> stockUpdateMap) {
	        List<ItemInventory> stockUpdateList = stockUpdateMap.get("items");
	        if (stockUpdateList == null || stockUpdateList.isEmpty()) {
	            return ResponseEntity.badRequest().body("Invalid request format.");
	        }

	        boolean updated = false;

	        for (ItemInventory itemUpdate : stockUpdateList) {
	            String _id = itemUpdate.get_id();
	            Stock stock = itemUpdate.getStockDetails();
	            int soldOut = (stock.getSoldOut());
	            int damaged = (stock.getDamaged());

	            Optional<Items> optionalProduct = productRepository.findById(_id);
	            if (optionalProduct.isPresent()) {
	                Items items = optionalProduct.get();
	                int avail = items.getStockDetails().getAvailableStock();
	                avail = avail - soldOut - damaged;
	                String unitmeasure = items.getStockDetails().getUnitOfMeasure();
	                stockDetails temp = new stockDetails(avail, unitmeasure);
	                items.setStockDetails(temp);
	                productRepository.save(items);
	                updated = true;
	            }
	        }

	        if (updated) {
	            return ResponseEntity.ok("Stock details updated successfully.");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No products found to update.");
	        }
	    }

}
