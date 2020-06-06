<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>      
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>L'interface d'identification</title>      
 <link type="text/css" rel="stylesheet" href="<c:url value="/css/login.css" />" /> 
 <script  type="text/javascript">
   function valider(){
	   if(document.f1.login.value =="" ||  document.f1.pwd.value=="" ){
           return false;   
	   }
	   else{
		   return true ; 
	   }  
   }
   function envoi(){
	   if(document.f1.login.value =="" ||  document.f1.pwd.value=="" ){
		   if(document.f1.login.value =="" &&  document.f1.pwd.value=="")
			   alert("les deux champs sont vides");
		   else if(document.f1.login.value =="" )
			   alert("le champs login est vide");
		   else
			   alert("le champs mot de passe est vide");
	   }  
   }
</script>     
</head>  
<body>
   <div id="d1"><img src="<c:url value ="/img/entete.JPG" />" width ="100%" height ="100%" />  </div>  
      <div id="d2">        
	   <form  method="post" action="../../ServletLogin" name="f1" onsubmit="return valider()"> 
	    <table border="0" rules="all" width ="99.7%" cellpadding ="10" id="entete">  
		    <tr >
		        <th> CONNEXION A VOTRE COMPTE </th>     
		    </tr>   
       </table>      
	     <fieldset id="f">            
         <label for="login">Login          </label><input type="text" name="login" placeholder ="admin" id="login"/><br />
         <label for="pwd">Mot de passe  </label><input type="password" name ="pwd" id="pwd"/><br />     
          <pre><input type ="submit" name ="ok" value =" Entrer " class ="i1" id="bt" onclick="envoi()" />   <input type="reset" name="pasOk" value ="Annuler" class ="i1" id="bt" /></pre>
		  Vous n'avez pas un compte d'utilisaeur :  <a href="inscription.jsp" target ="_blank">s'inscrire.</a>          
        </fieldset>         
	   </form>   
     </div>  
     <div id="d3"><img src="<c:url value = "/img/login.jpg"/>" width ="60%" height ="60%" align="right"/></div>   
</body>      
</html>