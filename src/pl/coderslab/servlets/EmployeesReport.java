package pl.coderslab.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.garage.dao.EmployeeDao;
import pl.coderslab.garage.model.Employee;

@WebServlet("/reports1")
public class EmployeesReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeDao empDao = new EmployeeDao();
		Map<String, BigDecimal> map = empDao.loadEmployeesAndHours(Date.valueOf(request.getParameter("startDate")),
				Date.valueOf(request.getParameter("endDate")));
		request.setAttribute("map", map);
		request.getRequestDispatcher("views/employees-report.jsp").forward(request, response);
	}

}
