package Modele;   
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;
 
  public class Etudiant {   
            private String  CNE;        
            private String  nom;        
            private String  prenom;         
            private String  niveau;                
           // private ArrayList<Etudiant> etud = new ArrayList<Etudiant>();   
// constructeur d'intialisation     
  public Etudiant(String cNE, String nom, String prenom , String niveau) {   
	super();   
	CNE = cNE;
	this.nom = nom;
	this.prenom = prenom;
	this.niveau = niveau ; 
}
  public Etudiant(String cne) {
	  this.CNE = cne ; 
  }   
// un constructeur par défaut 
  public Etudiant() {
	  super();
   } 
// les getters et les setters 
  public String getCNE() {   
    	return CNE;
  }

  public void setCNE(String cNE) {
	 CNE = cNE;
  }

   public String getNom() {
	 return nom;
   }

   public void setNom(String nom) {
	 this.nom = nom;
   }

   public String getPrenom() {
	 return prenom;
   }

   public void setPrenom(String prenom) {
	 this.prenom = prenom;
   } 

   public String toString(){
	  return "CNE: "+ this.CNE +"\n nom: "+ this.nom + "\n prenom : "+ this.prenom + "\n niveau : "+ this.niveau;   
   } 
   public void show(){  
	  System.out.println(toString());    
   }
   
   public String getNiveau() {   
		return niveau;
	}   
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}          
// la méthode d'ajout d'un étudiant    
public  void AjouterEtudiant(){
	try {
		Class.forName("com.mysql.jdbc.Driver");      
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
		PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("INSERT INTO Etudiant values(?,?,?,?)");   
		cmd.setString(1,CNE);       
		cmd.setString(2,nom);  
		cmd.setString(3,prenom);  
		cmd.setString(4,niveau);   
		cmd.execute() ;              
	}              
	catch (Exception e) {     
		e.printStackTrace();         
	}    
	// etud.add(E) ;     
 } 
//la méthode de la suppression 
 public  void SupprimerEtudiant(){
	try {
		Class.forName("com.mysql.jdbc.Driver");      
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
		PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("DELETE FROM Etudiant WHERE CNE= ?");
		cmd.setString(1,CNE);   
		cmd.execute() ;                  
	}          
	catch (Exception e) {   
		e.printStackTrace();   
	}      
 } 

// la méthode d'affichage 
 public Etudiant Afficher(){ 
		
		try {    
			Class.forName("com.mysql.jdbc.Driver");      
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
			PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("SELECT * FROM Etudiant WHERE CNE = ?");  
			cmd.setString(1,CNE);     
			cmd.execute();   
			ResultSet rs = cmd.executeQuery();
			while(rs.next()){
				CNE= rs.getString("CNE") ;   
				nom = rs.getString("nom") ;
				prenom = rs.getString("prenom");
				niveau = rs.getString("niveau");    
			}
		}                   
		catch (Exception e) {   
			e.printStackTrace();   
		}    
	 return this ;             
    }      
// la méthode de la modification 
 public void ModifierEtudiant(){
	 try {
			Class.forName("com.mysql.jdbc.Driver");      
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
			PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("UPDATE Etudiant SET nom = ?, prenom = ?, niveau= ? WHERE CNE = ?");   
			cmd.setString(1,nom);   
			cmd.setString(2,prenom);
			cmd.setString(3,niveau); 
			cmd.setString(4, CNE);  
			cmd.execute() ;                 
		}          
		catch (Exception e) {   
			e.printStackTrace();      
		}
		 
 }
 
 //la méthode de recherche 
 public boolean RechercherEtudiant(){
	 boolean trouve = false; 
	 try{
		 Class.forName("com.mysql.jdbc.Driver");      
	     Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
	     PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("SELECT * FROM Etudiant WHERE CNE = ?");  
	     cmd.setString(1,CNE);    
	     ResultSet rs = cmd.executeQuery();
				       
			if(CNE.equals(rs.getString("CNE")) )    
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
