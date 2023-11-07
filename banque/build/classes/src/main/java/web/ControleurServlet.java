package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CreditMetierImpl;
import metier.ICreditMetier;
@WebServlet(name="cs", urlPatterns= {"/controleur", "*.do"})
public class ControleurServlet extends HttpServlet {
	private ICreditMetier metier;
	
	@Override
	public void init() throws ServletException {
		metier = new CreditMetierImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("creditModel", new CreditModel());
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * Lire les données
		 * */
		double montant = Double.parseDouble(request.getParameter("montant"));
		double taux = Double.parseDouble(request.getParameter("taux"));
		int duree = Integer.parseInt(request.getParameter("duree"));
		CreditModel  model = new CreditModel();
		/*
		 * Valider les données
		 */
		 
		 /*
		  * Stocker les données saisies dans le modèle 
		  */
		
		model.setMontant(montant);
		model.setTaux(taux);
		model.setDuree(duree);
		
		 /*
		  * Faire Appel à la couche metier pour effectuer les traitements
		  */
		double resultat = metier.calculerMensualiteCredit(montant, taux, duree);
		/*
		  * Faire Appel à la couche metier pour effectuer les traitements
		  */
		model.setMensualite(resultat);
		System.out.println("Mensualité : " + model.getMensualite());
		/*
		 * Stocker le model dans l'object resquest
		 */
		request.setAttribute("creditModel", model);
		/*
		  * Faire un forward vers la vue JSP
		  */
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
	}
	
}
