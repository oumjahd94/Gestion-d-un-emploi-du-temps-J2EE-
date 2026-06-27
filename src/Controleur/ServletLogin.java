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

import java.sql.PreparedStatement;

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
		 System.out.println("[DEBUG] ========== LOGIN ATTEMPT ==========");
		 System.out.println("[DEBUG] login=" + l + ", password=" + p);
  
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("[DEBUG] MySQL Driver loaded");
			 // Connect to the MySQL service via docker-compose (use explicit service/container name)
			 Connection cn = DriverManager.getConnection("jdbc:mysql://edt_mysql:3306/edt?useSSL=false&serverTimezone=UTC","root",""
			 );
			 System.out.println("[DEBUG] Connected to MySQL at jdbc:mysql://edt_mysql:3306/edt");
			 PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("SELECT * FROM connection");  
		     ResultSet rs = cmd.executeQuery();
		     System.out.println("[DEBUG] Query executed, checking credentials...");
			while(rs.next()){ 
				String dbLogin = rs.getString("login");
				String dbPass = rs.getString("pass");
				System.out.println("[DEBUG]   Row: login=[" + dbLogin + "], pass=[" + dbPass + "]");
				
				if (dbLogin != null && dbPass != null && dbLogin.equals(l) && dbPass.equals(p)) {
					System.out.println("[DEBUG]   MATCH FOUND!");
					n= 1 ; 
					if(dbLogin.equals("med") && dbPass.equals("aksachlii")){
						System.out.println("[DEBUG]   ADMIN USER (med)");
						n = 2 ; 
					}   
				}
			}
			System.out.println("[DEBUG] Final n value: " + n);
			cn.close();
			System.out.println("[DEBUG] Connection closed");
	}
		 catch (Exception e) {
				System.out.println("[DEBUG] EXCEPTION: " + e.getClass().getName() + " - " + e.getMessage());
				e.printStackTrace();      
			}
    if (n==2){   
    	 System.out.println("[DEBUG] Redirecting to InterfaceAdmin");
    	 P.print("<html><script>window.open('views/MenuPrincipal/InterfaceAdmin.jsp','_self'); </script></html>");
    }else if (n==1){
    	System.out.println("[DEBUG] Redirecting to InterfaceUser");
    	P.print("<html><script>window.open('views/MenuPrincipal/InterfaceUser.jsp','_self'); </script></html>");
    }else{
    	System.out.println("[DEBUG] Authentication FAILED - showing error");
    	P.print("<html><script>alert('les informations que vous avez saisir sont incorrect'); self.history.back(); </script></html>");
    }       
    
   }   
}
