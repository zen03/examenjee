package controller;

import java.io.IOException;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EtudiantDaoImpl;
import dao.IEtudiant;
import entities.Etudiant;



/**
 * Servlet implementation class EtudiantServlet
 */
@WebService("/Etudiant")
public class EtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IEtudiant etudao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	etudao = new EtudiantDaoImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("page")!= null){
			String page = request.getParameter("page");
			if(page.equalsIgnoreCase("liste")){
				List<Etudiant> liste = etudao.liste();
				request.setAttribute("etudiants", liste);
				request.getRequestDispatcher("/etudiant/liste.jsp").forward(request, response);
			}else if (page.equalsIgnoreCase("add")) {
				request.getRequestDispatcher("/etudiant/add.jsp").forward(request, response);	
			}
			else if (page.equalsIgnoreCase("delete")) {
				int id = Integer.parseInt(request.getParameter("mat"));
				etudao.delete(id);
				List<Etudiant> liste = etudao.liste();
				request.setAttribute("etudiants", liste);
				request.getRequestDispatcher("/etudiant/liste.jsp").forward(request, response);
			}else if (page.equalsIgnoreCase("edit")) {
				int id = Integer.parseInt(request.getParameter("mat"));
				Etudiant et=etudao.getServeurById(id);
				request.setAttribute("etudiant", et);
				request.getRequestDispatcher("/etudiant/edit.jsp").forward(request, response);
			}
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("action")!= null){
			String action = request.getParameter("action");
			if(action.equalsIgnoreCase("Envoyer")){
				String nom=request.getParameter("nomU");
				String prenom=request.getParameter("prenomU");
				int tel = Integer.parseInt(request.getParameter("telU"));
				Etudiant et=new Etudiant();
                et.setNom(nom);
                et.setPrenom(prenom);
                et.setTel(tel);             
                int ok= etudao.add(et);
                request.setAttribute("message", ok);
                request.getRequestDispatcher("etudiant/add.jsp").forward(request, response);
			}if(action.equalsIgnoreCase("Modifier")){
				int id = Integer.parseInt(request.getParameter("matU"));
				String nom=request.getParameter("nomU");
				String prenom=request.getParameter("prenomU");
				int tel = Integer.parseInt(request.getParameter("telU"));
				Etudiant et= new Etudiant();
				et.setMat(id);
				et.setNom(nom);
				et.setPrenom(prenom);
				et.setTel(tel);
             
                etudao.update(et);
                List<Etudiant> liste= etudao.liste();
                request.setAttribute("etudiants", liste);
                request.getRequestDispatcher("/etudiant/liste.jsp").forward(request, response);
			}
		


	}
	}

}
