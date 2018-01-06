package pl.coderslab.garage.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.garage.connection.ConnectionManager;
import pl.coderslab.garage.model.Car;

public class CarDao {
	PreparedStatement statement;
	Connection connection;
	ResultSet rs;
	List<Car> list;

	public List<Car> getAllCars() {
		connection = ConnectionManager.getConnection();
		String sql = "Select * from cars";
		try {
			statement = connection.prepareStatement(sql);

			rs = statement.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				Car car = new Car(rs.getInt("id"), rs.getInt("client_id"), rs.getString("brand"), rs.getString("model"),
						rs.getInt("year"), rs.getInt("reg_nr"), rs.getDate("next_review").toLocalDate());
				list.add(car);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Car> getAllCarsByCLient(int clientId) {
		connection = ConnectionManager.getConnection();
		String sql = "Select * from cars where client_id=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, clientId);
			rs = statement.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				Car car = new Car(rs.getInt("id"), rs.getInt("client_id"), rs.getString("brand"), rs.getString("model"),
						rs.getInt("year"), rs.getInt("reg_nr"), rs.getDate("next_review").toLocalDate());
				list.add(car);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Car getById(int id) {
		String sql = "Select * from cars where id=?";
		connection = ConnectionManager.getConnection();
		Car car = new Car();
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			while (rs.next()) {
				car = new Car(rs.getInt("id"), rs.getInt("client_id"), rs.getString("brand"), rs.getString("model"),
						rs.getInt("year"), rs.getInt("reg_nr"), rs.getDate("next_review").toLocalDate());
				return car;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return car;
	}

	public void insertNewCar(Car car) {
		String sql = "Insert into cars values(null,?,?,?,?,?,?)";
		connection = ConnectionManager.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, car.getClient_id());
			statement.setString(2, car.getBrand());
			statement.setString(3, car.getModel());
			statement.setInt(4, car.getYear());
			statement.setInt(5, car.getRegNr());
			statement.setDate(6, Date.valueOf(car.getNextReview()));
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteCar(int id) {
		String sql = "Delete from cars where id=?";
		try (Connection connection = ConnectionManager.getConnection()) {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void UpdateCar(Car car) {
		String sql = "update  cars set client_id=?,brand=?,model=?,year=?,reg_nr=?,next_review=? where id=?";
		connection = ConnectionManager.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, car.getClient_id());
			statement.setString(2, car.getBrand());
			statement.setString(3, car.getModel());
			statement.setInt(4, car.getYear());
			statement.setInt(5, car.getRegNr());
			statement.setDate(6, Date.valueOf(car.getNextReview()));
			statement.setInt(7, car.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
