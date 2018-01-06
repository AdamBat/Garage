package pl.coderslab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.garage.dao.EmployeeDao;
import pl.coderslab.garage.model.Employee;

@WebServlet("/orderForm")
public class OrderForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao empDao = new EmployeeDao();
	private List<Employee> empList = (ArrayList<Employee>) empDao.getAllEmployees();

	public OrderForm() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("employees", empList);
		request.getRequestDispatcher("views/add-order.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
