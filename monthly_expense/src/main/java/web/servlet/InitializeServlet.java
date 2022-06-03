package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InitializeDao;

public class InitializeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InitializeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		InitializeDao initializeDao = new InitializeDao();

		initializeDao.initDB();

		request.setAttribute("msg", "Database Initialized Successfully!");
		request.getRequestDispatcher("/jsps/user/initialize.jsp").forward(request, response);

	}

}
