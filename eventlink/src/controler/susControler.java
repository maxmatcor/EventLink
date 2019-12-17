package controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.susData;
import DAO.Sus;
import model.eventData;

/**
 * Servlet implementation class susControler
 */
public class susControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public susControler() {
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
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(10 * 60);
		Sus sus = Sus.getInstace();
		String idStrUser = (String) session.getAttribute("iduser");
		String action = request.getParameter("action");
		String idstr = request.getParameter("id");
		susData susdata = null;

		if ("delete".equals(action)) {
			if (idstr != null) {
				int iduser = Integer.parseInt(idStrUser);
				int ideven = Integer.parseInt(idstr);
				sus.DeleteSus(ideven, iduser);

				session.setAttribute("msg", "1");
			} else {
				session.setAttribute("msg", "0");
			}

			int iduser = Integer.parseInt(idStrUser);
			ArrayList<eventData> eventdatas = sus.findByUser(iduser);
			request.setAttribute("eventdatas", eventdatas);

			String nextJSP = "/userlist.jsp";
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);

		} else if ("select".equals(action)) {
			if (idstr != null) {

				int idevent = Integer.parseInt(idstr);
				int iduser = Integer.parseInt(idStrUser);
				String existSus = sus.ValidateSuscripcion(idevent, iduser);
				if (existSus.equals("false")) {
					int status = 1;
					susdata = new susData(iduser, idevent, status);
					sus.CreateSus(susdata);

					session.setAttribute("msg", "1");
				} else {
					session.setAttribute("msg", "0");
				}
			}
		}
		ArrayList<eventData> eventdatas = sus.FindAll();
		request.setAttribute("eventdatas", eventdatas);

		String nextJSP = "/useralta.jsp";
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession(true);
		Sus sus = Sus.getInstace();
		String idStrUser = (String) sesion.getAttribute("iduser");
		String action = request.getParameter("action");

		if ("FindByUser".equals(action)) {
			int iduser = Integer.parseInt(idStrUser);
			ArrayList<eventData> eventdatas = sus.findByUser(iduser);
			request.setAttribute("eventdatas", eventdatas);


			String nextJSP = "/userlist.jsp";
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
		}

	}

}
