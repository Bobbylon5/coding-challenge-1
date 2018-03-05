
public class Unit {
	
	private Detail detailX;
	private Detail detailY;
	private Detail detailD;
	private Boolean Lost;
	private String orders;



	public Unit() {

		Lost = false;
	}
	
	public Detail getX() {
		return detailX;
	}
	public void setX(Detail dX) {
		this.detailX = dX;
	}
	public void editX(int dX) {
		detailX.setIt(dX);
	}


	public Detail getY() {
		return detailY;
	}
	public void setY(Detail dY) {
		this.detailY = dY;
	}
	public void editY(int dY) {
		detailY.setIt(dY);
	}


	public Detail getDirect() {
		return detailD;
	}
	public void setDirect(Detail dD) {
		this.detailD = dD;
	}
	public void editDirect(String dD) {
		detailD.setDirOrSpec(dD);
	}

	

	public Boolean getLost() {
		return Lost;
	}
	public void setLost(Boolean lost) {
		Lost = lost;
	}
	public String getOrders() {
		return orders;
	}
	public void setOrders(String orders) {
		this.orders = orders;
	}
	
}
