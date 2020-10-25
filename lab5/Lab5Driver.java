package lab5_project;

public class Lab5Driver {
  
  public static void main(String[] argv) {
	  
	  // 1. Overriding toString()
	  System.out.println("--------------");
	  System.out.println("TOSTRING OVERRIDE");

	  Vehicle vehicle1 = new Vehicle();
	  // TODO: for vehicle1: set wheels to 4, speed to 100
	  //
	  //
	  vehicle1.setNumberOfWheels(4);
	  vehicle1.setSpeed(100.00);

	  Car car1 = new Car();
	  // TODO: for car1: set wheels to 4, speed to 80
	  //
	  //
	  car1.setNumberOfWheels(4);
	  car1.setSpeed(80);
	  
	  Motorcycle motorcycle1 = new Motorcycle();
	  // TODO: for motorcycle1: set wheels to 2, speed to 70, engine size to 10
	  //
	  //
	  motorcycle1.setNumberOfWheels(2);
	  motorcycle1.setSpeed(70);
	  motorcycle1.setSize(10.0);
	  
	  Moped moped1 = new Moped();
	  // TODO: for moped1: set number of wheels to 2, speed to 50, engine size to 5
	  //
	  //
	  moped1.setNumberOfWheels(2);
	  moped1.setSpeed(50);
	  moped1.setSize(5.0);
	  
	  // Note: The toString() of the subclass will override the toString() of the super class
	  System.out.println(vehicle1.toString());
	  System.out.println(car1.toString());
	  System.out.println(motorcycle1.toString());
	  System.out.println(moped1.toString());
	  
	  // 2. Java variables as a handle to an object
	  System.out.println("--------------");
	  System.out.println("REFERENCE VARIABLES");
	  
	  // When variable motorcycle2 gets assigned to moped2, both moped2 and motorcycle2 point to the 
	  // same Moped object that was created with (Moped moped2 = new Moped();)
	  Moped moped2 = new Moped();
	  Motorcycle motorcycle2 = moped2;
	  
	  // TODO: for moped2, set engine size to 5, wheels to 2, speed to 50
	  //
	  //
	  moped2.setNumberOfWheels(2);
	  moped2.setSize(5.0);
	  moped2.setSpeed(50.0);
	  
	  // TODO: for motorcycle2, set engine size to 10
	  //
	  //
	  motorcycle2.setSize(10);
	  
	  // Note: motorcycle2 runs the toString() of Moped and not Motorcycle (because toString in Motorcycle has been overriden by the subclass Moped)
	  // Note: when either moped2 or motorcycle2 gets modified, both variables will be updated
	  System.out.println(moped2.toString());
	  System.out.println(motorcycle2.toString());
		  
		  
	  // 3. Downcasting: changing variable type from a Superclass to a Subclass
	  System.out.println("--------------");
	  System.out.println("DOWNCASTING");
	  
	  // 3.1. Correctly downcasting 
	  	// We can downcast Vehicle vehicle2 to Motorcycle motorcycle3, 
	  	// because although vehicle2 is defined as Vehicle, it is specifically a Motorcycle object
	  
	  System.out.println("eg. 1");
	  // vehicle2 is a Motorcycle object as initialized as type Vehicle
	  Vehicle vehicle2 = new Motorcycle();

	  // TODO: for vehicle2: set wheels to 2, speed to 75 
	  //
	  //
	  vehicle2.setNumberOfWheels(2);
	  vehicle2.setSpeed(75.0);

	  // Note: vehicle2 runs the toString() of Motorcycle and not Vehicle (because toString in Vehicle has been overriden by the subclass Motorcycle)
	  // Note: the engine size of vehicle2 is by default set to 0 and it cannot be set yet (because vehicle2 is type Vehicle, not Motorcycle)
	  System.out.println(vehicle2.toString());
	  
	  // motorcycle3 is vehicle2 casted to type Motorcycle 
	  	// motorcycle3 and vehicle2 point to the same Motorcycle object created in Vehicle vehicle2 = new Motorcycle();
	  Motorcycle motorcycle3 = (Motorcycle) vehicle2;

	  // TODO: for motorcycle3 : set engine size to 10
	  //
	  //
	  motorcycle3.setSize(10.0);

	  System.out.println(vehicle2.toString());
	  System.out.println(motorcycle3.toString());
	  
	  // 3.2. Incorrectly downcasting
	  	// We cannot downcast Vehicle vehicle_test to Motorcycle motorcycle_test, 
	  	// because vehicle2 type Vehicle and initialized as a Vehicle object (and not a Motorcycle object)
	  	// TODO: uncomment code below and run to view compile errors
	  
//	  Vehicle vehicle_test = new Vehicle();
//	  Motorcycle motorcycle_test = (Motorcycle) vehicle_test;
//	  System.out.println(vehicle_test.toString());
//	  System.out.println(motorcycle_test.toString());
	  
	  // 4. Upcasting: Upcasting is when we cast an object from a subclass to a superclass
	  	// Upcasting is always implicit, and therefore you don't need to manually cast
	  System.out.println("--------------");
	  System.out.println("UPCASTING");
	  
	  // 4.1 Upcast from Car to Vehicle
	  System.out.println("eg. 1");
	  Car car2 = new Car();

	  // TODO: for car2: set wheels to 4, speed to 100
	  //
	  //
	  car2.setNumberOfWheels(4);
	  car2.setSpeed(100.0);

	  Vehicle vehicle3 = car2;
	  
	  // Note: vehicle3 runs the toString() of Car and not Vehicle (because toString in Vehicle has been overriden by the subclass Car)
	  // Note: both car2 and vehicle3 point to the same Car object created by Car car2 = new Car();
	  System.out.println(car2.toString());
	  System.out.println(vehicle3.toString());
	  
	  // 4.2 Upcast from Vehicle to Object
	  	// Object is the superclass of all classes, so you can always upcast to Object
	  System.out.println("eg. 2");
	  Car car3 = new Car();

	  // TODO: for car3: set wheels to 4, speed to 120
	  //
	  //
	  car3.setNumberOfWheels(4);
	  car3.setSpeed(120.0);

	  Object object1 = car3;
	  
	  // Note: object1 runs the toString() of Car and not Object (because toString in Object has been overriden by the subclass Car)
	  // Note: both car3 and object1 point to the same car object created by Car car3 = new Car();
	  System.out.println(car3.toString());
	  System.out.println(object1.toString());
	  
	  
  }
}
