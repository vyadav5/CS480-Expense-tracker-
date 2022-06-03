package domain;

import java.sql.Date;

public class Expense {

	private int expense_id;
	private String email;
	private String expense_name;
	private int expense_amount;
	private String category_name;
	private Date creation_date;

	public Expense() {

	}

	public int getExpense_id() {
		return expense_id;
	}

	public void setExpense_id(int expense_id) {
		this.expense_id = expense_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExpense_name() {
		return expense_name;
	}

	public void setExpense_name(String expense_name) {
		this.expense_name = expense_name;
	}

	public int getExpense_amount() {
		return expense_amount;
	}

	public void setExpense_amount(int expense_amount) {
		this.expense_amount = expense_amount;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	@Override
	public String toString() {
		return "Expense [expense_id=" + expense_id + ", email=" + email + ", expense_name=" + expense_name
				+ ", expense_amount=" + expense_amount + ", category_name=" + category_name + ", creation_date="
				+ creation_date + "]";
	}

}
