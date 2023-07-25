package items.model.inventory;

import org.springframework.stereotype.Component;

@Component
public class ItemInventory {
	
	private String _id;
	
	Stock stockDetails;
	
	public ItemInventory() {
	}

	public ItemInventory(String _id, Stock stockDetails) {
		this._id = _id;
		this.stockDetails = stockDetails;
	}


	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Stock getStockDetails() {
		return stockDetails;
	}

	public void setStockDetails(Stock stockDetails) {
		this.stockDetails = stockDetails;
	}
	
}
