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

import domain.User;
import service.CustomException;
import service.UserService;


public class UserServletRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServletRegister() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Map<String, String> form = new HashMap<String,String>();
		UserService userservice = new UserService();
		Map<String, String[]> paramMap = request.getParameterMap();
		User form = new User();
		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {

			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}
		form.setUsername(info.get(1));
		form.setPassword(info.get(2));
		form.setEmail(info.get(3));

		try {
			userservice.regist(form);

			response.sendRedirect(request.getContextPath() + "/jsps/user/login.jsp");
		} catch (ClassNotFoundException | CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
