package Modele;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
public class Enseignant {
    private  int IDdEn ; 
    private String Nom ; 
    private String Prenom ; 
    private String matiereEns ; 
 
	public Enseignant() {
		super();
	}      

	public Enseignant(int iDdEn, String nom, String prenom, String matiereEns) {
		super();
		IDdEn = iDdEn;
		Nom = nom;
		Prenom = prenom;  
		this.matiereEns = matiereEns;
	}
	public Enseignant(int iDdEn) {
		super();
		IDdEn = iDdEn; 
	}

	public int getIndentifiant() {
		return IDdEn;  
	}
	public void setIndentifiant(int indentifiant) {
		IDdEn = indentifiant;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getMatiereEns() {
		return matiereEns;
	}
	public void setMatiereEns(String matiereEns) {
		this.matiereEns = matiereEns;
	}
    
	// la méthode d'ajout d'un étudiant    
	public  void AjouterEnseignat(){
		try {
			Class.forName("com.mysql.jdbc.Driver");      
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
			PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("INSERT INTO Enseignant values(?,?,?,?)");   
			cmd.setInt(1,IDdEn);         
			cmd.setString(2,Nom);  
			cmd.setString(3,Prenom);  
			cmd.setString(4,matiereEns);    
			cmd.execute() ;                   
		}              
		catch (Exception e) {   
			e.printStackTrace();      
		}    
	}
	 public  void SupprimerEnseignant(){
		try {
			Class.forName("com.mysql.jdbc.Driver");      
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
			PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("DELETE FROM Enseignant WHERE IdEns= ?");
			cmd.setInt(1,IDdEn);      
			cmd.execute() ;                    
		}          
		catch (Exception e) {   
			e.printStackTrace();   
		}      
	 }
	 public Enseignant Afficher(){ 
			
			try {    
				Class.forName("com.mysql.jdbc.Driver");      
				Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
				PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("SELECT * FROM Enseignant WHERE IdEns = ?");  
				cmd.setInt(1,IDdEn);     
				cmd.execute();   
				ResultSet rs = cmd.executeQuery();
				while(rs.next()){
					IDdEn= rs.getInt("IDEns") ;    
					Nom = rs.getString("nom") ;
					Prenom = rs.getString("prenom");
					matiereEns = rs.getString("matiereEns");      
				}          
			}                   
			catch (Exception e) {   
				e.printStackTrace();   
			}    
		 return this ;             
	    }      
	// la méthode de la modification 
	 public void ModifierEnseignant(){
		 try {
				Class.forName("com.mysql.jdbc.Driver");      
				Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
				PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("UPDATE Enseignant SET IdEns = ?, nom = ?, prenom= ?, matiereEns = ? WHERE CNE = ?");   
				cmd.setString(1,Nom);   
				cmd.setString(2,Prenom);
				cmd.setString(3,matiereEns); 
				cmd.setInt(4, IDdEn);     
				cmd.execute() ;                      
			}          
			catch (Exception e) {   
				e.printStackTrace();      
			}
			 
	 }
	 
	 //la méthode de recherche 
	 public boolean RechercherEnseignant(){
		 boolean trouve = false; 
		 try{
			 Class.forName("com.mysql.jdbc.Driver");      
		     Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
		     PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("SELECT * FROM Enseignant WHERE CNE = ?");  
		     cmd.setInt(1,IDdEn);      
		     ResultSet rs = cmd.executeQuery();
			 IDdEn = rs.getInt("IdEns") ;       
				if(IDdEn != 0)    
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
