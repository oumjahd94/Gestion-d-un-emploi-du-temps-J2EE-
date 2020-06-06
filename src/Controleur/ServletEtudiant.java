package Controleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modele.Etudiant;

// l'annotation 
@WebServlet("/ServletEtudiant")   
public class ServletEtudiant extends HttpServlet {      
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter p = response.getWriter() ; 
		// récupérer les informations    
		String cne = request.getParameter("c");  
		String nom = request.getParameter("n") ;
		String prenom = request.getParameter("p");
		String niveau = request.getParameter("nv");   
	    
		// instanciation d'un objet de type etudiant 
		   
		if (request.getParameter("ajouter") != null) {  
		Etudiant et = new Etudiant(cne, nom, prenom, niveau); 
		 et.AjouterEtudiant();       
		 p.print("<html><script>alert('Bien ajouté'); self.history.back();</script></html>");  
		// request.getRequestDispatcher("views/MenuPrincipal/Etudiant.jsp").forward(request, response);
		}   
		if (request.getParameter("supprimer") != null) {
			Etudiant et = new Etudiant(cne); 
			et.SupprimerEtudiant();    
			p.print("<html><script>alert('la suppression est bien fait'); self.history.back();</script></html>");  
			//request.getRequestDispatcher("views/MenuPrincipal/Etudiant.jsp").forward(request, response);
		}    
		if (request.getParameter("modifier") != null) {    
			Etudiant et = new Etudiant(cne, nom, prenom, niveau); 
			et.ModifierEtudiant();
			p.print("<html><script>alert('la modification est bien déroulé'); self.history.back();</script></html>"); 
			//request.getRequestDispatcher("views/MenuPrincipal/Etudiant.jsp").forward(request, response);
		}     
		if (request.getParameter("rechercher") != null) {    
			Etudiant et = new Etudiant(cne);    
	        	   boolean existe;    
	               existe = et.RechercherEtudiant();       
	               if(existe == true){ 
	            	   p.print("<html><script> alert('Cet étudiant est existe dans la base de donnée vous pouvez afficher ses informations'); self.history.back();</script></html>");   
	            	  }
	               else{
	            		p.print("<html><script> alert('Cet étudiant est existe dans la base de donnée vous pouvez afficher ses informations'); self.history.back();</script></html>");   
	                   } 
	   
	      }
		}    

}   
