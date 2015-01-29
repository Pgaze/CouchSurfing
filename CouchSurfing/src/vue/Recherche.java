package vue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.FormulaireRechercheAnnonce;
import modele.Offre;
import classes.Menu;

/**
 * Servlet implementation class Recherche
 */
@WebServlet("/Recherche")
public class Recherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recherche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("sessionUtilisateur") != null) {
			request.setAttribute("menu", Menu.getMenuMembre(request).getLiensMenu());
			this.getServletContext().getRequestDispatcher("/WEB-INF/recherche.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("sessionUtilisateur") != null) {
			request.setAttribute("menu", Menu.getMenuMembre(request).getLiensMenu());
		}
		try{
		FormulaireRechercheAnnonce form= new FormulaireRechercheAnnonce(request.getParameter("ville"));
		List<Offre> lesOffres=form.getListeOffre();
		request.setAttribute("lesOffres", lesOffres);
		}
		catch (Exception e){
			request.setAttribute("erreur", e.getMessage());
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/recherche.jsp").forward(request, response);

	}
}
