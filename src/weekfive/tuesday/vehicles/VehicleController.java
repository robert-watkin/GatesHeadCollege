/*
Written By : Robert Watkin
Date Created : 01/10/2019
*/
package weekfive.tuesday.vehicles;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleController {
    Scanner sc = new Scanner(System.in);
    private Vehicle vehicle;
    private ArrayList<Vehicle> vehicles;

    public static void main(String[] args){
        VehicleController vc = new VehicleController();
        vc.menu();
    }

    private void menu() {
        System.out.println("What vehicle would you like to create? ");
        System.out.println("1 . Car");
        System.out.println("2 . Bus");
        System.out.println("3 . Truck");
        System.out.println("4 - Train");
        System.out.println("5 - Bicycle");
        System.out.println("6 - Motorbike");
        System.out.println("7 - View All Vehicles");

        int input = Integer.parseInt(sc.nextLine());
        switch (input){
            case 1:
                createCar();
                break;
            case 2:
                createBus();
                break;
            case 3:
                createTruck();
                break;
            case 4:
                createTrain();
                break;
            case 5:
                createBicycle();
                break;
            case 6:
                createMotorbike();
                break;
            case 7:
                viewAllVehicles();
                menu();
                return;
        }
        if (vehicles == null){
            vehicle.vehicleID = 1;
            vehicles = new ArrayList<>();
        } else {
            int newID = (vehicles.get(vehicles.size()-1).vehicleID) + 1;
            vehicle.vehicleID = newID;

        }
        vehicles.add(vehicle);
        System.out.println();
        controlVehicle();
    }

    private void viewAllVehicles() {
        if (vehicles.size() == 0){
            System.out.println("There are no vehicles");
            menu();
        } else {
            for (Vehicle v : vehicles){
                System.out.println("-----------------------");
                System.out.println("Vehicle ID -   " + v.vehicleID);
                System.out.println("Vehicle Type - " + v.vehicleName);
            }
        }
    }

    private void createMotorbike() {
        Motorbike motorbike = new Motorbike((short) 1, (short)2);
        vehicle = motorbike;
    }

    private void createBicycle() {
        Bicycle bicycle = new Bicycle((short) 1, (short) 2);
        vehicle = bicycle;
    }

    private void createTrain() {
        Train train = new Train((short) 16, (short) 128);
        vehicle = train;
    }

    private void createTruck() {
        Truck truck = new Truck((short) 8, (short) 24);
        vehicle = truck;
    }

    private void createBus() {
        Bus bus = new Bus((short) 8, (short) 24);
        vehicle = bus;
    }

    private void createCar() {
        Car car = new Car((short) 4,(short) 4);
        vehicle = car;
    }

    private void controlVehicle(){
        displayStats();
        System.out.println("What would you like your vehicle to do?");
        System.out.println("1 . Accelerate");
        System.out.println("2 . Turn");
        System.out.println("3 . Brake");
        System.out.println("4 . Change Gear");
        System.out.println("0 . Return to menu");

        Scanner sc = new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());
        System.out.println();

        switch (input){
            case 0:
                menu();
            case 1:
                vehicle.accelerate();
                controlVehicle();
                break;
            case 2:
                System.out.println("(1) right, or (2) vehicle");
                int leftRight = Integer.parseInt(sc.nextLine());
                if (leftRight == 1){
                    vehicle.steer("right");
                } else {
                    vehicle.steer("left");
                }
                controlVehicle();
                break;
            case 3:
                vehicle.brake();
                controlVehicle();
                break;
            case 4:
                System.out.println("(1) gear up, or (2) gear down");
                int upDown = Integer.parseInt(sc.nextLine());
                if (upDown == 1){
                    vehicle.gearUp();
                } else {
                    vehicle.gearDown();
                }
                controlVehicle();
                break;
        }
    }

    private void displayStats() {
        System.out.println("===============================");
        System.out.println("Current Speed " + vehicle.speed);
        if (vehicle.gear == 0){
            System.out.println("Current Gear Neutral");
        } else {
            System.out.println("Current Gear " + vehicle.gear);
        }
        System.out.println();
    }
}
