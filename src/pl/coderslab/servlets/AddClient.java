package pl.coderslab.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.garage.dao.ClientDao;
import pl.coderslab.garage.model.Client;

@WebServlet("/addClient")
public class AddClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddClient() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Client client = new Client(request.getParameter("firstName"), request.getParameter("lastName"),
				LocalDate.parse(request.getParameter("dateOfBirth")));
		ClientDao clientDao = new ClientDao();
		clientDao.insertNewClient(client);
		request.setAttribute("add", "client");
		request.getRequestDispatcher("views/confirmed.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClientDao clientDao = new ClientDao();
		Client client = clientDao.getById(Integer.parseInt(request.getParameter("id")));
		Client updClient = new Client(client.getId(), request.getParameter("firstName"),
				request.getParameter("lastName"), LocalDate.parse(request.getParameter("dateOfBirth")));

		clientDao.updateClient(updClient);
		request.setAttribute("upd", "client");
		request.getRequestDispatcher("views/confirmed.jsp").forward(request, response);
	}

}
