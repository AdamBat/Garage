package pl.coderslab.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.garage.dao.EmployeeDao;
import pl.coderslab.garage.model.Employee;

@WebServlet("/addEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddEmployee() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		double wage = Double.parseDouble(request.getParameter("wage"));
		Employee employee = new Employee(request.getParameter("firstName"), request.getParameter("lastName"),
				request.getParameter("address"), request.getParameter("phone"), request.getParameter("note"),
				BigDecimal.valueOf(wage));
		EmployeeDao empDao = new EmployeeDao();
		empDao.insertNewEmployee(employee);
		request.setAttribute("add", "emp");
		request.getRequestDispatcher("views/confirmed.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeDao empDao = new EmployeeDao();
		Employee emp = empDao.getById(Integer.parseInt(request.getParameter("id")));
		double wage = Double.parseDouble(request.getParameter("wage"));
		Employee updatedEmp = new Employee(emp.getId(), request.getParameter("firstName"),
				request.getParameter("lastName"), request.getParameter("address"), request.getParameter("phone"),
				request.getParameter("note"), BigDecimal.valueOf(wage));

		empDao.updateEmployee(updatedEmp);
		request.setAttribute("upd", "emp");
		request.getRequestDispatcher("/views/confirmed.jsp").forward(request, response);
	}

}
