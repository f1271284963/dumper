package lab5_project;

public class Vehicle {
	protected double speed;
	protected int wheels;
	
	public double getSpeed() {
		return this.speed;
	}
	
	public int getNumberOfWheels() {
		return this.wheels;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void setNumberOfWheels(int wheels) {
		this.wheels = wheels;
	}
	
	public String toString() {
		String str = "Vehicle with " + String.valueOf(this.wheels) 
			+ " wheels, " + "travelling at speed " + String.valueOf(this.speed)
			+ " km/h";
	
		return str;
	}
}
