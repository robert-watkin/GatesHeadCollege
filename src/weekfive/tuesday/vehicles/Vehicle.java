/*
Written By : Robert Watkin
Date Created : 01/10/2019
*/
package weekfive.tuesday.vehicles;

public class Vehicle {
    public int vehicleID;
    public short numberOfSeats;
    public short numberOfWheels;
    public String vehicleName;
    public int gear;
    public int speed;

    public void accelerate(){
        if (gear == 0){
                System.out.println("The car is in neutral, you cannot move");
        } else {
            int maxSpeed = gear * 15;
            if (speed < maxSpeed){
                System.out.println("I accelerate by turning my wheels!");
                speed += 5;
            } else{
                System.out.println("You cannot accelerate more than " + maxSpeed + " in gear " + gear);
            }
        }

    }

    public void brake(){
        if (speed > 0){
            System.out.println("I brake by applying pressure to brake disks on my wheels");
            speed -= 5;
        }else{
            System.out.println("The " + vehicleName + " is already still");
        }
    }

    public void gearUp(){
        if (gear < 6){
            gear++;
            System.out.println("You increase the gear by 1");
        } else {
            System.out.println("You are already at the highest gear");
        }
    }

    public void gearDown(){
        if (gear > 1){
            gear--;
            System.out.println("You decrease the gear by 1");
        } else if (gear == 1){
            if (speed > 0){
                System.out.println("You have stalled your car");
                speed = 0;
            } else {
                System.out.println("You put your car in neutral");
            }
            gear--;
        }else {
            System.out.println("You are already at the lowest gear");
        }
    }

    public void steer(String dir){}
}
