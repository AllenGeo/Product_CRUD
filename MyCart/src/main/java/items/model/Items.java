package items.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import items.model.inventory.ItemInventory;

@Document(collection = "Items")
public class Items {
	
	@Id
	private String _id;
	
	private String itemName;
	
	private String categoryId;
	
	private String lastUpdateDate;
	
	@JsonProperty("itemPrice")
	private itemPrice ItemPrice;
	
	@JsonProperty("stockDetails")
	private stockDetails StockDetails;
	
	private boolean specialProduct;
	
	ItemInventory items;
	
	private Review[]  review;
	
	public Items() {
	}

	public Items(String _id, String itemName, String categoryId, String lastUpdateDate, itemPrice itemPrice,
			stockDetails stockDetails, boolean specialProduct, Review[] review) {
		this._id = _id;
		this.itemName = itemName;
		this.categoryId = categoryId;
		this.lastUpdateDate = lastUpdateDate;
		ItemPrice = itemPrice;
		StockDetails = stockDetails;
		this.specialProduct = specialProduct;
		this.review = review;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}



	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getItemName() {
		return itemName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
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

	public ItemInventory getItems() {
		return items;
	}

	public void setItems(ItemInventory items) {
		this.items = items;
	}

	public boolean isSpecialProduct() {
		return specialProduct;
	}

	public void setSpecialProduct(boolean specialProduct) {
		this.specialProduct = specialProduct;
	}

	public Review[] getReview() {
		return review;
	}

	public void setReview(Review[] review) {
		this.review = review;
	}

}
