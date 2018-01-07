package pl.coderslab.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.garage.dao.OrdersDao;

@WebServlet("/reports2")
public class FinancialReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrdersDao ordersDao = new OrdersDao();
		BigDecimal report = ordersDao.getFinancialReport(Date.valueOf(request.getParameter("startDate")),
				Date.valueOf(request.getParameter("endDate")));
		request.setAttribute("result", report);
		request.getRequestDispatcher("views/financial-report.jsp").forward(request, response);
	}

}
