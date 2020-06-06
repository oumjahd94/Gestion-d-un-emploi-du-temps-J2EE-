<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/css/Acces.css"/>" /> 
</head>   
<body>
     
      <div id="d1"><img src="<c:url  value = "/img/entete.JPG"/>" width ="100%" height ="80%" />  </div>  
      <div id="d2"> 
         <table border="0" rules="all" width ="87%" cellpadding ="20" id="entete">  
		    <tr >
		        <th> ACCES A L'INTERFACE DE L'APPLICATION  </th>         
		    </tr>   
          </table>       
          <fieldset class="f1">   
          <pre>                                               
                <center><a href ="InterfaceLogin.jsp" target="_blank"><input type="button" value="Accéder à  l'interface login" class="bt"></a></center></pre>     
              <br />      
           </fieldset>            
       </div>   
</body>
</html>