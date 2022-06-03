package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Expense;

public class ExpenseDao {

	public void add(Expense expense) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/monthly_expense?user=root&password=rootroot");

			String sql = "insert into expense (email, expense_name, expense_amount, category_name) values(?,?,?,?)";

			PreparedStatement preparestatement = connect.prepareStatement(sql);

			preparestatement.setString(1, expense.getEmail());
			preparestatement.setString(2, expense.getExpense_name());
			preparestatement.setInt(3, expense.getExpense_amount());
			preparestatement.setString(4, expense.getCategory_name());

			preparestatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(int expense_id) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/monthly_expense?user=root&password=rootroot");

			PreparedStatement ps = connect.prepareStatement("delete from expense where expense_id=?");

			ps.setInt(1, expense_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void update(Expense expense) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/monthly_expense?user=root&password=rootroot");

			String sql = "update expense set expense_name = ?, expense_amount = ?, category_name = ? where expense_id = ?";

			PreparedStatement preparestatement = connect.prepareStatement(sql);

			preparestatement.setString(1, expense.getExpense_name());
			preparestatement.setInt(2, expense.getExpense_amount());
			preparestatement.setString(3, expense.getCategory_name());
			preparestatement.setInt(4, expense.getExpense_id());

			preparestatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Object> findExpenses(String email)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/monthly_expense?user=root&password=rootroot");

			PreparedStatement preparestatement = null;

			if (email.equals("")) {
				String sql = "select * from expense";
				preparestatement = connect.prepareStatement(sql);
			} else {
				String sql = "select * from expense where email = ?";
				preparestatement = connect.prepareStatement(sql);
				preparestatement.setString(1, email);
			}

			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				Expense expense = new Expense();
				expense.setExpense_id(resultSet.getInt("expense_id"));
				expense.setEmail(resultSet.getString("email"));
				expense.setExpense_name(resultSet.getString("expense_name"));
				expense.setExpense_amount(resultSet.getInt("expense_amount"));
				expense.setCategory_name(resultSet.getString("category_name"));
				expense.setCreation_date(resultSet.getDate("creation_date"));
				list.add(expense);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;

	}

	public List<Object> findCustomExpense(String date, String email)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/monthly_expense?user=root&password=rootroot");

			PreparedStatement preparestatement = null;

			if (email.equals("")) {
				String sql = "select * from expense where creation_date like ?";
				preparestatement = connect.prepareStatement(sql);
				preparestatement.setString(1, "%" + date + "%");
			} else {
				String sql = "select * from expense where email = ? and creation_date like ?";
				preparestatement = connect.prepareStatement(sql);
				preparestatement.setString(1, email);
				preparestatement.setString(2, "%" + date + "%");
			}

			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				Expense expense = new Expense();
				expense.setExpense_id(resultSet.getInt("expense_id"));
				expense.setEmail(resultSet.getString("email"));
				expense.setExpense_name(resultSet.getString("expense_name"));
				expense.setExpense_amount(resultSet.getInt("expense_amount"));
				expense.setCategory_name(resultSet.getString("category_name"));
				expense.setCreation_date(resultSet.getDate("creation_date"));
				list.add(expense);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;

	}

	public String[] getInsights(String email)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		String insights[] = { "0", "0", "0" };

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/monthly_expense?user=root&password=rootroot");

			String sql1 = "SELECT sum(expense_amount) as 'totalExpense' FROM expense where email = ?";
			PreparedStatement preparestatement1 = connect.prepareStatement(sql1);
			preparestatement1.setString(1, email);
			ResultSet resultSet1 = preparestatement1.executeQuery();

			while (resultSet1.next()) {
				insights[0] = resultSet1.getString("totalExpense");
			}

			String sql2 = "SELECT sum(saving_amount) as 'totalSaving' FROM saving where email = ?";
			PreparedStatement preparestatement2 = connect.prepareStatement(sql2);
			preparestatement2.setString(1, email);
			ResultSet resultSet2 = preparestatement2.executeQuery();

			while (resultSet2.next()) {
				insights[1] = resultSet2.getString("totalSaving");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return insights;

	}

}
