package pl.coderslab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.garage.dao.EmployeeDao;
import pl.coderslab.garage.model.Employee;

@WebServlet("/employee/update")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateEmployee() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeDao empDao = new EmployeeDao();
		Employee employee = empDao.getById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("/views/update-employee.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
