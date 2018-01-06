package pl.coderslab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.garage.dao.OrdersDao;

@WebServlet("/orders/delete")
public class DeleteOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrdersDao ordersDao = new OrdersDao();
		ordersDao.deleteOrder(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("del", "order");
		request.getRequestDispatcher("/views/confirmed.jsp").forward(request, response);
	}

}
