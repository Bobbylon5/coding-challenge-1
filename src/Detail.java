
public class Detail {
	
	private boolean isDirection; //Is a direction
	private boolean isCoordinate; //Is a coordinate
	
	//private Object it;
	private int it;
	//private string of direction
	private String dirString;

	


	public Detail(boolean one,  boolean three, int it) {
		super();
		this.isDirection = one;
		this.isCoordinate = three;
		this.it = it;
	}
	public Detail(boolean one,  boolean three, String dirOrSpec) {
		super();
		this.isDirection = one;
		this.isCoordinate = three;
		this.dirString = dirOrSpec;
	}


	public boolean confirmIfDirection() {
		return isDirection;
	}
	public boolean confirmIfCoordinate() {
		return isCoordinate;
	}
	public int getIt() {
		return it;
	}
	public String getDirString() {
		return dirString;
	}



	public void setOne(boolean one) {
		this.isDirection = one;
	}
	public void setThree(boolean three) {
		this.isCoordinate = three;
	}
	public void setIt(int it) {
		this.it = it;
	}
	public void setDirOrSpec(String dirOrSpec) {
		this.dirString = dirOrSpec;
	}
	
	
}
