<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import ="java.sql.Connection" %>
<%@ page import ="java.sql.DriverManager" %>
<%@ page import ="java.sql.ResultSet" %>   
<%@ page import ="com.mysql.jdbc.PreparedStatement" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>L'intefrace d'inscription</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/css/insc.css"/>" />  
 <script  type="text/javascript">
   function valider(){
	   if(document.f1.n.value =="" ||  document.f1.p.value=="" || document.f1.c.value=="" || document.f1.e.value=="" ){
           return false;   
	   }
	   else{
		   return true ; 
	   }  
   }
   function envoi(){
	   if(document.f1.n.value =="" ||  document.f1.p.value=="" || document.f1.c.value=="" || document.f1.e.value==""){
                 alert("veuillez vérifier vos champs");  
	   }  
	   if(document.f1.p.value != document.f1.c.value){
		   alert("les mots de passe ne sont pas semblable");
	   }
	   
   }</script>           
</head>   
<body>
  <div id="d1"><img src="<c:url  value = "/img/entete.JPG"/>" width ="100%" height ="80%" />  </div>  
      <div id="d2">
       <form  method="post" action="" name="f1" onsubmit="return valider()">  
           <table border="0" rules="all" width ="99.7%" cellpadding ="10" id="entete">  
		    <tr >  
		        <th> INSCRIPTION </th>      
		    </tr>   
          </table>       
          <fieldset class="f">                                       
              <p>Vous pouvez vous inscrire via ce formulaire.</p>           
              <label for="email">Nom d'utilisateur</label>
              <input type="text" id="email" name="n" value="" size="20" maxlength="60" />
              <br />
              <label for="motdepasse">Mot de passe </label>     
              <input type="password" id="motdepasse" name="p" value="" size="20" maxlength="20" />
              <br />       
              <label for="confirmation">Confirmation du mot de passe </label>
              <input type="password" id="confirmation" name="c" value="" size="20" maxlength="20" /> 
              <br />
              <label for="nom">Adresse email </label>   
              <input type="email" id="nom" name="e" value="" size="20" maxlength="20" />
              <br />     
              <input type="submit" value="Inscription" name="Inscription" id="bt" onclick="envoi()"/>      
              <br />      
           </fieldset></form><br /><br /> <br /><br /></div>   
        <div id="d3"><img src="<c:url value="/img/Inscription.jpg"/>" width ="100%" height ="100%" /></div>         	          
   <%  if(request.getParameter("e")!="" && request.getParameter("p")!="" && request.getParameter("c")!="" && request.getParameter("n")!=""){ 
		
	   try{
	    Class.forName("com.mysql.jdbc.Driver");      
 		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
 		PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("INSERT INTO inscription values(?,?,?,?)");
		cmd.setString(1,request.getParameter("n"));    
		cmd.setString(2,request.getParameter("p"));    
		cmd.setString(3,request.getParameter("c"));     
		cmd.setString(4,request.getParameter("e"));     
 		cmd.execute();   
 		
 		
		 }              
	  catch (Exception e) {     
				e.printStackTrace();         
			}   
	   try{
		    Class.forName("com.mysql.jdbc.Driver");      
	 		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
	 		PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("INSERT INTO connection values(?,?)");
			cmd.setString(1,request.getParameter("n"));    
			cmd.setString(2,request.getParameter("p"));          
	 		cmd.execute();   
	 		
	 		
			 }              
		  catch (Exception e) {     
					e.printStackTrace();         
				}  
     }   
     %>                                                                
</body>  
</html>   