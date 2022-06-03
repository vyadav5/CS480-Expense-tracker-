package web.servlet;

//1. List all the expenses of a particular user using user_id sorted by date.
//2. List all the savings of a particular user using user_id.
//5. Find the most expensive month of a user using user_id.
//6. Find the least saving month of a user using user_id.
//7. Find the expense of a particular category (travel, food etc).
//8. Find the total profit of a month for a user. Profit considered as difference between
//expenses and savings

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Category;
import service.CategoryService;
import service.CustomException;

public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String email = null;

	public CategoryServlet() {
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
			case "/Category/add":
				addCategory(request, response);
				break;
			case "/Category/update":
				updateCategory(request, response);
				break;
			case "/Category/delete":
				deleteCategory(request, response);
				break;
			case "/Category/list":
				findAllCategory(request, response);
				break;
			}
		}
	}

	private void addCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoryService categoryService = new CategoryService();
		Map<String, String[]> paramMap = request.getParameterMap();

		Category category = new Category();

		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {

			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}

		category.setCategory_name(info.get(1));

		try {
			categoryService.add(category);

			request.setAttribute("msg", "Added Successfully!");
			request.getRequestDispatcher("/jsps/body.jsp").forward(request, response);

		} catch (ClassNotFoundException | CustomException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

	private void deleteCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoryService categoryService = new CategoryService();
		Map<String, String[]> paramMap = request.getParameterMap();

		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {

			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}

		int category_id = Integer.parseInt(info.get(0));

		categoryService.delete(category_id);

		request.setAttribute("msg", "Category Deleted Successfully!");
		request.getRequestDispatcher("/jsps/body.jsp").forward(request, response);

	}

	private void updateCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoryService categoryService = new CategoryService();
		Map<String, String[]> paramMap = request.getParameterMap();

		Category category = new Category();

		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {

			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}

		category.setCategory_id(Integer.parseInt(info.get(1)));
		category.setCategory_name(info.get(2));

		try {
			categoryService.update(category);

			request.setAttribute("msg", "Category Updated Successfully!");
			request.getRequestDispatcher("/jsps/body.jsp").forward(request, response);

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void findAllCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryService categoryservice = new CategoryService();

		try {
			request.setAttribute("CategoryList", categoryservice.findall());
			List<Object> li = categoryservice.findall();
			for (int i = 0; i < li.size(); i++) {
				System.out.println(li.get(i).toString());
			}

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/Queryresult/list_categories.jsp").forward(request, response);
	}

}
