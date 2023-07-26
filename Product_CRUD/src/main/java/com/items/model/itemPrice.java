package com.items.model;

public class itemPrice{
	
	private int basePrice;
	private int sellingPrice;
	
	public itemPrice() {
	}

	public itemPrice(int basePrice, int sellingPrice) {
		this.setBasePrice(basePrice);
		this.setSellingPrice(sellingPrice);
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	
}