<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import ="java.util.Iterator " %>    
<%@ page import ="java.sql.Connection" %> 
<%@ page import ="java.sql.DriverManager" %> 
<%@ page import ="java.sql.ResultSet" %>   
<%@ page import ="com.mysql.jdbc.PreparedStatement" %>
<%@ page import= "Modele.Enseignant" %>      
<%@ page import= "java.util.ArrayList" %> 
<%@ page import= "Modele.Matière" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>L'interface Enseignant</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/css/divEns.css" />" /> 
<script  type="text/javascript">
   function valider(){
	   if(document.f1.n.value =="" ||  document.f1.p.value=="" || document.f1.c.value=="" || document.f1.nv.value=="" ){
           return false;   
	   }
	   else{
		   return true ; 
	   }  
   }
   function envoi(){
	   if(document.f1.n.value =="" ||  document.f1.p.value=="" || document.f1.c.value=="" || document.f1.nv.value==""){
                 alert("veuillez vérifier vos champs");  
	   }  
   }
   function transmettre(){
	   if(document.f1.c.value =="" ){
           alert("veuillez saisir le CNE");   
     }   
   }
   </script>
</head>
<body>  
     <div id="d1"><img src="<c:url value ="/img/entete.JPG" />" width ="100%" height ="100%" />  </div>  
      <div id="d2">   
             
	   <form  method="post" action=""> 
	      <table border="0" rules="all" width ="85.5%" cellpadding ="14" id="entete1">  
		    <tr >
		        <th> PARAMETRAGE D'UN ENSEIGNANT </th>   
		    </tr>   
         </table>       
	     <fieldset class="f1"> <br/>                                                       
              <label for="id">ID de l'enseignant : </label>   
              <input type="number" id="id" name="c" value="" size="20" maxlength="60" />
              <br />
              <label for="nom">Nom de l'enseignant : </label>     
              <input type="text" id="nom" name="n" value="" size="20" maxlength="20"  />
              <br />       
              <label for="prenom">Prénom de l'enseignant : </label>
              <input type="text" id="prenom" name="p" value="" size="20" maxlength="20" />   
              <br /> 
              <label for="niveau">La matière qu'il(elle) enseigne : </label> 
              <%  ArrayList<String> Ar = new ArrayList<String>(); 
              Matière M = new Matière();  
              Ar = M.retenir();  %>    
              <select name ="nv" id="mat"></pre>  
               <% for(int i=0; i<Ar.size(); i++){ %>        
                     <option><% out.print(Ar.get(i)) ;%></option>     
               <%} %>
              </select>  
             
              <br /> <br />      
              <pre><input type="submit" value=" Ajouter  "  name="ajouter" class="bt" onclick="envoi()" />    <input type="submit" value=" Modifier " name="modifier" class="bt" onclick="envoi()"/>    <input type="submit" value="Supprimer" name="supprimer" class="bt" />     <input type="submit" value="Rechercher"  name="rechercher" class="bt" onclick="transmettre()"/></pre>    
              <br /> <font color ="#0a79b9 "> *avant de faire une opértion veuillez d'abord effectuer une recharche</font>           
              <br />       
        </fieldset>                    
	   </form>   
	   	  
     </div>        
     <div id="d3">
       <pre>
       
       <img src="<c:url value ="/img/ens.jpg" />"  width ="100%" height ="100%" />                              </pre>
     </div> <pre>      
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    
    
     <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
     <div id="d4">
       <table border="0" rules="all" width ="60.5%" cellpadding ="14" id="entete2">  
		    <tr >
		        <th> LES INFORMATIONS D'UN ENSEIGNANT </th>     
		    </tr>   
       </table> 
      <fieldset class="f2">
            <form  method="post" action="../../ServletEtudiant" onsubmit="return valider()">       
             <pre> Veuillez saisir L' ID :                         <input type="number" id="search" name="s" value="" size="20" maxlength="20" />      <input type="submit" value=" Afficher " name=" Afficher " class="bt" transmettre() />    <input type="submit" value="Rechercher" name="rechercher" class="bt" onclick="transmettre()" /></pre>  
           </form> 
           </form>   
        
      <table  width="90%" rules ="all"  cellpadding ="15" cellspacing = "10" id="tab" >   
        <tr id="l1"> 
          <th>ID </th>
          <th>Nom  </th>   
          <th>Prénom</th>
          <th>MATIERE</th>
        </tr>  
        <tr>
          <td></td>
          <td></td>
          <td></td>
          <td></td>  
        </tr>  
      </table>
      </fieldset> <br/><br/>      
    </div>    
  
  
</body>
</html>
</body>
</html>