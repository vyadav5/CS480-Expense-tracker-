package web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Expense;
import service.ExpenseService;

public class ExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String email = null;

	public ExpenseServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean checkLogin = true;

		try {
			email = request.getSession().getAttribute("email").toString();
		} catch (NullPointerException e) {
			checkLogin = false;
			request.setAttribute("msg", "You need to login or register first");
			request.getRequestDispatcher("/jsps/body.jsp").forward(request, response);
		}

		if (checkLogin) {
			String action = request.getServletPath();
			switch (action) {
			case "/Expense/add":
				addExpense(request, response);
				break;
			case "/Expense/update":
				updateExpense(request, response);
				break;
			case "/Expense/delete":
				deleteExpense(request, response);
				break;
			case "/Expense/findAll":
				findExpenses(request, response, "");
				break;
			case "/Expense/findByID":
				findExpenses(request, response, email);
				break;
			case "/Expense/custom":
				viewExpense(request, response, email);
				break;
			}
		}
	}

	private void addExpense(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ExpenseService expenseService = new ExpenseService();
		Map<String, String[]> paramMap = request.getParameterMap();

		Expense expense = new Expense();

		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {

			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}

		expense.setEmail(email);
		expense.setExpense_name(info.get(1));
		expense.setExpense_amount(Integer.parseInt(info.get(2)));
		expense.setCategory_name(info.get(3));

		try {
			expenseService.add(expense);

			request.setAttribute("msg", "Expense Added Successfully!");
			request.getRequestDispatcher("/jsps/body.jsp").forward(request, response);

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void deleteExpense(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ExpenseService expenseService = new ExpenseService();
		try {
			Map<String, String[]> paramMap = request.getParameterMap();

			List<String> info = new ArrayList<String>();

			for (String name : paramMap.keySet()) {

				String[] values = paramMap.get(name);
				info.add(values[0]);
				System.out.println(name + ": " + Arrays.toString(values));
			}

			int expense_id = Integer.parseInt(info.get(0));

			expenseService.delete(expense_id);

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("msg", "Expense Deleted Successfully!");
		request.getRequestDispatcher("/jsps/body.jsp").forward(request, response);

	}

	private void updateExpense(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ExpenseService expenseService = new ExpenseService();
		Map<String, String[]> paramMap = request.getParameterMap();

		Expense expense = new Expense();

		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {

			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}

		expense.setExpense_id(Integer.parseInt(info.get(1)));
		expense.setEmail(email);
		expense.setExpense_name(info.get(2));
		expense.setExpense_amount(Integer.parseInt(info.get(3)));
		expense.setCategory_name(info.get(4));

		try {
			expenseService.update(expense);

			request.setAttribute("msg", "Expense Updated Successfully!");
			request.getRequestDispatcher("/jsps/body.jsp").forward(request, response);

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void findExpenses(HttpServletRequest request, HttpServletResponse response, String email)
			throws ServletException, IOException {
		ExpenseService expenseservice = new ExpenseService();
		try {
			request.setAttribute("ExpenseList", expenseservice.findExpenses(email));

			List<Object> li = expenseservice.findExpenses(email);
			for (int i = 0; i < li.size(); i++) {
				System.out.println(li.get(i).toString());
			}

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/Queryresult/list_expenses.jsp").forward(request, response);
	}

	private void viewExpense(HttpServletRequest request, HttpServletResponse response, String email)
			throws ServletException, IOException {

		ExpenseService expenseservice = new ExpenseService();

		Map<String, String[]> paramMap = request.getParameterMap();

		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {

			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}

		String date = info.get(1);

		try {
			request.setAttribute("ExpenseList", expenseservice.findCustomExpense(date, email));

			List<Object> li = expenseservice.findCustomExpense(date, email);
			for (int i = 0; i < li.size(); i++) {
				System.out.println(li.get(i).toString());
			}

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/Queryresult/custom_expenses.jsp").forward(request, response);
	}

}
