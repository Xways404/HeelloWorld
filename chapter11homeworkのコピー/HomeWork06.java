package com.hspedu.homework;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class HomeWork06 {
    public static void main(String[] args) {
        Person jack = new Person("jack", new Horse());
        jack.common();
        jack.passRiver();
        jack.passMountain();
        jack.common();
    }
}

interface Vehicles {
    public void work();
}
class Horse implements Vehicles {

    @Override
    public void work() {
        System.out.println("Normal take Horse...");
    }
}
class Boat implements Vehicles {

    @Override
    public void work() {
        System.out.println("When you see the river take Boat...");
    }
}
class Plane implements Vehicles {

    @Override
    public void work() {
        System.out.println("Airplane pass mountain");
    }
}

class VehiclesFactory {
    private static Horse horse = new Horse();
    private VehiclesFactory() {}
    public static Horse getHorse() {
        return horse;
    }
    public static Boat getBoat() {
        return new Boat();
    }
    public static Plane getPlane() {
        return new Plane();
    }
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }
    public void passRiver() {
        if (!(vehicles instanceof Boat)) {
            vehicles = VehiclesFactory.getBoat();
        }
        vehicles.work();
    }
    public void common() {
        if (!(vehicles instanceof Horse)) {
            vehicles = VehiclesFactory.getHorse();
        }
        vehicles.work();
    }
    public void passMountain() {
        if (!(vehicles instanceof Plane)) {
            vehicles = VehiclesFactory.getPlane();
        }
        vehicles.work();
    }

}