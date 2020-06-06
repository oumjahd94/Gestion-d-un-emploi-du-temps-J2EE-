package Modele;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
public class Module {
	private int id ; 
    private String intitulé ;

	public String getIntitulé() {
		return intitulé;
	}

	public void setIntitulé(String intitulé) {
		this.intitulé = intitulé;
	}

	public Module(int id, String intitulé) {
		super();
		this.id = id; 
		this.intitulé = intitulé;
	}
	public Module(int id) {
		this.id = id; 
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
     
	
	//la méthode d'ajout d'un étudiant    
	public  void AjouterModule(){
		try {
			Class.forName("com.mysql.jdbc.Driver");      
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
			PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("INSERT INTO Module values(?,?)");   
			cmd.setInt(1,id);       
			cmd.setString(2,intitulé);    
			cmd.execute() ;              
		}              
		catch (Exception e) {     
			e.printStackTrace();         
		}    
		// etud.add(E) ;     
	} 
	//la méthode de la suppression 
	public  void SupprimerModule(){
		try {
			Class.forName("com.mysql.jdbc.Driver");      
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
			PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("DELETE FROM Module WHERE IdModule = ?");
			cmd.setInt(1,id);   
			cmd.execute() ;                   
		}          
		catch (Exception e) {   
			e.printStackTrace();   
		}      
	} 

	//la méthode d'affichage 
	public Module Afficher(){ 
			
			try {    
				Class.forName("com.mysql.jdbc.Driver");      
				Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
				PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("SELECT * FROM Module WHERE IdModule = ?");  
				cmd.setInt(1,id);        
				cmd.execute();   
				ResultSet rs = cmd.executeQuery();
				while(rs.next()){
					id= rs.getInt("IdModule") ;   
					intitulé = rs.getString("IntituleModule") ;
				}          
			}                   
			catch (Exception e) {   
				e.printStackTrace();   
			}    
		 return this ;             
	 }      
	//la méthode de la modification 
	public void ModifierModule(){
		 try {
				Class.forName("com.mysql.jdbc.Driver");      
				Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
				PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("UPDATE Module SET IdModule = ? WHERE IntituleModule = ?");   
				cmd.setInt(1,id);   
				cmd.setString(2,intitulé);
				cmd.execute() ;                 
			}          
			catch (Exception e) {   
				e.printStackTrace();      
			}
			 
	}

	//la méthode de recherche 
	public boolean RechercherModule(){
		 boolean trouve = false; 
		 try{
			 Class.forName("com.mysql.jdbc.Driver");      
		     Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
		     PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("SELECT * FROM Module WHERE IdModule = ?");  
		     cmd.setInt(1,id);         
		     ResultSet rs = cmd.executeQuery();
					id= rs.getInt("IdModule");       
				if(id != 0)  
					trouve = true ;     
				else
					trouve = false ; 
		 }   
		 catch (Exception e) {   
				e.printStackTrace();      
			}
		 return trouve ;      
	}
}
