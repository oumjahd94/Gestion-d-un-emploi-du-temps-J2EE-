package Modele;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList; 
import com.mysql.jdbc.PreparedStatement;
public class Matière {
    private int IdMatiere ;
    private String designation ;
    
	public Matière(int idMatiere, String designation) {
		super();
		IdMatiere = idMatiere;
		this.designation = designation;
	}
	public Matière(int idMatiere) {
		IdMatiere = idMatiere;
	}
	public Matière() {
		IdMatiere = 0;
		this.designation ="";
	}  
	public int getIdMatiere() {
		return IdMatiere;
	}
	public void setIdMatiere(int idMatiere) {
		IdMatiere = idMatiere;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	} 
    
	//la méthode d'ajout d'un étudiant    
	public  void AjouterMatière(){
		try {
			Class.forName("com.mysql.jdbc.Driver");      
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
			PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("INSERT INTO Matiere values(?,?)");   
			cmd.setInt(1,IdMatiere);       
			cmd.setString(2,designation);      
			cmd.execute() ;              
		}              
		catch (Exception e) {     
			e.printStackTrace();         
		}    
		// etud.add(E) ;     
	} 
	//la méthode de la suppression 
	public  void SupprimerMatière(){
		try {
			Class.forName("com.mysql.jdbc.Driver");      
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
			PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("DELETE FROM Matiere WHERE IdMatiere = ?");
			cmd.setInt(1,IdMatiere);   
			cmd.execute() ;                   
		}          
		catch (Exception e) {   
			e.printStackTrace();   
		}      
	} 

	//la méthode d'affichage 
	public Matière Afficher(){ 
			
			try {    
				Class.forName("com.mysql.jdbc.Driver");      
				Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
				PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("SELECT * FROM Matiere WHERE IdMatiere = ?");  
				cmd.setInt(1,IdMatiere);        
				cmd.execute();   
				ResultSet rs = cmd.executeQuery();
				while(rs.next()){
					IdMatiere= rs.getInt("IdMatiere") ;   
					designation = rs.getString("designation") ;
				}          
			}                   
			catch (Exception e) {   
				e.printStackTrace();   
			}    
		 return this ;             
	 }      
	//la méthode de la modification 
	public void ModifierMatière(){
		 try {
				Class.forName("com.mysql.jdbc.Driver");      
				Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
				PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("UPDATE Matiere SET IdMatiere = ? WHERE designation = ?");   
				cmd.setInt(1,IdMatiere);   
				cmd.setString(2,designation);
				cmd.execute() ;                 
			}          
			catch (Exception e) {   
				e.printStackTrace();      
			}
			 
	}

	//la méthode de recherche 
	public boolean RechercherMatière(){  
		 boolean trouve = false; 
		 try{
			 Class.forName("com.mysql.jdbc.Driver");      
		     Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
		     PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("SELECT * FROM Matiere WHERE IdMatiere = ?");  
		     cmd.setInt(1,IdMatiere);      
		     ResultSet rs = cmd.executeQuery();
		     IdMatiere= rs.getInt("IdMatiere");       
				if(IdMatiere != 0)  
					trouve = true ;   
				else
					trouve = false ; 
		 }   
		 catch (Exception e) {   
				e.printStackTrace();      
			}
		 return trouve ;      
	} 
// la récupération des matières 
	public  ArrayList<String> retenir(){
		ArrayList<String> Ar = new ArrayList<String>();
		try{  
			 Class.forName("com.mysql.jdbc.Driver");      
		     Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
		     PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("SELECT * FROM Matiere");     
		     ResultSet rs = cmd.executeQuery();
		    
		 	while(rs.next()){
              Ar.add((String) rs.getString("designation")) ; 
			}              
		}                   
		catch (Exception e) {   
			e.printStackTrace();   
		}    
	 return Ar ;   
	}
}
