package vue;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String name = request.getParameter("name");
        request.setAttribute("var_name", name);
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		String logA = request.getParameter("login");
		String mdpA = request.getParameter("mdp");
		FormulaireConnexion form =new FormulaireConnexion(logA,mdpA);
		if (form.verificationCoupleMailMotDePasse()){
			Utilisateur user= Utilisateur.getUtilisateurParMail(logA);
			request.setAttribute("nom", user.getPseudo());
			this.getServletContext().getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);
		}
		else{
			request.setAttribute("resultat","Echec authentification" );
			this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
