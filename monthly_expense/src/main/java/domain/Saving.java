package domain;

import java.sql.Date;

public class Saving {

	private int saving_id;
	private String email;
	private String saving_name;
	private int saving_amount;
	private Date creation_date;

	public Saving() {

	}

	public int getSaving_id() {
		return saving_id;
	}

	public void setSaving_id(int saving_id) {
		this.saving_id = saving_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSaving_name() {
		return saving_name;
	}

	public void setSaving_name(String saving_name) {
		this.saving_name = saving_name;
	}

	public int getSaving_amount() {
		return saving_amount;
	}

	public void setSaving_amount(int saving_amount) {
		this.saving_amount = saving_amount;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	@Override
	public String toString() {
		return "Saving [saving_id=" + saving_id + ", email=" + email + ", saving_name=" + saving_name
				+ ", saving_amount=" + saving_amount + ", creation_date=" + creation_date + "]";
	}

}
