/*
Written By : Robert Watkin
Date Created : 01/10/2019
*/
package weekfive.tuesday.vehicles;

public class SteeringWheel extends Vehicle {

    public void steer(String dir){
        System.out.println("I can turn " + dir + " by spinning the steering wheel to the " + dir + ", no leaning required!");
    }
}
