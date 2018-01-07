package pl.coderslab.garage.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.coderslab.garage.connection.ConnectionManager;
import pl.coderslab.garage.model.Employee;

public class EmployeeDao {
	PreparedStatement statement;
	Connection connection;
	ResultSet rs;
	List<Employee> list;
	Map<String, BigDecimal> map;

	public Map<String, BigDecimal> loadEmployeesAndHours(Date start, Date end) {
		System.out.println(start);
		connection = ConnectionManager.getConnection();
		String sql = "SELECT CONCAT(employee.firstName,' ',employee.LastName) as employee, sum(emp_hours)  FROM employee join orders on orders.employee_id=employee.id "
				+ "where orders.start_date >=" + start + " and orders.start_date<=" + end + " group by employee_id;";
		try {
			System.out.println(sql);
			Statement statement1 = connection.createStatement();
			rs = statement1.executeQuery(sql);
			map = new HashMap<>();
			while (rs.next()) {

				map.put(rs.getString(1), rs.getBigDecimal(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;

	}

	public List<Employee> getAllEmployees() {
		connection = ConnectionManager.getConnection();
		String sql = "Select * from employee";
		try {
			statement = connection.prepareStatement(sql);

			rs = statement.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				Employee emp = new Employee(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("address"), rs.getString("phone"), rs.getString("note"), rs.getBigDecimal("wage"));
				list.add(emp);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Employee getById(int id) {
		String sql = "Select * from employee where id=?";
		connection = ConnectionManager.getConnection();
		Employee emp = new Employee();
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			while (rs.next()) {
				emp = new Employee(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("address"), rs.getString("phone"), rs.getString("note"), rs.getBigDecimal("wage"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public void insertNewEmployee(Employee employee) {
		String sql = "Insert into employee values(null,?,?,?,?,?,?)";
		connection = ConnectionManager.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, employee.getFirstName());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getAddress());
			statement.setString(4, employee.getPhone());
			statement.setString(5, employee.getNote());
			statement.setBigDecimal(6, employee.getWage());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteEmployee(int id) throws SQLException {
		String sql = "Delete from employee where id=?";
		Connection connection = ConnectionManager.getConnection();
		statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		statement.executeUpdate();

	}

	public void updateEmployee(Employee employee) {
		String sql = "Update employee set firstName=?,lastName=?,address=?,phone=?,note=?,wage=? where id=?";
		connection = ConnectionManager.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, employee.getFirstName());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getAddress());
			statement.setString(4, employee.getPhone());
			statement.setString(5, employee.getNote());
			statement.setBigDecimal(6, employee.getWage());
			statement.setInt(7, employee.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
