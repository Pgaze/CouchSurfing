package vue;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.Data;
import modele.FormulaireProposerLogement;
import modele.Utilisateur;
import classes.Menu;

/**
 * Servlet implementation class Nouvelle
 */
@WebServlet("/Nouvelle")
public class Nouvelle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Nouvelle() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("sessionUtilisateur") != null) {
			request.setAttribute("menu", Menu.getMenuMembre(request).getLiensMenu());
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/nouvelle.jsp").forward(request, response);
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
		HttpSession utilisateurSession = request.getSession();
		Utilisateur user= (Utilisateur)utilisateurSession.getAttribute("sessionUtilisateur");
		FormulaireProposerLogement form=new FormulaireProposerLogement(
				request.getParameter("batimentEscalier"), request.getParameter("numeroEtVoie"), 
				request.getParameter("cp"), request.getParameter("residence"), 
				request.getParameter("complementAdresse"), request.getParameter("ville"), user);
		if(form.verificationCp()){
			String result = form.procedureAjoutLogement();
			if(result.contentEquals("Logement ajoute")){
				Data.BDD_Connection.commit();
			}
			request.setAttribute("resultat", result);
			this.getServletContext().getRequestDispatcher("/WEB-INF/nouvelle.jsp").forward(request, response);
			
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/nouvelle.jsp").forward(request, response);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
