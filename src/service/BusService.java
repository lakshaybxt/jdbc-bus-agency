package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DatabaseConnection;
import model.Bus;

public class BusService {
    public boolean addBus(Bus bus) {
        String sql = "INSERT INTO Bus (busNo, scheduleDate, capacity, isAvailable, startingPoint, destinationPoint) VALUES (?, ?, ?, ?, ?, ?)";
        //no need for manual closing later
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, bus.getBusNo());
            preparedStatement.setString(2, bus.getScheduleDate());
            preparedStatement.setInt(3, bus.getCapacity());
            preparedStatement.setBoolean(4, bus.isAvailabe());
            preparedStatement.setString(5, bus.getStartingPoint());
            preparedStatement.setString(6, bus.getDestination());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Bus> listAllBuses() {
        List<Bus> buslist = new ArrayList<>();
        String sql = "SELECT * FROM BUS";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Bus bus = new Bus(
                        resultSet.getInt("busNo"),
                        resultSet.getString("scheduleDate"),
                        resultSet.getString("startingPoint"),
                        resultSet.getString("destinationPoint"),
                        resultSet.getInt("capacity"),
                        resultSet.getBoolean("isAvailable")
                );
                buslist.add(bus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buslist;
    }

    public List<Bus> listAvailableBuses() {
        List<Bus> availabeBuses = new ArrayList<>();
        String sql = "SELECT * FROM BUS WHERE isAvailable = true";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Bus bus = new Bus(
                        resultSet.getInt("busNo"),
                        resultSet.getString("scheduleDate"),
                        resultSet.getString("startingPoint"),
                        resultSet.getString("destinationPoint"),
                        resultSet.getInt("capacity"),
                        resultSet.getBoolean("isAvailable")
                );
                availabeBuses.add(bus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return availabeBuses;
    }

    public Bus getBusByNumber(int busNo) {
        String sql = "SELECT * FROM Bus WHERE busNo = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, busNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Bus(
                        resultSet.getInt("busNo"),
                        resultSet.getString("scheduleDate"),
                        resultSet.getString("startingPoint"),
                        resultSet.getString("destinationPoint"),
                        resultSet.getInt("capacity"),
                        resultSet.getBoolean("isAvailable")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateBusCapacity(int busNo, int newCapacity) {
        String sql = "UPDATE Bus SET capacity = ? WHERE busNo = ?";
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, newCapacity);
            preparedStatement.setInt(2, busNo);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBusAvailabiltiy(int busNo, boolean isAvailable) {
        String sql = "UPDATE Bus SET isAvailable = ? WHERE busNo = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setBoolean(1, isAvailable);
            preparedStatement.setInt(2, busNo);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteBus(int busNo) {
        String sql = "DELETE FROM Bus WHERE busNo = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, busNo);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isBusExist(int busNo) {
        String sql = "SELECT COUNT(*) FROM Bus WHERE busNo = ?";
        boolean exists = false;

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, busNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                exists = resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return exists;
    }
}
