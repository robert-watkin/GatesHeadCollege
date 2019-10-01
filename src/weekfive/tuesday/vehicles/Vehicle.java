/*
Written By : Robert Watkin
Date Created : 01/10/2019
*/
package weekfive.tuesday.vehicles;

public class Vehicle {
    public short numberOfSeats;
    public short numberOfWheels;

    public void accelerate(){
        System.out.println("I accelerate by turning my wheels!");
    }

    public void brake(){
        System.out.println("I brake by applying pressure to brake disks on my wheels");
    }
}
