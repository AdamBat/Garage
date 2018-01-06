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
import pl.coderslab.garage.dao.ClientDao;
import pl.coderslab.garage.model.Car;
import pl.coderslab.garage.model.Client;

@WebServlet("/car/update")
public class UpdateCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClientDao clientDao = new ClientDao();
	List<Client> clientList = (ArrayList<Client>) clientDao.getAllClients();

	public UpdateCar() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarDao carDao = new CarDao();
		Car car = carDao.getById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("clients", clientList);
		request.setAttribute("car", car);
		request.getRequestDispatcher("/views/update-car.jsp").forward(request, response);

	}

}
