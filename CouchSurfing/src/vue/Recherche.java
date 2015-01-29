package vue;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.FormulaireRechercheAnnonce;
import classes.Menu;

/**
 * Servlet implementation class Recherche
 */
@WebServlet("/Recherche")
public class Recherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Menu membre;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recherche() {
        super();
        this.membre = new Menu("membre");
		membre.addLien("Deconnexion", false);
		membre.addLien("Annonces", false);
		membre.addLien("Demandes", false);
		membre.addLien("Profil", false);
		membre.addLien("Messagerie", false);
		membre.addLien("Nouvelle annonce", false);
		membre.addLien("Recherche", false);
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("sessionUtilisateur") != null) {
	        request.setAttribute("menu", membre.getLiensMenu());
			this.getServletContext().getRequestDispatcher("/WEB-INF/recherche.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("menu", membre.getLiensMenu());
		FormulaireRechercheAnnonce form= new FormulaireRechercheAnnonce(request.getParameter("ville"));
		this.getServletContext().getRequestDispatcher("/WEB-INF/recherche.jsp").forward(request, response);
	}

}
