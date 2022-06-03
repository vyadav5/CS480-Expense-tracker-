package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import domain.User;
import service.CustomException;
import service.ExpenseService;
import service.UserService;

public class UserServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServletLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao userdao = new UserDao();
		User user = null;
		try {
			user = userdao.findByEmail(request.getParameter("email"));
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		UserService userservice = new UserService();
		if (user.getEmail() != null) {
			try {
				userservice.login(user);
				request.getSession().setAttribute("session_user", user);
				request.getSession().setAttribute("email", user.getEmail());
				getInsights(request, response, user.getEmail());
				request.getRequestDispatcher("/jsps/main.jsp").forward(request, response);

			} catch (CustomException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				request.setAttribute("msg", e.getMessage());
			}
		} else {
			request.setAttribute("msg", "You need to register first");
			request.getRequestDispatcher("/jsps/user/regist.jsp").forward(request, response);
		}

	}

	private void getInsights(HttpServletRequest request, HttpServletResponse response, String email)
			throws ServletException, IOException {
		ExpenseService expenseservice = new ExpenseService();
		String totalSaving = "";
		String totalExpense = "";

		try {
			totalExpense = expenseservice.getInsights(email)[0];
			totalSaving = expenseservice.getInsights(email)[1];

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		if (totalExpense == null) {
			totalExpense = "0";
		}
		if (totalSaving == null) {
			totalSaving = "0";
		}

		request.getSession().setAttribute("totalExpense", "Total Expense: $" + totalExpense);
		request.getSession().setAttribute("totalSaving", "Total Saving: $" + totalSaving);

	}

}
