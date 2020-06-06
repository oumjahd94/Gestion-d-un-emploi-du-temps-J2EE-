<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ page import ="java.util.Iterator " %>    
<%@ page import ="java.sql.Connection" %> 
<%@ page import ="java.sql.DriverManager" %> 
<%@ page import ="java.sql.ResultSet" %>   
<%@ page import ="com.mysql.jdbc.PreparedStatement" %>
<%@ page import= "Modele.Etudiant" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>L'interface Etudiant</title>      
<link type="text/css" rel="stylesheet" href="<c:url value="/css/divEtud.css" />" />   
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
   function trans(){
	   if(document.f1.c.value =="" ){
           alert("veuillez saisir le CNE");   
     
	   }}   
	   function transm(){
		   if(document.f2.c.value =="" ){
	           alert("veuillez saisir le CNE");   
	     }  
   }
   </script> 
</head>
<!-- onLoad="ouvrir()" onUnload="fermer()" -->
<body >    
  
  
  <div id="d1"><img src="<c:url value ="/img/entete.JPG" />" width ="100%" height ="100%" id="ent" />  </div>  
      <div id="d2">   
             
	   <form  method="post" action="../../ServletEtudiant" name="f1"  onsubmit="return valider()">                     
	      <table border="0" rules="all" width ="85.5%" cellpadding ="14" id="entete1">  
		    <tr >
		        <th> PARAMETRAGE D'UN ETUDIANT </th>     
		    </tr>   
         </table>          
	     <fieldset class="f1"> <br/>                                                          
              <label for="cne">CNE de l'étudiant: </label>    
              <input type="number" id="cne" name="c" value="" size="20" maxlength="60" />  
              <br />
              <label for="nom">Nom de l'étudiant :</label>     
              <input type="text" id="nom" name="n" value="" size="20" maxlength="20" />
              <br />       
              <label for="prenom">Prénom de l'étudiant </label>
              <input type="text" id="prenom" name="p" value="" size="20" maxlength="20" /> 
              <br /> 
              <label for="niveau">Niveau de l'étudiant </label>    
              <select name ="nv" id="niveau">            
                  <option value="1emeAnnee">1<sup>ere</sup>Annee</option>                 
                  <option value="2emeAnnee">2<sup>eme</sup>Annee</option>    
                  <option value="3emeAnnee">3<sup>eme</sup>Annee</option>            
              </select>       
              <br /> <br /><br />    
              <pre><input type="submit" value=" Ajouter  "  name="ajouter" class="bt" onclick="envoi()" />    <input type="submit" value=" Modifier " name="modifier" class="bt" onclick="envoi()" />    <input type="submit" value="Supprimer" name="supprimer" class="bt" onclick="trans()" />     <input type="submit" value="Rechercher"  name="rechercher" class="bt" onclick="trans()" /></pre>    
              <br /> <font color ="#0a79b9 "> *avant de faire une opértion veuillez d'abord effectuer une recharche</font>       
        </fieldset>                    
	   </form>   
	   	  
     </div>        
     <div id="d3">
       <pre>
       
<img src="<c:url value ="/img/etud.png" />"  width ="100%" height ="100%" />                              </pre>
     </div> <pre>      
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     <br /><br /><br /><br /><br /><br /><br />
     <div id="d4">
       <table border="0" rules="all" width ="60%" cellpadding ="14" id="entete2">  
		    <tr >
		        <th> LES INFORMATIONS D'UN ETUDIANT </th>   
		    </tr>   
       </table> 
      <fieldset class="f2">
            <form  method="post" action=""  name="f2">    
             <pre> Veuillez saisir Le CNE :              <input type="number" id="search" name="s" value="" size="20" maxlength="20" />      <input type="submit" value=" Afficher " name=" Afficher " class="bt" onclick = "transm()" />    <input type="submit" value="Rechercher" name="rechercher" class="bt" onclick="transm()" /></pre>  
           </form>   
           <% 
           Etudiant et = new Etudiant(request.getParameter("s"));        
           if(request.getParameter("s")!= null){        
              et = et.Afficher();   
           }%>    
               
      <table  width="90%" rules ="all"  cellpadding ="15" cellspacing = "10" id="tab" >   
        <tr id="l1"> 
          <th>CNE </th>
          <th>Nom  </th>   
          <th>Prénom</th>
          <th>Niveau</th>
        </tr>  
        <tr>
          <td><% if(request.getParameter("s")!= null)  out.print(et.getCNE());%></td>   
          <td><% if(request.getParameter("s")!= null)  out.print(et.getNom());%></td>
          <td><% if(request.getParameter("s")!= null)  out.print(et.getPrenom());%></td>
          <td><% if(request.getParameter("s")!= null)  out.print(et.getNiveau());%></td>      
        </tr>    
      </table> 
      </fieldset>    
    </div>    
</body>
</html>