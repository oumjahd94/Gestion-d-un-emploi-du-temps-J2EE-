package Controleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modele.Enseignant;


@WebServlet("/ServletEnseignant")
public class ServletEnseignant extends HttpServlet {

    public ServletEnseignant() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter p = response.getWriter() ; 
		// récupérer les informations  
		int id = Integer.parseInt(request.getParameter("c"));       
		String nom = request.getParameter("n");
		String prenom = request.getParameter("p");
		String matiere = request.getParameter("mat");
		// instanciation d'un objet de type etudiant 
		   
		if (request.getParameter("ajouter") != null) {
			Enseignant en = new Enseignant(id, nom, prenom,matiere); 
		 en.AjouterEnseignat();                   
		 p.print("<html><script>alert('Bien ajouté'); self.history.back();</script></html>");  
		}   
		if (request.getParameter("supprimer") != null) {
			Enseignant en = new Enseignant(id); 
			en.SupprimerEnseignant();        
			p.print("<html><script>alert('la suppression est bien fait'); self.history.back();</script></html>"); 
		}    
		if (request.getParameter("modifier") != null) {    
			Enseignant en = new Enseignant(id, nom, prenom, matiere); 
			en.ModifierEnseignant();       
			p.print("<html><script>alert('la modification est bien déroulé'); self.history.back();</script></html>"); 
		}     
		if (request.getParameter("rechercher") != null) {  
			Enseignant en = new Enseignant(id);    
	        	   boolean existe;      
	               existe = en.RechercherEnseignant();       
	               if(existe){
	            	   p.print("<html><script> alert('Cet étudiant est existe dans la base de donnée vous pouvez afficher ses informations'); self.history.back();</script></html>");   
	            	  }
	               else{
	            		p.print("<html><script> alert('Désolé cet etudiant n existe pas dans la base de données'); self.history.back();</script></html>");   
	                   } 
	               request.getRequestDispatcher("views/MenuPrincipal/Enseignant.jsp").forward(request, response);  
	      }
		}
	}

