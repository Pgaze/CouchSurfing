
package vue;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Menu;

/**
 * Servlet implementation class Demandes
 */
@WebServlet("/Demandes")
public class Demandes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demandes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("sessionUtilisateur") != null) {
			request.setAttribute("menu", Menu.getMenuMembre(request));

			this.getServletContext().getRequestDispatcher("/WEB-INF/annonces.jsp").forward(request, response);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("sessionUtilisateur") != null) {
			request.setAttribute("menu", Menu.getMenuMembre(request));
			this.getServletContext().getRequestDispatcher("/WEB-INF/annonces.jsp").forward(request, response);
		}
	}

}
