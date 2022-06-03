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

import domain.Saving;
import service.CustomException;
import service.SavingService;

public class SavingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String email = null;

	public SavingServlet() {
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
			case "/Saving/add":
				addSaving(request, response);
				break;
			case "/Saving/update":
				updateSaving(request, response);
				break;
			case "/Saving/delete":
				deleteSaving(request, response);
				break;
			case "/Saving/findAll":
				findSavings(request, response, "");
				break;
			case "/Saving/findByID":
				findSavings(request, response, email);
				break;
			case "/Saving/custom":
				viewSaving(request, response, email);
				break;
			}
		}
	}

	private void addSaving(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SavingService savingService = new SavingService();
		Map<String, String[]> paramMap = request.getParameterMap();

		Saving saving = new Saving();

		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {

			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}

		saving.setEmail(email);
		saving.setSaving_name(info.get(1));
		saving.setSaving_amount(Integer.parseInt(info.get(2)));

		try {
			savingService.add(saving);

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

	private void deleteSaving(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SavingService savingService = new SavingService();
		Map<String, String[]> paramMap = request.getParameterMap();

		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {

			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}

		int saving_id = Integer.parseInt(info.get(0));

		savingService.delete(saving_id);

		request.setAttribute("msg", "Saving Deleted Successfully!");
		request.getRequestDispatcher("/jsps/body.jsp").forward(request, response);

	}

	private void updateSaving(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SavingService savingService = new SavingService();
		Map<String, String[]> paramMap = request.getParameterMap();

		Saving saving = new Saving();

		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {

			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}

		saving.setSaving_id(Integer.parseInt(info.get(1)));
		saving.setEmail(email);
		saving.setSaving_name(info.get(2));
		saving.setSaving_amount(Integer.parseInt(info.get(3)));

		try {
			savingService.update(saving);

			request.setAttribute("msg", "Saving Updated Successfully!");
			request.getRequestDispatcher("/jsps/body.jsp").forward(request, response);

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void findSavings(HttpServletRequest request, HttpServletResponse response, String email)
			throws ServletException, IOException {
		SavingService savingservice = new SavingService();
		try {
			request.setAttribute("SavingList", savingservice.findSavings(email));

			List<Object> li = savingservice.findSavings(email);
			for (int i = 0; i < li.size(); i++) {
				System.out.println(li.get(i).toString());
			}

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/Queryresult/list_savings.jsp").forward(request, response);
	}

	private void viewSaving(HttpServletRequest request, HttpServletResponse response, String email)
			throws ServletException, IOException {
		SavingService savingservice = new SavingService();

		Map<String, String[]> paramMap = request.getParameterMap();

		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {

			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}

		String date = info.get(1);

		try {
			request.setAttribute("SavingList", savingservice.findCustomSaving(date, email));

			List<Object> li = savingservice.findCustomSaving(date, email);
			for (int i = 0; i < li.size(); i++) {
				System.out.println(li.get(i).toString());
			}

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/Queryresult/custom_savings.jsp").forward(request, response);
	}

}
