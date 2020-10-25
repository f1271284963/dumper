package lab5_project;

public class Car extends Vehicle{
	public String toString() {
		String str = "The car's speed is " + String.valueOf(this.speed) + 
			" km/h"; 
		
		return str;
	}
}
