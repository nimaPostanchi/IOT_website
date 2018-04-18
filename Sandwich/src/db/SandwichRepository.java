package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import sandwich.Sandwich;

public class SandwichRepository {
	
	private PreparedStatement statement;
	private Connection connection;
	
	public SandwichRepository(Properties properties){
		try {
			Class.forName("org.postgresql.Driver");
			String url = properties.getProperty("url");
			connection = DriverManager.getConnection(url, properties);
		} catch (SQLException e) {
			throw new DbException(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			throw new DbException(e.getMessage(), e);
		}
		
	}
	
	public void closeConnection(){
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new DbException(e.getMessage(), e);
		}
	}
	
	public int get(String broodje) {
		if (broodje == null) {
			throw new DbException("No personId given");
		}
		Sandwich sandwich;
		try {
			String sql = "SELECT * FROM TABLE name WHERE broodje =? ";
			statement = connection.prepareStatement(sql);
			statement.setString(1, broodje);
			ResultSet result = statement.executeQuery();
			result.next();
			String name = result.getString("broodje");
			int amount = result.getInt("amount");
			sandwich = new Sandwich(amount, name);	
		} catch (SQLException e) {
			throw new DbException(e.getMessage(), e);
		}
		return sandwich.getAmount();
	}
	
	public void update(Sandwich sandwich) {
		if (sandwich == null) {
			throw new DbException("nothing to update");
		}
		try {
			String sql = "UPDATE * FROM r0362433_test.personnima";
			statement = connection.prepareStatement(sql);
			statement.setString(1, sandwich.getName());
			sandwich.reduce();
			statement.setInt(2, sandwich.getAmount());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage(), e);
		}

	}
}
