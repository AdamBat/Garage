package pl.coderslab.garage.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.garage.connection.ConnectionManager;
import pl.coderslab.garage.model.Orders;

public class OrdersDao {
	PreparedStatement statement;
	ResultSet rs;
	List<Orders> list;

	public List<Orders> getAllOrders() {
		String sql = "Select * from orders";
		try (Connection connection = ConnectionManager.getConnection()) {
			statement = connection.prepareStatement(sql);

			rs = statement.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				Orders order = new Orders(rs.getInt("id"), rs.getDate("start_date").toLocalDate(),
						rs.getDate("end_date").toLocalDate(), rs.getInt("employee_id"), rs.getString("desc_problem"),
						rs.getString("desc_repair"), rs.getString("status"), rs.getBigDecimal("repair_cost"),
						rs.getBigDecimal("parts_cost"), rs.getBigDecimal("emp_wage"), rs.getBigDecimal("emp_hours"));
				list.add(order);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Orders getById(int id) {
		String sql = "Select * from orders where id=?";
		Orders order = new Orders();
		try (Connection connection = ConnectionManager.getConnection()) {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			while (rs.next()) {
				order = new Orders(rs.getInt("id"), rs.getDate("start_date").toLocalDate(),
						rs.getDate("end_date").toLocalDate(), rs.getInt("employee_id"), rs.getString("desc_problem"),
						rs.getString("desc_repair"), rs.getString("status"), rs.getBigDecimal("repair_cost"),
						rs.getBigDecimal("parts_cost"), rs.getBigDecimal("emp_wage"), rs.getBigDecimal("emp_hours"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	public void insertNewOrders(Orders orders) {
		String sql = "Insert into orders values(null,?,?,?,?,?,?,?,?,?,?)";
		try (Connection connection = ConnectionManager.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDate(1, Date.valueOf(orders.getStartDate()));
			statement.setDate(2, Date.valueOf(orders.getEndDate()));
			statement.setInt(3, orders.getEmployeeId());
			statement.setString(4, orders.getDescProblem());
			statement.setString(5, orders.getDescRepair());
			statement.setString(6, orders.getStatus());
			statement.setBigDecimal(7, orders.getRepairCost());
			statement.setBigDecimal(8, orders.getPartsCost());
			statement.setBigDecimal(9, orders.getEmployeeWage());
			statement.setBigDecimal(10, orders.getEmployeeHours());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteOrder(int id) {
		String sql = "Delete from orders where id=?";
		try (Connection connection = ConnectionManager.getConnection()) {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateOrder(Orders orders) {
		String sql = "Update  orders set start_date=?,end_date=?,employee_id=?,desc_problem=?,desc_repair=?,status=?,repair_cost=?,"
				+ "parts_cost=?,emp_wage=?,emp_hours=? where id=?";
		try (Connection connection = ConnectionManager.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDate(1, Date.valueOf(orders.getStartDate()));
			statement.setDate(2, Date.valueOf(orders.getEndDate()));
			statement.setInt(3, orders.getEmployeeId());
			statement.setString(4, orders.getDescProblem());
			statement.setString(5, orders.getDescRepair());
			statement.setString(6, orders.getStatus());
			statement.setBigDecimal(7, orders.getRepairCost());
			statement.setBigDecimal(8, orders.getPartsCost());
			statement.setBigDecimal(9, orders.getEmployeeWage());
			statement.setBigDecimal(10, orders.getEmployeeHours());
			statement.setInt(11, orders.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
