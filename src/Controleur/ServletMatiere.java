package Controleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modele.Matière;  

@WebServlet("/ServletMatiere")
public class ServletMatiere extends HttpServlet {

    public ServletMatiere() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter p = response.getWriter() ; 
			// récupérer les informations  
			String c = request.getParameter("f");     
			String n = request.getParameter("i");   
			// instanciation d'un objet de type etudiant 
			   
			if (request.getParameter("ajouter") != null) {  
				Matière ma = new Matière(Integer.parseInt(c), n);  
			 ma.AjouterMatière();       
			 p.print("<html><script>alert('Bien ajouté'); self.history.back();</script></html>");  
			// request.getRequestDispatcher("views/MenuPrincipal/Etudiant.jsp").forward(request, response);
			}   
			if (request.getParameter("supprimer") != null) {
				Matière ma = new Matière(Integer.parseInt(c));  
				ma.SupprimerMatière();
				p.print("<html><script>alert('la suppression est bien fait'); self.history.back();</script></html>");  
				//request.getRequestDispatcher("views/MenuPrincipal/Etudiant.jsp").forward(request, response);
			}    
			if (request.getParameter("modifier") != null) {    
				Matière ma = new Matière(Integer.parseInt(c), n);  
				ma.ModifierMatière();
				p.print("<html><script>alert('la modification est bien déroulé'); self.history.back();</script></html>"); 
				//request.getRequestDispatcher("views/MenuPrincipal/Etudiant.jsp").forward(request, response);
			}     
			if (request.getParameter("rechercher") != null) {    
				Matière ma = new Matière(Integer.parseInt(c));        
		        	   boolean existe;      
		               existe = ma.RechercherMatière();     
		               if(existe){     
		            	   p.print("<html><script> alert('Cet étudiant est existe dans la base de donnée vous pouvez afficher ses informations'); self.history.back();</script></html>");   
		            	  }
		               else{
		            		p.print("<html><script> alert('Désolé cet etudiant n existe pas dans la base de données'); self.history.back();</script></html>");   
		                   } 
		   
		      }    
	}

}
