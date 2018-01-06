package pl.coderslab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.garage.dao.OrdersDao;
import pl.coderslab.garage.model.Orders;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrdersDao orders = new OrdersDao();
		List<Orders> ordersList = (ArrayList<Orders>) orders.getAllOrders();
		request.setAttribute("orders", ordersList);
		request.getRequestDispatcher("views/index.jsp").forward(request, response);
	}

}
