package Controleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modele.Filiere;

@WebServlet("/ServletFiliere")
public class ServletFiliere extends HttpServlet {

    public ServletFiliere() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter p = response.getWriter() ; 
			// récupérer les informations  
			String c = request.getParameter("f");     
			String n = request.getParameter("i");   
			// instanciation d'un objet de type etudiant 
			   
			if (request.getParameter("ajouter") != null) {  
			Filiere f = new Filiere(Integer.parseInt(c), n);  
			 f.AjouterFiliere();         
			 p.print("<html><script>alert('Bien ajouté'); self.history.back();</script></html>");  
			// request.getRequestDispatcher("views/MenuPrincipal/Etudiant.jsp").forward(request, response);
			}   
			if (request.getParameter("supprimer") != null) {
				Filiere f = new Filiere(Integer.parseInt(c));  
				f.SupprimerFiliere(); 
				p.print("<html><script>alert('la suppression est bien fait'); self.history.back();</script></html>");  
				//request.getRequestDispatcher("views/MenuPrincipal/Etudiant.jsp").forward(request, response);
			}    
			if (request.getParameter("modifier") != null) {    
				Filiere f = new Filiere(Integer.parseInt(c), n);  
				f.ModifierFiliere();
				p.print("<html><script>alert('la modification est bien déroulé'); self.history.back();</script></html>"); 
				//request.getRequestDispatcher("views/MenuPrincipal/Etudiant.jsp").forward(request, response);
			}     
			if (request.getParameter("rechercher") != null) {    
				Filiere f = new Filiere(Integer.parseInt(c));        
		        	   boolean existe;      
		               existe = f.RechercherFiliere() ;      
		               if(existe){     
		            	   p.print("<html><script> alert('Cet étudiant est existe dans la base de donnée vous pouvez afficher ses informations'); self.history.back();</script></html>");   
		            	  }
		               else{
		            		p.print("<html><script> alert('Désolé cet etudiant n existe pas dans la base de données'); self.history.back();</script></html>");   
		                   } 
		   
		      }    
	}

}
