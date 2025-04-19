package model;

public class Bus {
    private int busNo;
    private String scheduleDate;
    private String startingPoint;
    private String destination;
    private int capacity;
    private boolean isAvailable;

    public Bus() { } // Default Constructor

    public Bus(int busNo, String scheduleDate, String startingPoint, String destination, int capacity, boolean isAvailable) {
        this.busNo = busNo;
        this.scheduleDate = scheduleDate;
        this.startingPoint = startingPoint;
        this.destination = destination;
        this.capacity = capacity;
        this.isAvailable = isAvailable;
    }

    //Getters and Setters
    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
