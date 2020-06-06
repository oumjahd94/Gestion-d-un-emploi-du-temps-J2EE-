package Modele;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
public class Filiere {
   private int code ;
   private String intitulé ;

public String getIntitulé() {
	return intitulé;
}

public void setIntitulé(String intitulé) {
	this.intitulé = intitulé;
}

public Filiere(int code , String intitulé) {
	super();
	this.intitulé = intitulé;
	this.code = code ; 
}
public Filiere() {
	super();
	this.intitulé ="";
	this.code =0;   
}
public int getCode() {
	return code;
}
public Filiere(int code) {
	this.code = code ; 
}
public void setCode(int code) {
	this.code = code;
} 
  
//la méthode d'ajout d'un étudiant    
public  void AjouterFiliere(){
	try {
		Class.forName("com.mysql.jdbc.Driver");      
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
		PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("INSERT INTO Filiere values(?,?)");   
		cmd.setInt(1,code);       
		cmd.setString(2,intitulé);    
		cmd.execute() ;              
	}              
	catch (Exception e) {     
		e.printStackTrace();         
	}    
	// etud.add(E) ;     
} 
//la méthode de la suppression 
public  void SupprimerFiliere(){
	try {
		Class.forName("com.mysql.jdbc.Driver");      
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
		PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("DELETE FROM Filiere WHERE CodeFiliere = ?");
		cmd.setInt(1,code);   
		cmd.execute() ;                   
	}          
	catch (Exception e) {   
		e.printStackTrace();   
	}      
} 

//la méthode d'affichage 
public Filiere Afficher(){ 
		
		try {    
			Class.forName("com.mysql.jdbc.Driver");      
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
			PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("SELECT * FROM Filiere WHERE CodeFiliere = ?");  
			cmd.setInt(1,code);        
			cmd.execute();   
			ResultSet rs = cmd.executeQuery();
			while(rs.next()){
				code= rs.getInt("CodeFiliere") ;   
				intitulé = rs.getString("Intitule") ;
			}          
		}                   
		catch (Exception e) {   
			e.printStackTrace();   
		}    
	 return this ;             
 }      
//la méthode de la modification 
public void ModifierFiliere(){
	 try {
			Class.forName("com.mysql.jdbc.Driver");      
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
			PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("UPDATE Filiere SET Intitule = ? WHERE CodeFiliere = ?");   
			cmd.setInt(1,code);   
			cmd.setString(2,intitulé);
			cmd.execute() ;                 
		}          
		catch (Exception e) {   
			e.printStackTrace();      
		}
		 
}

//la méthode de recherche 
public boolean RechercherFiliere(){  
	 boolean trouve = false; 
	 try{
		 Class.forName("com.mysql.jdbc.Driver");      
	     Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
	     PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("SELECT * FROM Filiere WHERE CodeFiliere = ?");  
	     cmd.setInt(1,code);      
	     ResultSet rs = cmd.executeQuery();
				code= rs.getInt("CodeFiliere");       
			if(code != 0)  
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


