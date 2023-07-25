package items.resources;

import items.model.Review;
import items.model.itemPrice;
import items.model.stockDetails;
import items.model.inventory.ItemInventory;

public class ProductRequest {
	
	private String _id;
	
	private String itemName;
	
	private String categoryId;
	
	private String lastUpdateDate;
	
	itemPrice ItemPrice = new itemPrice();
	
	stockDetails StockDetails = new stockDetails();
	
	Review[] review = new Review[10];
	
	ItemInventory items = new ItemInventory();
	
	private boolean specialProduct;

	public ProductRequest() {
	}

	public ProductRequest(String _id, String itemName, String categoryId, String lastUpdateDate, itemPrice itemPrice,
			stockDetails stockDetails, Review[] review, ItemInventory items, boolean specialProduct) {
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


	public Review[] getReview() {
		return review;
	}


	public void setReview(Review[] review) {
		this.review = review;
	}

	public ItemInventory getItems() {
		return items;
	}

	public void setItems(ItemInventory items) {
		this.items = items;
	}

	
}
