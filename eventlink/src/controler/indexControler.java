package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.userData;
import DAO.Regs;

/**
 * Servlet implementation class indexControler
 */
public class indexControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexControler() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sesion = request.getSession(true);
		String role = (String) sesion.getAttribute("role");
		if (role!=null){
		if (role.equals("Admin_Role")){

			request.getRequestDispatcher("adminMenu.jsp").forward(request,
					response);
		}else if (role.equals("Editor_Role")){

			request.getRequestDispatcher("editMenu.jsp").forward(request,
					response);

		}else if (role.equals("User_Role")){

			request.getRequestDispatcher("userMenu.jsp").forward(request,
					response);

		}
		} else{request.getRequestDispatcher("index.jsp").forward(request,
				response);
}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
