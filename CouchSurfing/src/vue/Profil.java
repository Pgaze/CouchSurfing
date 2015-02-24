package vue;

import java.io.IOException;
import java.sql.SQLException;

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
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request=Menu.afficherMenu(request, response);
		Utilisateur user=null;
		if(request.getParameter("id")==null){
			if(request.getSession().getAttribute("sessionUtilisateur")!=null){
				user = (Utilisateur) request.getSession().getAttribute("sessionUtilisateur");
			}
		}
		else{
			try{
				int idUrl = Integer.valueOf(request.getParameter("id"));
				user=Utilisateur.getUtilisateurById(idUrl);
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		request.setAttribute("utilisateurProfil", user);
		try {
			//Affichage de l'adresse du logmet si existant
			Logement logementUtilisateur = Logement.getLogementById(user.getIdLogement());
			if(Logement.getLogementById(user.getIdLogement()) != null){
				request.setAttribute("adresseLogement",logementUtilisateur.getAdresse().toString());
			}else request.setAttribute("adresseLogement","<p>Vous n'avez pas de logement enregistr�. <a href='nouvelle'>Cr�ez en un !</a></p>");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);
	}

}
