package service;

import java.util.List;

import dao.ExpenseDao;
import domain.Expense;

public class ExpenseService {
	private ExpenseDao expenseDao = new ExpenseDao();

	public void add(Expense expense) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		expenseDao.add(expense);
	}

	public void delete(int expense_id) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		expenseDao.delete(expense_id);
	}

	public void update(Expense expense) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		expenseDao.update(expense);
	}

	public List<Object> findExpenses(String email) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return expenseDao.findExpenses(email);
	}

	public List<Object> findCustomExpense(String date, String email)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return expenseDao.findCustomExpense(date, email);
	}

	public String[] getInsights(String email) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return expenseDao.getInsights(email);
	}

}
