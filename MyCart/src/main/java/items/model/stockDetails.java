package items.model;

public class stockDetails{
	
	private int availableStock;
	private String unitOfMeasure;

	
	public stockDetails() {
	}

	public stockDetails(int availableStock, String unitOfMeasure) {
		this.availableStock = availableStock;
		this.unitOfMeasure = unitOfMeasure;
	}



	public int getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(int availableStock) {
		this.availableStock = availableStock;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

}