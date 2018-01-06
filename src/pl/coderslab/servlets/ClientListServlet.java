package pl.coderslab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.garage.dao.ClientDao;
import pl.coderslab.garage.model.Client;

@WebServlet("/clients")
public class ClientListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClientListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClientDao clientDao = new ClientDao();
		List<Client> clientList = (ArrayList<Client>) clientDao.getAllClients();
		request.setAttribute("clients", clientList);
		request.getRequestDispatcher("views/clients.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
