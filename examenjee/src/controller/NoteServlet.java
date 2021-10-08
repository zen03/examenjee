package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EtudiantDaoImpl;
import dao.IEtudiant;
import dao.INote;
import dao.NoteDaoImpl;
import entities.Etudiant;
import entities.Note;


/**
 * Servlet implementation class NoteServlet
 */
@WebServlet("/Note")
public class NoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IEtudiant etudao;
	private INote notedao;
	   private EntityManager em;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	etudao=new EtudiantDaoImpl();
	notedao=new NoteDaoImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("page")!= null){
			String page = request.getParameter("page");
		if (page.equalsIgnoreCase("edit")) {
			request.getRequestDispatcher("/etudiant/liste.jsp").forward(request, response);	
	}
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("action")!= null){
			String action = request.getParameter("action");
		
	if(action.equalsIgnoreCase("Valider")){
		double valeur=Double.parseDouble(request.getParameter("Valeur"));
		int annee =Integer.parseInt(request.getParameter("Annee"));
		int semestre=Integer.parseInt(request.getParameter("Semestre"));
		String matiere = request.getParameter("Matiere");
		String type = request.getParameter("Type");
		int mat = Integer.parseInt(request.getParameter("matU"));
		Note note=new Note();
		note.setValeur(valeur);
		note.setAnnee(annee);
		note.setSemestre(semestre);
		note.setMatiere(matiere);
		note.setType(type);
		Etudiant et =etudao.getServeurById(mat);
		note.setEtudiant(et);
		int ok=notedao.add(note);
		request.setAttribute("message", ok);		
		request.getRequestDispatcher("etudiant/liste.jsp").forward(request, response);	
	}
	}

}
}
