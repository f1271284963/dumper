package lab5_project;

public class Motorcycle extends Vehicle{
	protected double size;
	
	public double getSize() {
		return this.size;
	}
	
	public void setSize(double size) {
		this.size = size;
	}
	
	public String toString() {
		String str = "The motorcycle has a big engine, it's " + String.valueOf(this.size) + 
			" L cubed"; 
			
		return str;
	}
}
