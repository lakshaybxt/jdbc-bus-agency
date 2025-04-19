package service;

import db.DatabaseConnection;
import model.Passenger;

import java.awt.image.RescaleOp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerService {

    public boolean addPassenger(Passenger passenger) {
        String sql = "INSERT INTO passenger (name, age, dateBooked, amountPaid, boardingPoint, destinationPoint, busNo, gender, contactNumber)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, passenger.getName());
            preparedStatement.setInt(2, passenger.getAge());
            preparedStatement.setString(3, passenger.getDateBooked());
            preparedStatement.setDouble(4, passenger.getAmountPaid());
            preparedStatement.setString(5, passenger.getBoardingPoint());
            preparedStatement.setString(6, passenger.getDestinationPoint());
            preparedStatement.setInt(7, passenger.getBusNo());
            preparedStatement.setString(8, passenger.getGender());
            preparedStatement.setString(9, passenger.getContactNumber());


            int rows = preparedStatement.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Passenger> listAllPassenger() {
        List<Passenger> passengers = new ArrayList<>();
        String sql = "SELECT * FROM passenger";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while(resultSet.next()) {
                Passenger p = new Passenger(
                    resultSet.getInt("passId"),
                    resultSet.getString("name"),
                    resultSet.getInt("age"),
                    resultSet.getString("dateBooked"),
                    resultSet.getDouble("amountPaid"),
                    resultSet.getString("boardingPoint"),
                    resultSet.getString("destinationPoint"),
                    resultSet.getInt("busNo"),
                    resultSet.getString("gender"),
                    resultSet.getString("contactNumber")
                );
                passengers.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passengers;
    }

    public Passenger getPassengerById(int id) {
        List<Passenger> passengers = new ArrayList<>();
        String sql = "SELECT * FROM passenger WHERE passId = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return new Passenger(
                        resultSet.getInt("passId"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("dateBooked"),
                        resultSet.getDouble("amountPaid"),
                        resultSet.getString("boardingPoint"),
                        resultSet.getString("destinationPoint"),
                        resultSet.getInt("busNo"),
                        resultSet.getString("gender"),
                        resultSet.getString("contactNumber")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deletePassenger(int id) {
        String sql = "DELETE FROM passenger WHERE passId = ?";

        try(Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int rows = preparedStatement.executeUpdate();
            return  rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
