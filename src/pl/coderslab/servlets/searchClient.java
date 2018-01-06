package pl.coderslab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.garage.dao.CarDao;
import pl.coderslab.garage.dao.ClientDao;
import pl.coderslab.garage.model.Car;
import pl.coderslab.garage.model.Client;

@WebServlet("/clientSearch")
public class searchClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClientDao clientDao = new ClientDao();
		List<Client> clientsList = (ArrayList<Client>) clientDao
				.findClientByLastName(request.getParameter("lastName").toLowerCase());
		request.setAttribute("clients", clientsList);
		request.getRequestDispatcher("views/search-results.jsp").forward(request, response);

	}

}
