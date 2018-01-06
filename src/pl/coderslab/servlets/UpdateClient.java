package pl.coderslab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.garage.dao.ClientDao;
import pl.coderslab.garage.model.Client;

@WebServlet("/client/update")
public class UpdateClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateClient() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClientDao clientDao = new ClientDao();
		Client client = clientDao.getById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("client", client);
		request.getRequestDispatcher("/views/update-client.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
