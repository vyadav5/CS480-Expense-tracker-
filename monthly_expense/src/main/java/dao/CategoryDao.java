package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Category;

public class CategoryDao {

	public void add(Category category) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/monthly_expense?user=root&password=rootroot");

			String sql = "insert into category (category_name) values(?)";

			PreparedStatement preparestatement = connect.prepareStatement(sql);

			preparestatement.setString(1, category.getCategory_name());

			preparestatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(int category_id) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/monthly_expense?user=root&password=rootroot");

			PreparedStatement ps = connect.prepareStatement("delete from category where category_id=?");

			ps.setInt(1, category_id);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void update(Category category)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/monthly_expense?user=root&password=rootroot");

			String sql = "update category set category_name = ? where category_id = ?";

			PreparedStatement preparestatement = connect.prepareStatement(sql);

			preparestatement.setString(1, category.getCategory_name());
			preparestatement.setInt(2, category.getCategory_id());

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
					.getConnection("jdbc:mysql://localhost:3306/monthly_expense?user=root&password=rootroot");

			String sql = "select * from category";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				Category category = new Category();
				category.setCategory_id(resultSet.getInt("category_id"));
				category.setCategory_name(resultSet.getString("category_name"));
				list.add(category);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;

	}

}
