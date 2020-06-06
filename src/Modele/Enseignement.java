package Modele;

public class Enseignement {
    private String typeEnseignenment ;

	public String getTypeEnseignenment() {
		return typeEnseignenment;
	}

	public void setTypeEnseignenment(String typeEnseignenment) {
		this.typeEnseignenment = typeEnseignenment;
	}

	public Enseignement(String typeEnseignenment) {
		super();   
		this.typeEnseignenment = typeEnseignenment;
	} 
          
}
