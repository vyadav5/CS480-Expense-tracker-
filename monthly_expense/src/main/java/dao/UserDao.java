package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.User;

public class UserDao {

	public User findByEmail(String email)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = new User();
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/monthly_expense?" + "user=root&password=rootroot");
			String sql = "select * from tb_user where email=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, email);
			ResultSet resultSet = preparestatement.executeQuery();
			// ResultSet resultSet = preparestatement.executeUpdate();
			while (resultSet.next()) {
				String user_name = resultSet.getString("email");
				if (user_name.equals(email)) {
					user.setUsername(resultSet.getString("username"));
					user.setPassword(resultSet.getString("password"));
					user.setEmail(resultSet.getString("email"));

				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
	}

	public void add(User user) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/monthly_expense?" + "user=root&password=rootroot");

			String sql = "insert into tb_user values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, user.getUsername());
			preparestatement.setString(2, user.getPassword());
			preparestatement.setString(3, user.getEmail());
			preparestatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/monthly_expense?" + "user=root&password=rootroot");

			String sql = "select * from tb_user";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				User user = new User();
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				list.add(user);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;

	}

}
