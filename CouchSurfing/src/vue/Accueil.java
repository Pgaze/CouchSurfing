package vue;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Menu;
import modele.FormulaireConnexion;
import modele.Utilisateur;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Accueil() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Menu invite = new Menu("invite");
		invite.addLien("Connexion", true);
		invite.addLien("Presentation", true);
        request.setAttribute("invite", invite);
        request.setAttribute("menu", invite.getLiensMenu());
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String logA = request.getParameter("login");
			String mdpA = request.getParameter("mdp");
			FormulaireConnexion form =new FormulaireConnexion(logA,mdpA);
			if (form.verificationCoupleMailMotDePasse()){
				Utilisateur user= Utilisateur.getUtilisateurParMail(logA);
				request.setAttribute("nom", user.getName());
				request.setAttribute("prenom", user.getFirstName());
				request.setAttribute("pseudo", user.getPseudo());
				request.setAttribute("mail", user.getMail());
				
				HttpSession session_utilisateur = request.getSession();
				session_utilisateur.setAttribute("sessionUtilisateur", user);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);
			} else{
				request.setAttribute("resultat","Echec authentification" );
				this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
