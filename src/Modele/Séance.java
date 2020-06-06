package Modele;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;
public class Séance {
    private  String intitulé ;

	public String getIntitulé() {
		return intitulé;
	}

	public void setIntitulé(String intitulé) {
		this.intitulé = intitulé;
	}

	public Séance(String intitulé) {
		super();
		this.intitulé = intitulé;
	}
      
}
