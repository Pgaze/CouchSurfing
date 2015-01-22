package vue;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Menu;

/**
 * Servlet implementation class Messagerie
 */
@WebServlet("/Messagerie")
public class Messagerie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Messagerie() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("sessionUtilisateur") != null) {
				
			Menu membre = new Menu("membre");
			membre.addLien("Deconnexion", false);
			membre.addLien("Annonces", false);
			membre.addLien("Demandes", false);
			membre.addLien("Profil", false);
			membre.addLien("Messagerie", false);
			membre.addLien("Nouvelle annonce", false);
	        request.setAttribute("menu", membre.getLiensMenu());
			this.getServletContext().getRequestDispatcher("/WEB-INF/messagerie.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/messagerie.jsp").forward(request, response);
	}

}
