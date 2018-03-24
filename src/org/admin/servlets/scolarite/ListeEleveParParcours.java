package org.admin.servlets.scolarite;

import org.admin.servlets.BaseServlet;
import org.admin.beans.scolarite.Inscription;
import org.admin.beans.scolarite.Student;
import org.admin.beans.scolarite.Cursus;
import org.admin.dao.DaoFactory;
import org.admin.dao.CursusDao;
import org.admin.dao.StudentDao;
import org.admin.dao.ParcoursDao;
import org.admin.dao.DaoException;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.ArrayList;

@WebServlet("/list_etudiant")
public class ListeEleveParParcours extends BaseServlet{
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;
	private ParcoursDao parcoursDao;
	private CursusDao cursusDao;

	public ListeEleveParParcours(){
		super();
	}

	public void init(){
		DaoFactory daoFactory = DaoFactory.getInstance();
		studentDao = daoFactory.getStudentDao();
		cursusDao = daoFactory.getCursusDao();
		parcoursDao = daoFactory.getParcoursDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		// request.setAttribute("base_url",base_url);
		// try{
		// 	HttpSession session=request.getSession();
		// 	if(session.getAttribute("utilisateur") == null){
		// 		this.getServletContext().getRequestDispatcher("/WEB-INF/utilisateur/login.jsp").forward(request, response);
		// 	}
		// 	else{
		// 		int id_etudiant = Integer.parseInt(request.getParameter("id"));
		// 		String content="../preinscription/list_etudiant.jsp";
		// 		request.setAttribute ("content",content);
		// 		request.setAttribute ("title", "Cursus");
		// 		System.out.println(id_etudiant);
		// 		List<Inscription> cursus = cursusDao.getCursus(id_etudiant);
		// 		Student student = studentDao.getStudentById(id_etudiant);
		// 		String parcours[] = null;
		// 		for(int i=0; i < cursus.size(); i++){
		// 			parcours[i] = parcoursDao.getNomParcoursById(cursus.get(i));
		// 		}
		// 		request.setAttribute("cursus", cursus);
		// 		request.setAttribute("nom_parcours", parcours);
		// 		request.setAttribute("studentById", student);
		// 	}
		// }catch(DaoException e){
		// 	request.setAttribute("erreur", e.getMessage());
		// }
		// this.getServletContext().getRequestDispatcher("/WEB-INF/layout/admin.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("ceci est une servlet");
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("base_url",base_url);
		String content="../preinscription/list_etudiant.jsp";
		request.setAttribute ("content",content);
		request.setAttribute ("title", "Liste par parcours");
		try{
			HttpSession session = request.getSession();
			System.out.println("bloc try");
			String parcours = request.getParameter("parcours");
			System.out.println(parcours);
			System.out.println("Après parseInt");
			if(session.getAttribute("utilisateur") == null){
				this.getServletContext().getRequestDispatcher("/WEB-INF/utilisateur/login.jsp").forward(request, response);
			}
			else{
				System.out.println("ato anaty ELSE");
				List<Student> students = studentDao.getAllStudentByParcours(parcours);
				List<Cursus> cursus =  cursusDao.getCursus();
				request.setAttribute("etudiants", students);
				//request.setAttribute("cursus", cursus);
			}
		} catch(DaoException e){
			request.setAttribute("erreur", e.getMessage());
		}
		System.out.println("OK");
		this.getServletContext().getRequestDispatcher("/WEB-INF/layout/admin.jsp").forward(request, response);
	}
}
