package pl.coderslab.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.garage.dao.CarDao;
import pl.coderslab.garage.dao.ClientDao;
import pl.coderslab.garage.model.Car;
import pl.coderslab.garage.model.Client;

@WebServlet("/addCar")
public class AddCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Car car = new Car(Integer.parseInt(request.getParameter("client_id")), request.getParameter("brand"),
				request.getParameter("model"), Integer.parseInt(request.getParameter("year")),
				Integer.parseInt(request.getParameter("regNr")), LocalDate.parse(request.getParameter("nextReview")));
		CarDao carDao = new CarDao();
		carDao.insertNewCar(car);
		request.setAttribute("add", "car");
		request.getRequestDispatcher("views/confirmed.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarDao carDao = new CarDao();
		Car car = carDao.getById(Integer.parseInt(request.getParameter("id")));
		Car updCar = new Car(car.getId(), Integer.parseInt(request.getParameter("client_id")),
				request.getParameter("brand"), request.getParameter("model"),
				Integer.parseInt(request.getParameter("year")), Integer.parseInt(request.getParameter("regNr")),
				LocalDate.parse(request.getParameter("nextReview")));

		carDao.UpdateCar(updCar);
		request.setAttribute("upd", "car");
		request.getRequestDispatcher("views/confirmed.jsp").forward(request, response);
	}

}
