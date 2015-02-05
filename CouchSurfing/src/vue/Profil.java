package vue;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Logement;
import modele.Utilisateur;
import classes.Menu;

/**
 * Servlet implementation class Profil
 */
@WebServlet("/Profil")
public class Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profil() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession().getAttribute("sessionUtilisateur") != null) {
			request.setAttribute("menu", Menu.getMenuMembre(request).getLiensMenu());
			
			Utilisateur user = (Utilisateur) request.getSession().getAttribute("sessionUtilisateur");
			
			try {
				Logement logementUtilisateur = Logement.getLogementById(user.getIdLogement());
				if(Logement.getLogementById(user.getIdLogement()) != null){
					request.setAttribute("addresseLogement",logementUtilisateur.getAdresse().toString());
				}request.setAttribute("adresseLogement","<p>Vous n'avez pas de logement enregistré. <a href='nouvelle'>Créez en un !</a></p>");
			} catch (Exception e) {
				e.printStackTrace();
			}

			this.getServletContext().getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);
	}

}
