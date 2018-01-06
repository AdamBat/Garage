package pl.coderslab.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.garage.dao.CarDao;

@WebServlet("/car/delete")
public class DeleteCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarDao carDao = new CarDao();
		carDao.deleteCar(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("del", "car");
		request.getRequestDispatcher("/views/confirmed.jsp").forward(request, response);

	}

}
