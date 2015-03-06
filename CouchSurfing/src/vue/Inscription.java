package vue;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Menu;
import formulaire.FormulaireInscription;

/**
 * Servlet implementation class incription
 */
@WebServlet("/incription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Inscription() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request=Menu.afficherMenu(request, response);
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request=Menu.afficherMenu(request, response);
		try{
			String nom=request.getParameter("nom");
			String prenom=request.getParameter("prenom");
			String mail=request.getParameter("mail");
			String mdp=request.getParameter("mdp");
			String confirmMdp=request.getParameter("mdpC");
			String pseudo = request.getParameter("pseudo");
			FormulaireInscription form=new FormulaireInscription(nom,prenom,mail,mdp,confirmMdp,pseudo);
			String resultatInscription=form.procedureInscription();
			request.setAttribute("resultat", resultatInscription);
			this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}