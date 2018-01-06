package pl.coderslab.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.garage.dao.EmployeeDao;
import pl.coderslab.garage.dao.OrdersDao;
import pl.coderslab.garage.model.Employee;
import pl.coderslab.garage.model.Orders;

@WebServlet("/addOrder")
public class AddOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddOrder() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeDao empDao = new EmployeeDao();
		Employee emp = empDao.getById(Integer.parseInt(request.getParameter("employeeId")));
		BigDecimal empWage = emp.getWage();
		double repairCost = Double.parseDouble(request.getParameter("repairCost"));
		double partsCost = Double.parseDouble(request.getParameter("partsCost"));
		double employeeHours = Double.parseDouble(request.getParameter("employeeHours"));
		Orders order = new Orders(LocalDate.parse(request.getParameter("startDate")),
				LocalDate.parse(request.getParameter("endDate")), emp.getId(), request.getParameter("descProblem"),
				request.getParameter("descRepair"), request.getParameter("status"), BigDecimal.valueOf(repairCost),
				BigDecimal.valueOf(partsCost), empWage, BigDecimal.valueOf(employeeHours));
		OrdersDao ordersDao = new OrdersDao();
		ordersDao.insertNewOrders(order);
		request.setAttribute("add", "order");
		request.getRequestDispatcher("views/confirmed.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeDao empDao = new EmployeeDao();
		Employee emp = empDao.getById(Integer.parseInt(request.getParameter("employeeId")));
		OrdersDao ordersDao = new OrdersDao();
		Orders order = ordersDao.getById(Integer.parseInt(request.getParameter("id")));
		BigDecimal empWage = emp.getWage();
		double repairCost = Double.parseDouble(request.getParameter("repairCost"));
		double partsCost = Double.parseDouble(request.getParameter("partsCost"));
		double employeeHours = Double.parseDouble(request.getParameter("employeeHours"));
		Orders updatedOrder = new Orders(order.getId(), LocalDate.parse(request.getParameter("startDate")),
				LocalDate.parse(request.getParameter("endDate")), emp.getId(), request.getParameter("descProblem"),
				request.getParameter("descRepair"), request.getParameter("status"), BigDecimal.valueOf(repairCost),
				BigDecimal.valueOf(partsCost), empWage, BigDecimal.valueOf(employeeHours));
		ordersDao.updateOrder(updatedOrder);
		request.setAttribute("upd", "order");
		request.getRequestDispatcher("views/confirmed.jsp").forward(request, response);
	}

}
