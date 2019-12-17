package controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import DAO.Login;
import DAO.Regs;

import model.userData;

/**
 * Servlet implementation class loginControler
 */
public class loginControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginControler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("user");
		String password = request.getParameter("password");

		userData userdata = new userData(userName, password);

		Login login = new Login();

		try {

			String userValidate = login.LoginUser(userdata);
			if (userValidate.equals("null")) {
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(10 * 60);
				session.setAttribute("msg", "0");
				request.getRequestDispatcher("index.jsp").forward(
						request, response);
			} else {
				String[] parts = userValidate.split("-");
				String partRole = parts[0];
				String partIduser = parts[1];
				if (partRole.equals("Admin_Role")) {

					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(10 * 60);
					session.setAttribute("user", userName);
					session.setAttribute("iduser", partIduser);
					session.setAttribute("role", partRole);

					request.getRequestDispatcher("adminMenu.jsp").forward(
							request, response);
				} else if (partRole.equals("Editor_Role")) {

					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(10 * 60);
					session.setAttribute("user", userName);
					session.setAttribute("iduser", partIduser);
					session.setAttribute("role", partRole);

					request.getRequestDispatcher("/editMenu.jsp").forward(
							request, response);
				} else if (partRole.equals("User_Role")) {
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(10 * 60);
					session.setAttribute("user", userName);
					session.setAttribute("iduser", partIduser);
					session.setAttribute("role", partRole);

					request.getRequestDispatcher("/userMenu.jsp").forward(
							request, response);
				}
			}
		} catch (IOException e) {
			System.err.print(e);
		}
	}

}
