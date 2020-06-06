package Modele;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
public class Salle {   
	
    private int IdSalle ;   
	private String intitulé;     

	
	public Salle(int idSalle, String intitulé) {      
		super();    
		this.IdSalle = idSalle;  
		this.intitulé = intitulé;                     
	}   
	public Salle(int idSalle) {      
		this.IdSalle = idSalle;                    
	} 

	public int getIdSalle() {
		return IdSalle;
	}

	public void setIdSalle(int idSalle) {
		IdSalle = idSalle;
	}


	public String getIntitulé() {   
		return intitulé;     
	}                                             
              
	public void setIntitulé(String intitulé) {  
		this.intitulé = intitulé;   
	}                                                    
                                        
// l'ajout d'une salle 
 public void AjouterSalle(){
		try {
			Class.forName("com.mysql.jdbc.Driver");      
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
			PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("INSERT INTO Salle values(?,?)");
			cmd.setInt(1,IdSalle);  
			cmd.setString(2,intitulé);    
			cmd.execute() ;         
		}           
		catch (Exception e) {   
			e.printStackTrace();      
		} 
	 
 }
 //la suppression d'une salle
 public void SupprimerSalle(){
		try {
			Class.forName("com.mysql.jdbc.Driver");      
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
			PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("DELETE FROM SALLE WHERE IdSalle = ?");
			cmd.setInt(1,IdSalle);   
			cmd.execute() ;            
		}           
		catch (Exception e) {   
			e.printStackTrace();      
		} }

//la méthode de la modification 
public void ModifierSalle(){
	 try {
			Class.forName("com.mysql.jdbc.Driver");      
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
			PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("UPDATE Salle SET intitulé = ? WHERE IdSalle = ?");   
			cmd.setInt(1,IdSalle);   
			cmd.setString(2,intitulé);
			cmd.execute() ;                 
		}          
		catch (Exception e) {   
			e.printStackTrace();      
		}
		 
}

//la méthode de recherche 
public boolean RechercherSalle(){  
	 boolean trouve = false; 
	 try{
		 Class.forName("com.mysql.jdbc.Driver");      
	     Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
	     PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("SELECT * FROM Salle WHERE IdSalle = ?");  
	     cmd.setInt(1,IdSalle);      
	     ResultSet rs = cmd.executeQuery();
	     IdSalle= rs.getInt("IdSalle");         
			if(IdSalle != 0)  
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
