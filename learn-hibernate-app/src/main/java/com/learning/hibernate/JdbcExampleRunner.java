package com.learning.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.learning.hibernate.model.Car;

public class JdbcExampleRunner {

	static final String DB_URL = "jdbc:postgresql://localhost:5432/learndb";
	static final String DB_USER = "postgres";
	static final String DB_PASS = "admin";

	public static void main(String[] args) {
		Connection conn = getConnection();
		
		read(conn);
		//create(conn);
		//update(conn);
		//delete(conn);
	}

	static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	static void delete(Connection conn) {
		System.out.println("Deleting mondeo record...");
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM car WHERE model = ?");
			stmt.setString(1, "mondeo");
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		read(conn);
	}

	static void update(Connection conn) {
		System.out.println("Updating mustang price...");
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE car SET price = ? WHERE model = ?");
			stmt.setString(1, "£35,250.00");
			stmt.setString(2, "mustang");

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		read(conn);
	}

	static void create(Connection conn) {
		System.out.println("Creating car records...");
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO car (model,price) values (?, ?)");
			stmt.setString(1, "mustang");
			stmt.setString(2, "£40,000.00");
			stmt.addBatch();

			stmt.setString(1, "mondeo");
			stmt.setString(2, "£20,000.00");
			stmt.addBatch();

			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		read(conn);
	}

	static List<Car> read(Connection conn) {
		System.out.println("Reading car records...");

		String query = "SELECT model, price FROM car";

		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		List<Car> cars = new LinkedList<>();

		if (rs == null) {
			return cars;
		}

		// Extract data from result set
		try {
			while (rs.next()) {
				Car car = new Car();
				car.setModel(rs.getString("model"));
				car.setPrice(rs.getString("price"));
				cars.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (cars == null || cars.isEmpty()) {
			System.out.println("Empty results!!");
			return cars;
		}

		for (Car car : cars) {
			System.out.printf("%-30.30s  %-30.30s%n", car.getModel(), car.getPrice());

		}
		return cars;
	}
}
