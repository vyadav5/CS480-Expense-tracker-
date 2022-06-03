package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitializeDao {

	public void initDB() {
		Statement statement = null;
		String sql = null;
		try {

			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/monthly_expense?user=root&password=rootroot");

			statement = connect.createStatement();
			
			statement.executeUpdate("DROP TABLE IF EXISTS expense");
			statement.executeUpdate("DROP TABLE IF EXISTS saving");
			statement.executeUpdate("DROP TABLE IF EXISTS tb_user");
			statement.executeUpdate("DROP TABLE IF EXISTS category");
			
			 sql = "CREATE TABLE tb_user ("
					+ "  username VARCHAR(50) NOT NULL,"
					+ "  password VARCHAR(50) NOT NULL,"
					+ "  email VARCHAR(50) NOT NULL,"
					+ "  PRIMARY KEY (email));";
			statement.executeUpdate(sql);			
			
			 sql = "CREATE TABLE expense ("
					+ "  expense_id INT NOT NULL AUTO_INCREMENT,"
					+ "  email VARCHAR(50) NOT NULL,"
					+ "  expense_name VARCHAR(50) NOT NULL,"
					+ "  expense_amount INT NOT NULL,"
					+ "  creation_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,"
					+ "  category_name VARCHAR(50) NOT NULL,"
					+ "  PRIMARY KEY (expense_id),"
					+ "  CONSTRAINT fk_expense_email FOREIGN KEY (email) REFERENCES tb_user (email));";
			statement.executeUpdate(sql);
						
			 sql = "CREATE TABLE saving ("
					+ "  saving_id INT NOT NULL AUTO_INCREMENT,"
					+ "  email VARCHAR(50) NOT NULL,"
					+ "  saving_name VARCHAR(50) NOT NULL,"
					+ "  saving_amount INT NOT NULL,"
					+ "  creation_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,"
					+ "  PRIMARY KEY (saving_id),"
					+ "  CONSTRAINT fk_saving_email FOREIGN KEY (email) REFERENCES tb_user (email));";
			statement.executeUpdate(sql);
			
			 sql = "CREATE TABLE category ("
					+ "  category_id INT NOT NULL AUTO_INCREMENT,"
					+ "  category_name VARCHAR(50) NOT NULL,"
					+ "  PRIMARY KEY (category_id));";
			statement.executeUpdate(sql);
			
			statement.execute("INSERT INTO tb_user VALUES ('John', 'pass1234', 'john@xyz.com');");
			statement.execute("INSERT INTO tb_user VALUES ('Harry', 'harry1234', 'harry@xyz.com');");
			statement.execute("INSERT INTO tb_user VALUES ('Thomas', 'thomas1234', 'thomas@xyz.com');");
			
			statement.execute("INSERT INTO category (category_name) VALUES ('travel');");
			statement.execute("INSERT INTO category (category_name) VALUES ('food');");
			statement.execute("INSERT INTO category (category_name) VALUES ('education');");
			statement.execute("INSERT INTO category (category_name) VALUES ('grocery');");
			statement.execute("INSERT INTO category (category_name) VALUES ('rent');");
			
			statement.execute("INSERT INTO `expense` (`email`, `expense_name`, `expense_amount`, `category_name`, `creation_date`) VALUES ('john@xyz.com', 'Fare of home to university', '40', 'travel', '2021-01-15');");
			statement.execute("INSERT INTO `expense` (`email`, `expense_name`, `expense_amount`, `category_name`, `creation_date`) VALUES ('harry@xyz.com', 'Dinner at hotel', '50', 'food', '2021-02-15');");
			statement.execute("INSERT INTO `expense` (`email`, `expense_name`, `expense_amount`, `category_name`, `creation_date`) VALUES ('thomas@xyz.com', 'Purchase books', '100', 'education', '2021-07-25');");
			statement.execute("INSERT INTO `expense` (`email`, `expense_name`, `expense_amount`, `category_name`, `creation_date`) VALUES ('thomas@xyz.com', 'Apartment Rent', '1000', 'rent', '2021-10-22');");
			statement.execute("INSERT INTO `expense` (`email`, `expense_name`, `expense_amount`, `category_name`, `creation_date`) VALUES ('john@xyz.com', 'Dinner', '100', 'food', '2020-07-05');");
			
			statement.execute("INSERT INTO `saving` (`email`, `saving_name`, `saving_amount`, `creation_date`) VALUES ('john@xyz.com', 'Extra work', '100', '2021-01-25');");
			statement.execute("INSERT INTO `saving` (`email`, `saving_name`, `saving_amount`, `creation_date`) VALUES ('thomas@xyz.com', 'Internship payment', '500', '2021-01-05');");
			statement.execute("INSERT INTO `saving` (`email`, `saving_name`, `saving_amount`, `creation_date`) VALUES ('harry@xyz.com', 'Work bonus', '400', '2021-06-12');");
			statement.execute("INSERT INTO `saving` (`email`, `saving_name`, `saving_amount`, `creation_date`) VALUES ('harry@xyz.com', 'Internship', '1000', '2021-03-30');");
			statement.execute("INSERT INTO `saving` (`email`, `saving_name`, `saving_amount`, `creation_date`) VALUES ('thomas@xyz.com', 'Online work', '250', '2020-12-25');");
				
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
