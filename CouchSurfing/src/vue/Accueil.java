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
		if (request.getSession().getAttribute("sessionUtilisateur") == null) {
			request.setAttribute("menu", Menu.getMenuAcceuil().getLiensMenu());
			this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		}else {
			response.sendRedirect( "recherche" );
		    return;	
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("sessionUtilisateur") == null) {
			request.setAttribute("menu", Menu.getMenuAcceuil().getLiensMenu());
		}
		HttpSession sessionUtilisateur = request.getSession();
		try{
			String logA = request.getParameter("login");
			String mdpA = request.getParameter("mdp");
			FormulaireConnexion form =new FormulaireConnexion(logA,mdpA);
			
			if (form.verificationCoupleMailMotDePasse()){
				Utilisateur user= Utilisateur.getUtilisateurParMail(logA);
				sessionUtilisateur.setAttribute("sessionUtilisateur", user);
				response.sendRedirect( "recherche" );

				System.out.println(sessionUtilisateur.getAttribute("sessionUtilisateur"));
			    return;				
		        
			} else {
				sessionUtilisateur.setAttribute("sessionUtilisateur", null);
				request.setAttribute("resultat","Echec authentification" );
				this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
