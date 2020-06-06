<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link type="text/css" rel="stylesheet" href="<c:url value="/css/fil.css" />" />   
</head>
<body>

     <div id="d1"><img src="<c:url value ="/img/entete.JPG" />" width ="100%" height ="100%" />  </div>  
      <div id="d2">   
             
	   <form  method="post" action=""> 
	      <table border="0" rules="all" width ="85.5%" cellpadding ="10" id="entete1">     
		    <tr >
		        <th> PARAMETRAGE DES FILIERES </th>   
		    </tr>   
         </table>       
	     <fieldset class="f1"> <br/>                                                       
              <label for="id">Code de la filière : </label>   
              <input type="number" id="id" name="f" value="" size="20" maxlength="60" />
              <br />
              <label for="nom">Intitulé de la filière : </label>     
              <input type="text" id="nom" name="i" value="" size="20" maxlength="20" /> 
              <br/><br />      
              <pre><input type="submit" value=" Ajouter  "  name="ajouter" class="bt" onclick="envoi()" />    <input type="submit" value=" Modifier " name="modifier" class="bt" onclick="envoi()"/>    <input type="submit" value="Supprimer" name="supprimer" class="bt" />     <input type="submit" value="Rechercher"  name="rechercher" class="bt" onclick="transmettre()"/></pre>    
              <br /> <font color ="#0a79b9 "> *avant de faire une opértion veuillez d'abord effectuer une recharche</font>           
              <br />       
              
	   </form>   
	   	  
     </div>        
     <div id="d3">
       <pre>
       
       
       
       <img src="<c:url value ="/img/f.jpg" />"  width ="100%" height ="100%" />         </pre>
     </div> <pre>      
     
     
     
     
     
     
     
     
     
  
     <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
     <div id="d4">
       <table border="0" rules="all" width ="60%" cellpadding ="10" id="entete2">  
		    <tr >
		        <th> LES INFORMATIONS SUR UNE FILIERE </th>     
		    </tr>   
       </table> 
      <fieldset class="f2">
            <form  method="post" action="">    
             <pre> Veuillez saisir Le code :                        <input type="number" id="search" name="s" value="" size="20" maxlength="20" />      <input type="submit" value=" Afficher " name=" Afficher " class="bt" transmettre() />    <input type="submit" value="Rechercher" name="rechercher" class="bt" onclick="transmettre()" /></pre>  
           </form>       
      <table  width="90%" rules ="all"  cellpadding ="15" cellspacing = "10" id="tab" >   
        <tr id="l1"> 
          <th>ID </th>
          <th>Intitulé</th>   
        </tr>  
        <tr>
          <td></td>
          <td></td>
        </tr>    
      </table>  
      </fieldset> 
     
    </div>    


</body>
</html>