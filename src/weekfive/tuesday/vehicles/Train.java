/*
Written By : Robert Watkin
Date Created : 01/10/2019
*/
package weekfive.tuesday.vehicles;

public class Train extends Vehicle {
    public Train(short numberOfSeats, short numberOfWheels){
        this.numberOfSeats = numberOfSeats;
        this.numberOfWheels = numberOfWheels;
        this.vehicleName = "Train";
    }

    public void steer(String dir){
        System.out.println("I don't need to do anything " + dir + " to turn " + dir + " I just follow the tracks.");
    }
}
