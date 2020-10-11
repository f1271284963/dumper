package lab4;

public class Vehicle {
	
	// 1. define collaborators as private variables (Engine, Brake, Accelerate)
		// eg. private CollaboratingClass c;
	private Engine engine;
	private Brake brake;
	private Accelerate accel;
	
	public Vehicle(){
		// 2. initialize objects of collaborating classes in constructor
			// eg. c = new CollaboratingClass();
		engine = new Engine();
		brake = new Brake();
		accel = new Accelerate();
	}
	
	// 3. create method called "startVehicle"
		// 3.1 start engine using "Engine" class
		void startVehicle() {
			engine.startEngine();
			accel.accelerate();
		}
		// 3.2 accelerate from 0mph to 60mph using "Accelerate" class
	
	// 4. create method called "moveVehicle"

		// 4.1 maintain 60mph using "Accelerate" class
	
		void moveVehicle() {
			accel.maintainSpeed();
		}
	// 5. create method called "stopVehicle"
		
		void stopVehicle() {
			brake.activateBrake();
			accel.deaccelerate();
			engine.stopEngine();
		}
		// 5.1 activate brake using "Brake" class

		// 5.2 deaccelerate from 60mph to 0 mph using "Accelerate" class
		
		// 5.3 stop engine using "Engine" class
}
