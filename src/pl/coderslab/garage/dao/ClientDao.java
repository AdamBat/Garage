package pl.coderslab.garage.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.garage.connection.ConnectionManager;
import pl.coderslab.garage.model.Client;

public class ClientDao {
	PreparedStatement statement;
	Connection connection;
	ResultSet rs;
	List<Client> list;

	public List<Client> getAllClients() {
		connection = ConnectionManager.getConnection();
		String sql = "Select * from clients";
		try {
			statement = connection.prepareStatement(sql);

			rs = statement.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				Client client = new Client(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getDate("dateOfBirth").toLocalDate());
				list.add(client);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List findClientByLastName(String lastName) {
		String sql = "Select * from clients where lastName like ?";
		connection = ConnectionManager.getConnection();
		try {
			statement = connection.prepareStatement(sql);
			lastName = "%" + lastName + "%";
			statement.setString(1, lastName);
			rs = statement.executeQuery();
			list = new ArrayList<Client>();
			while (rs.next()) {
				Client client = new Client(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getDate("dateOfBirth").toLocalDate());
				list.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public Client getById(int id) {
		String sql = "Select * from clients where id=?";
		connection = ConnectionManager.getConnection();
		Client client = new Client();
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			while (rs.next()) {
				client = new Client(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getDate("dateOfBirth").toLocalDate());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}

	public void insertNewClient(Client client) {
		String sql = "Insert into clients values(null,?,?,?)";
		connection = ConnectionManager.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, client.getFirstName());
			statement.setString(2, client.getLastName());
			statement.setDate(3, Date.valueOf(client.getDateOfBirth()));
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteClient(int id) throws SQLException {
		String sql = "Delete from clients where id=?";
		Connection connection = ConnectionManager.getConnection();
		statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		statement.executeUpdate();

	}

	public void updateClient(Client client) {
		String sql = "Update clients set firstName=?,lastName=?,dateOfBirth=? where id=?";
		connection = ConnectionManager.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, client.getFirstName());
			statement.setString(2, client.getLastName());
			statement.setDate(3, Date.valueOf(client.getDateOfBirth()));
			statement.setInt(4, client.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
