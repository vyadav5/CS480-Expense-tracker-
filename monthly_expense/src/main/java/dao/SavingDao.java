package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Saving;

public class SavingDao {

	public void add(Saving saving) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/monthly_expense?user=root&password=rootroot");

			String sql = "insert into saving (email, saving_name, saving_amount) values(?,?,?)";

			PreparedStatement preparestatement = connect.prepareStatement(sql);

			preparestatement.setString(1, saving.getEmail());
			preparestatement.setString(2, saving.getSaving_name());
			preparestatement.setInt(3, saving.getSaving_amount());

			preparestatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(int saving_id) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/monthly_expense?user=root&password=rootroot");

			PreparedStatement ps = connect.prepareStatement("delete from saving where saving_id=?");

			ps.setInt(1, saving_id);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void update(Saving saving) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/monthly_expense?user=root&password=rootroot");

			String sql = "update saving set saving_name = ?, saving_amount = ? where saving_id = ?";

			PreparedStatement preparestatement = connect.prepareStatement(sql);

			preparestatement.setString(1, saving.getSaving_name());
			preparestatement.setInt(2, saving.getSaving_amount());
			preparestatement.setInt(3, saving.getSaving_id());

			preparestatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Object> findSavings(String email)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/monthly_expense?user=root&password=rootroot");

			PreparedStatement preparestatement = null;

			if (email.equals("")) {
				String sql = "select * from saving";
				preparestatement = connect.prepareStatement(sql);
			} else {
				String sql = "select * from saving where email = ?";
				preparestatement = connect.prepareStatement(sql);
				preparestatement.setString(1, email);
			}

			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				Saving saving = new Saving();
				saving.setSaving_id(resultSet.getInt("saving_id"));
				saving.setEmail(resultSet.getString("email"));
				saving.setSaving_name(resultSet.getString("saving_name"));
				saving.setSaving_amount(resultSet.getInt("saving_amount"));
				saving.setCreation_date(resultSet.getDate("creation_date"));
				list.add(saving);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;

	}

	public List<Object> findCustomSaving(String date, String email)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/monthly_expense?user=root&password=rootroot");

			PreparedStatement preparestatement = null;

			if (email.equals("")) {
				String sql = "select * from saving where creation_date like ?";
				preparestatement = connect.prepareStatement(sql);
				preparestatement.setString(1, "%" + date + "%");
			} else {
				String sql = "select * from saving where email = ? and creation_date like ?";
				preparestatement = connect.prepareStatement(sql);
				preparestatement.setString(1, email);
				preparestatement.setString(2, "%" + date + "%");
			}
			
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				Saving saving = new Saving();
				saving.setSaving_id(resultSet.getInt("saving_id"));
				saving.setEmail(resultSet.getString("email"));
				saving.setSaving_name(resultSet.getString("saving_name"));
				saving.setSaving_amount(resultSet.getInt("saving_amount"));
				saving.setCreation_date(resultSet.getDate("creation_date"));
				list.add(saving);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;

	}

}
