package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JPasswordField;

import sandwich.Sandwich;

public class SandwichRepository {
	
	private PreparedStatement statement;
	private Connection connection;
	
	private String username;
	private String password;
	
	public SandwichRepository(Properties properties){
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://gegevensbanken.khleuven.be:51617/hackaton?currentSchema=project2_groep12";
			connection = DriverManager.getConnection(url, properties);
		} catch (SQLException e) {
			throw new DbException(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			throw new DbException(e.getMessage(), e);
		}
		
//		this.username ="r0626919";
//		JPasswordField pf = new JPasswordField();
//		this.password = "MCaRsi89vi";
////		if (passwd == JOptionPane.OK_OPTION) {
////			this.password = new String(pf.getPassword());
////		}
//		Properties properties = new Properties();
//		String url = "jdbc:postgresql://gegevensbanken.khleuven.be:51617/hackaton?currentSchema=project2_groep12";
//		properties.setProperty("user", username);
//		properties.setProperty("password", password);
//		properties.setProperty("ssl", "true");
//		properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
//		Class.forName("org.postgresql.Driver");
//		connection =DriverManager.getConnection(url,properties);
		
	}
	
	public void closeConnection(){
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new DbException(e.getMessage(), e);
		}
	}
	
	public Sandwich get(String broodje) {
		if (broodje == null) {
			throw new DbException("No personId given");
		}
		Sandwich sandwich;
		try {
			String sql = "SELECT * FROM broodjes WHERE naam ='kaas-hesp' ";
			statement = connection.prepareStatement(sql);
//			statement.setString(2, broodje);
			ResultSet result = statement.executeQuery();
			result.next();
			String name = result.getString("naam");
			int amount = result.getInt("aantal");
			sandwich = new Sandwich(amount, name);	
		} catch (SQLException e) {
			throw new DbException(e.getMessage(), e);
		}
		return sandwich;
	}
	
	public void update(Sandwich sandwich) {
		if (sandwich == null) {
			throw new DbException("nothing to update");
		}
		try {
			String sql = "UPDATE * FROM broodjes WHERE naam='kaas-hesp' ";
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
