package vue;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Data;
import modele.Image;
import modele.Logement;
import modele.Utilisateur;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
			request = afficherLogementUser(request, user);
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
		request = Menu.afficherMenu(request, response);
		Utilisateur user=(Utilisateur) request.getSession().getAttribute("sessionUtilisateur");
		request.setAttribute("utilisateurProfil", user);
		try{
			request = afficherLogementUser(request,user);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		Image imageUploaded= new Image(getFileFromRequest(request), request.getParameter("imgProfil"));
		try {
			imageUploaded.insererDansLaBase();
			Data.BDD_Connection.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(imageUploaded.getImage());
		this.getServletContext().getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);
	}

	private HttpServletRequest afficherLogementUser(HttpServletRequest request,
			Utilisateur user) throws Exception {
		Logement logementUtilisateur = Logement.getLogementById(user.getIdLogement());
		if(Logement.getLogementById(user.getIdLogement()) != null){
			request.setAttribute("adresseLogement",logementUtilisateur.getAdresse().toString());
		}
		else{ 
			request.setAttribute("adresseLogement","<p>Vous n'avez pas de logement enregistr�. <a href='nouvelle'>Cr�ez en un !</a></p>");
		}
		return request;
	}
	
	private File getFileFromRequest(HttpServletRequest request){
		File result=null;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try{
		List<FileItem> items = upload.parseRequest(request);
		if (items != null && items.size() > 0) {
             // iterates over form's fields
             for (FileItem item : items) {
                 // processes only fields that are not form fields
                 if (!item.isFormField()) {
                     String fileName = new File(item.getName()).getName();
                     result= new File(fileName);
                 }
             }
        }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
}
