package ec.edu.ups.servlets;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.jpa.JPADAOFactory;
import ec.edu.ups.modelo.Error;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class ServletDelete
 */
@WebServlet(urlPatterns = "/ServletDelete")
public class ServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private HttpServletRequest rsq;
    private HttpServletResponse rsp;
	
    public ServletDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.rsq = request;
		this.rsp = response;
		HttpSession sesion = request.getSession(false);
		String correo = String.valueOf(sesion.getAttribute("usuario"));
		String id = request.getParameter("imp_delete");

		if(!id.equals("")) {
			System.out.println("1");
			delete(correo, id);
		}else {
			System.out.println("2");
			request.setAttribute("error", new Error("No se ha podido eliminar el telefono.", "Debe seleccionar un numero despues de listar en la tabla."));
			request.getRequestDispatcher(request.getContextPath()+"/Servicios.jsp").forward(request, response);
		}
	}
	
	private void delete(String ...strings) throws IOException, ServletException {
		TelefonoDAO tlf = JPADAOFactory.getFactory().getTelefonoDAO();
		
		boolean rtn = tlf.delete(tlf.read(Integer.parseInt(strings[1])));
		if(!rtn) {
			rsq.setAttribute("error", new Error("No se ha podido eliminar el registro telefonico.", ""));
			rsq.getRequestDispatcher(rsq.getContextPath()+"/private/Servicios.jsp").forward(rsq, rsp);
		}else {
			rsq.setAttribute("error", null);
			rsp.sendRedirect(rsq.getContextPath()+"/private/Servicios.jsp");
		}
	}

}