package Controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ServletLogin() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int n = 0 ;  
		 PrintWriter P = response.getWriter() ; 
		try{
		 String l = request.getParameter("login") ;    
		 String p = request.getParameter("pwd") ;      
 
			 Class.forName("com.mysql.jdbc.Driver");      
		     Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
		     PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("SELECT * FROM connection");  
		     ResultSet rs = cmd.executeQuery();
				while(rs.next()){ 
					if (rs.getString("login").equals(l) &&  rs.getString("pass").equals(p)) {
						n= 1 ; 
						if(rs.getString("login").equals("med") && rs.getString("pass").equals("aksachlii")){
							n = 2 ; 
						}   
					}  
				}  
	}
		 catch (Exception e) {   
				e.printStackTrace();      
			}
    if (n==2){   
    	 P.print("<html><script>window.open('views/MenuPrincipal/InterfaceAdmin.jsp','_self'); </script></html>");
    	// request.getRequestDispatcher("views/MenuPrincipal/InterfaceAdmin.jsp").forward(request, response);
    }else if (n==1){
    	P.print("<html><script>window.open('views/MenuPrincipal/InterfaceUser.jsp','_self'); </script></html>");
    	//request.getRequestDispatcher("views/Authentification/InterfaceUser.jsp").forward(request, response);        
    }else{  
    	P.print("<html><script>alert('les informations que vous avez saisir sont incorrect'); self.history.back(); </script></html>");
    }       
    
   }   
}  

