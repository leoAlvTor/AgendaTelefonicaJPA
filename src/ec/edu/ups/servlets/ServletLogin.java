package ec.edu.ups.servlets;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.jpa.JPADAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Me llaman!");
		Object[] retorno = login(request);
		if(retorno[0] != null){
			if((boolean) retorno[0]) {
				if(crearSesion(request, String.valueOf(retorno[1]))) {
					response.sendRedirect(request.getContextPath() + "/private/Servicios.jsp");
				}
			}
		}else{
			response.sendRedirect(request.getContextPath() + "/public/Index.html?param=true");
		}
	}
	
	private Object[] login(HttpServletRequest request) {
		System.out.println("Metodo login");
		Object[] objs = new Object[2];
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		UsuarioDAO usuarioDAO = JPADAOFactory.getFactory().getUsuarioDAO();

		if(usuarioDAO.verifyUser(usuario, password)) {
			objs[0] = true;
			objs[1] = usuario;
		}
		return objs;

	}
	
	private boolean crearSesion(HttpServletRequest request, String usuario) {
		HttpSession sesion;
		sesion = request.getSession(true);
		sesion.setAttribute("logeado", true);
		sesion.setAttribute("usuario", usuario);
		return true;
	}

}
