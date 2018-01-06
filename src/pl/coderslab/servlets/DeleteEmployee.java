package pl.coderslab.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.garage.dao.EmployeeDao;

@WebServlet("/employee/delete")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			EmployeeDao empDao = new EmployeeDao();
			empDao.deleteEmployee(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("del", "emp");
			request.getRequestDispatcher("/views/confirmed.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("error", "emp");
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);
		}
	}

}
