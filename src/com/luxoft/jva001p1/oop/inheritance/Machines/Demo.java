package com.luxoft.jva001p1.oop.inheritance.Machines;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        Machine[] machines = new Machine[10];
        Android[] androids = new Android[5];
        Vehicle[] vehicles = new Vehicle[5];

        // Vehicles
        Car car = new Car();
        car.setNumber("1");
        machines[0] = car;
        Lorry lorry = new Lorry();
        lorry.setNumber("2");
        machines[1] = lorry;

        // Androids
        Warior warior = new Warior();
        warior.setName("Sergent");
        machines[2] = warior;
        HouseWife houseWife = new HouseWife();
        houseWife.setName("Tania");
        machines[3] = houseWife;

        // Computers
        Desktop desktop = new Desktop();
        desktop.setPassword("Password_desktop1");
        machines[4] = desktop;
        Laptop laptop = new Laptop();
        laptop.setPassword("Password_laptop1");
        machines[5] = laptop;

        printMachinePurpose(machines);
        printAndroidNames(androids);
        printVehicleNumbers(vehicles);
    }

    private static void printMachinePurpose(Machine[] machines)
    {
        for (Machine machine : machines) {
            if (machine != null)
            {
                System.out.println(machine.getObjectName());
                System.out.println(machine.getPurpose());

            }
        }
    }

    private static void printAndroidNames(Android[] androids)
    {
        for (Android android : androids) {
            if (android != null)
            {
                System.out.println(android.getObjectName());
                System.out.println(android.getPurpose());

            }
        }
    }

    private static void printVehicleNumbers(Vehicle[] vehicles)
    {
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null)
            {
                System.out.println(vehicle.getObjectName());
                System.out.println(vehicle.getPurpose());
                System.out.println(vehicle.getNumber());

            }
        }
    }
}
