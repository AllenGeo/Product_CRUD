package items.model.inventory;

public class Stock {
	private int soldOut;
	private int damaged;
	public Stock() {
	}
	public Stock(int soldOut, int damaged) {
		this.soldOut = soldOut;
		this.damaged = damaged;
	}
	public int getSoldOut() {
		return soldOut;
	}
	public void setSoldOut(int soldOut) {
		this.soldOut = soldOut;
	}
	public int getDamaged() {
		return damaged;
	}
	public void setDamaged(int damaged) {
		this.damaged = damaged;
	}
	
}
