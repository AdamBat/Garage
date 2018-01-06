package pl.coderslab.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.garage.dao.ClientDao;

@WebServlet("/client/delete")
public class DeleteClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteClient() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ClientDao clientDao = new ClientDao();
			clientDao.deleteClient(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("del", "client");
			request.getRequestDispatcher("/views/confirmed.jsp").forward(request, response);

		} catch (SQLException e) {
			request.setAttribute("error", "client");
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
