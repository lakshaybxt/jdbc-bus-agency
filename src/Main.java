import model.Bus;
import model.Passenger;
import service.BusService;
import service.PassengerService;
import util.InputHelper;

import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        BusService busService = new BusService();
        PassengerService passengerService = new PassengerService();

        while(true) {
            System.out.println("\n====== Bus Travel Agency System ======");
            System.out.println("1. Add Bus");
            System.out.println("2. List All Buses");
            System.out.println("3. List Available Buses");
            System.out.println("4. Get Bus by Number");
            System.out.println("5. Delete Bus");
            System.out.println("6. Book Passenger (Book Ticket)");
            System.out.println("7. List All Passengers");
            System.out.println("8. Get Passenger By ID");
            System.out.println("9. Delete Passenger");
            System.out.println("10. Exit");

            int choice = InputHelper.readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    int busNo = InputHelper.readInt("Enter Bus No: ");
                    String scheduledDate = InputHelper.readString("Enter Scheduled Date (YYYY-MM-DD): ");
                    String start = InputHelper.readString(" Enter Starting Point");
                    String destination = InputHelper.readString(" Enter Destination Point");
                    int capacity = InputHelper.readInt("Enter Capacity: ");
                    boolean isAvailable = InputHelper.readBoolean("Is Available");

                    Bus bus = new Bus(busNo, scheduledDate, start, destination, capacity, isAvailable);
                    boolean success = busService.addBus(bus);
                    System.out.println(success ? "Bus added successfully!" : "Failed to add bus.");
                    break;

                case 2:
                    List<Bus> allBuses = busService.listAllBuses();
                    for(Bus b : allBuses) {
                        printBusDetails(b);
                    }
                    break;

                case 3:
                    List<Bus> availableBuses = busService.listAvailableBuses();
                    for(Bus b : availableBuses) {
                        printBusDetails(b);
                    }
                    break;

                case 4:
                    int searchNo = InputHelper.readInt("Enter Bus No to search: ");
                    Bus foundBus = busService.getBusByNumber(searchNo);
                    if(foundBus != null) {
                        printBusDetails(foundBus);
                    } else {
                        System.out.println("Bus not found.");
                    }
                    break;

                case 5:
                    int delNo = InputHelper.readInt("Enter Bus No to delete: ");
                    boolean deleted = busService.deleteBus(delNo);
                    System.out.println(deleted ? "Bus deleted successfully." : "Failed to delete bus.");
                    break;

                case 6:
                    String name = InputHelper.readString("Enter Passenger Name: ");
                    int age = InputHelper.readInt("Enter Age: ");
                    String bookedDate = InputHelper.readString("Enter Booking Date (YYYY-MM-DD): ");
                    double amount = InputHelper.readDouble("Enter Fare Amount: ");
                    String boarding = InputHelper.readString("Enter Boarding Point: ");
                    String dest = InputHelper.readString("Enter Destination: ");
                    int assignedBusNo = InputHelper.readInt("Enter Bus No: ");
                    String gender = InputHelper.readString("Enter Gender: ");
                    String contactNo = InputHelper.readString("Enter Contact No: ");

                    Passenger passenger = new Passenger(0, name, age, bookedDate, amount, boarding, dest, assignedBusNo, gender, contactNo);
                    boolean booked = passengerService.addPassenger(passenger);
                    System.out.println(booked ? "Passenger booked successfully!" : "Failed to book passenger.");
                    break;

                case 7:
                    List<Passenger> passengers = passengerService.listAllPassenger();
                    for(Passenger p : passengers) {
                        printPassengerDetails(p);
                    }
                    break;

                case 8:
                    int pid = InputHelper.readInt("Enter Passenger Id: ");
                    Passenger found = passengerService.getPassengerById(pid);
                    if(found != null) {
                        printPassengerDetails(found);
                    } else {
                        System.out.println("Passenger not found.");
                    }
                    break;

                case 9:
                    int removeId = InputHelper.readInt("Enter Passenger Id to delete: ");
                    boolean removed = passengerService.deletePassenger(removeId);
                    System.out.println(removed ? "Passenger deleted." : "Failed to delete passenger.");
                    break;

                case 10:
                    System.out.println("Exiting the application. Goodbye!");
                    InputHelper.closeScanner();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void printBusDetails(Bus b) {
        System.out.println("\nBus No: " + b.getBusNo());
        System.out.println("Date: " + b.getScheduleDate());
        System.out.println("Capacity: " + b.getCapacity());
        System.out.println("Available: " + b.isAvailable());
        System.out.println("From: " + b.getStartingPoint());
        System.out.println("To: " + b.getDestination());
    }

    private static void printPassengerDetails(Passenger p) {
        System.out.println("\nPassenger ID: " + p.getPassId());
        System.out.println("Name: " + p.getName());
        System.out.println("Age: " + p.getAge());
        System.out.println("Booked Date: " + p.getDateBooked());
        System.out.println("Amount: " + p.getAmountPaid());
        System.out.println("Boarding: " + p.getBoardingPoint());
        System.out.println("Destination: " + p.getDestinationPoint());
        System.out.println("Bus No: " + p.getBusNo());
    }

}