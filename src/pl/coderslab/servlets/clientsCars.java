package pl.coderslab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.garage.dao.CarDao;
import pl.coderslab.garage.model.Car;

@WebServlet("/client/cars")
public class clientsCars extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarDao carDao = new CarDao();
		List<Car> carList = (ArrayList<Car>) carDao.getAllCarsByCLient(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("cars", carList);
		request.getRequestDispatcher("/views/client-cars.jsp").forward(request, response);
	}

}
