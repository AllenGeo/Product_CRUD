package com.items.resources;

import com.items.model.Review;
import java.util.List;
import java.util.ArrayList;
import com.items.model.itemPrice;
import com.items.model.stockDetails;
import com.items.model.inventory.ItemInventory;

public class ProductRequest {
	
	private String _id;
	
	private String itemName;
	
	private String categoryId;
	
	private String lastUpdateDate;
	
	itemPrice ItemPrice = new itemPrice();
	
	stockDetails StockDetails = new stockDetails();
	
	List<Review> review = new ArrayList<>();
	
	ItemInventory items = new ItemInventory();
	
	private boolean specialProduct;

	public ProductRequest() {
	}

	public ProductRequest(String _id, String itemName, String categoryId, String lastUpdateDate, itemPrice itemPrice,
			stockDetails stockDetails, List<Review> review, ItemInventory items, boolean specialProduct) {
		this._id = _id;
		this.itemName = itemName;
		this.categoryId = categoryId;
		this.lastUpdateDate = lastUpdateDate;
		ItemPrice = itemPrice;
		StockDetails = stockDetails;
		this.review = review;
		this.items = items;
		this.specialProduct = specialProduct;
	}


	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	

	public itemPrice getItemPrice() {
		return ItemPrice;
	}

	public void setItemPrice(itemPrice itemPrice) {
		ItemPrice = itemPrice;
	}

	public stockDetails getStockDetails() {
		return StockDetails;
	}

	public void setStockDetails(stockDetails stockDetails) {
		StockDetails = stockDetails;
	}

	public boolean isSpecialProduct() {
		return specialProduct;
	}

	public void setSpecialProduct(boolean specialProduct) {
		this.specialProduct = specialProduct;
	}



	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public ItemInventory getItems() {
		return items;
	}

	public void setItems(ItemInventory items) {
		this.items = items;
	}

	
}