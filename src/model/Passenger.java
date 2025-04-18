package model;

public class Passenger {
    private int passId;
    private String name;
    private int age;
    private String dateBooked;
    private double amountPaid;
    private String boardingPoint;
    private String destinationPoint;
    private int busNo; //foreign key
    private int seatNo;
    private String gender;
    private String contactNumber;

    public Passenger() { }// Default Constructor

    public Passenger(int passId, String name, int age, String dateBooked, double amountPaid, String boardingPoint, String destinationPoint, int busNo, String gender, String contactNumber) {
        this.passId = passId;
        this.name = name;
        this.age = age;
        this.dateBooked = dateBooked;
        this.amountPaid = amountPaid;
        this.boardingPoint = boardingPoint;
        this.destinationPoint = destinationPoint;
        this.busNo = busNo;
//        this.seatNo = seatNo;
        this.gender = gender;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassId() {
        return passId;
    }

    public void setPassId(int passId) {
        this.passId = passId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(String dateBooked) {
        this.dateBooked = dateBooked;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getBoardingPoint() {
        return boardingPoint;
    }

    public void setBoardingPoint(String boardingPoint) {
        this.boardingPoint = boardingPoint;
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

}
