package firstsession.solidprinciples;


// objects of superclass should be replaceable with objects of subclass without breaking the code.
class Vehicle {
    public void startEngine() {
        System.out.println("Engine started.");
    }
}
class Car extends Vehicle {
}
class Motorcycle extends Vehicle {
}

public class LiskovSubstitution {
    public static void startRide(Vehicle vehicle) {
        vehicle.startEngine();
    }

    public static void main(String[] args) {
        Car car = new Car();
        Motorcycle motorcycle = new Motorcycle();
        startRide(car);
        startRide(motorcycle);

    }

}
