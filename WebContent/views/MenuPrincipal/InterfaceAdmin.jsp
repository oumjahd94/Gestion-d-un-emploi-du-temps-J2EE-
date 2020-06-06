<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ page import ="java.util.Iterator " %>    
<%@ page import ="java.sql.Connection" %> 
<%@ page import ="java.sql.DriverManager" %> 
<%@ page import ="java.sql.ResultSet" %>   
<%@ page import ="com.mysql.jdbc.PreparedStatement" %>  
<%@ page import= "Modele.Matière" %>   
<%@ page import="java.util.ArrayList" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>La gestion d'EDT en ESTG</title>  
<link type="text/css" rel="stylesheet" href="<c:url value ="/css/index.css"/>" />      
</head>   
<body>
    <div id="d1" ><pre>      <img src ="<c:url value= "/img/milieu.jpg"/>" width ="58%" height ="30%" /></pre></div>
	<div id="d2"><img src ="<c:url value ="/img/ai.JPG"/>" width="100%" /></div>       
	<div id="d3"><pre><img src ="<c:url value="/img/logo.JPG"/>" width="70%"/>
	</pre></div>  
	   <br /><br /><br /><br /><br /><br /> <hr/>       
    <div id="d4"> <br />
     <table border="0" rules="all" width ="100%" cellpadding ="6" >  
		    <tr >
		        <th id="t"> GENERATION D'UN EDT </th>     
		    </tr>     
     </table>  
    <fieldset class="f">
       <form action="" method="post"> 
          Année        <select class="sl" name="A" id="sl1">
            <option value="2011" selected>2011</option>
            <option value="2012">2012</option>
            <option value="2013">2013</option>
            <option value="2014">2014</option>   
            <option value="2015">2015</option>  
          </select><br/>
         Filière      <select class="sl" name="F" id="sl2">
            <option value="GI" >GI</option>
            <option value="TM">TM</option>
            <option value="MEER">MEER</option>
            <option value="IS" selected>IS</option>          
          </select><br/>
          Semestre     <select class="sl" name="S" id="sl3">   
            <option value="S1">S1</option>
            <option value="S2">S2</option>
            <option value="S3">S3</option>
            <option value="S4">S4</option> 
            <option value="S5" selected>S5</option> 
            <option value="S6">S6</option>        
          </select><br/><br />
          <input type="submit" value="Valider" name="sb" class="bt"/>     
       </form>   </fieldset>
      <br /><br />
       <table border="0" rules="all" width ="100%" cellpadding ="6" >  
		    <tr >
		        <th id="t"> LA MODIFICATION </th>     
		    </tr>     
     </table> 
     <fieldset class="f">
        <form action="" method="post">  
          La matière à transférer  <input type="text" name="mat" /><br />
          Le num de la séance      <input type="number" name="num"/> <br />
            <input type="submit" value="Valider" class="bt"/>  
       </form>
     </fieldset>

	</div>  
    <div id="d5">
  <center>
	  <a href="Module.jsp" target="_blank"><input type ="button" value="Module" class="btt"></a>
	  <a href="Filiere.jsp" target="_blank"><input type ="button" value="Filière" class="btt"></a>    
	  <a href="Enseignant.jsp" target="_blank"><input type ="button" value="Ensiegnant" class="btt"/></a>
	  <a href="Salle.jsp" target="_blank"><input type ="button" value="Salle"  class="btt"/></a>
      <a href="Etudiant.jsp" target="_blank"><input type ="button" value ="Etudiant" class="btt"/></a> 
      <a href="matiere.jsp" target="_blank"><input type ="button" value ="Matiere" class="btt"/></a>   
  </center>        
	<br /><br />  
<% 
    String s,f, a ;
    s=request.getParameter("S"); 
    f= request.getParameter("F"); 
    a=request.getParameter("A"); 
    int i=-1;    
  
if(s!=null && f!=null && a!=null)  {  
   if(s.equals("S3") &&  f.equals("GI") && a.equals("2015")){
	    i=0 ;    
   } 
   if(s.equals("S1") &&  f.equals("GI") && a.equals("2015")){
	    i=24 ;      
  } 
   if(s.equals("S6") &&  f.equals("GI") && a.equals("2015")){
	    i=48 ;       
 }  
}

   
   ArrayList<String> Ar = new ArrayList<String>(); 
   Matière M = new Matière();  
   Ar = M.retenir(); 

%>
     <% 
         String mat = request.getParameter("mat") ; 
         String n = request.getParameter("num") ;
         try{
         int num = Integer.parseInt(n); 
         if(mat!=null && n!=null){    
            if(Ar.get(num).equals("")){   
            	try {
        			Class.forName("com.mysql.jdbc.Driver");      
        			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
        			PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("UPDATE Matiere SET designation=? WHERE designation =?");     
        			cmd.setString(1,"");           
        			cmd.setString(2,mat);           
        			cmd.execute() ;              
        		}              
        		catch (Exception e) {     
        			e.printStackTrace();         
        		}  
            	try {
        			Class.forName("com.mysql.jdbc.Driver");      
        			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt","root","");  
        			PreparedStatement  cmd= (PreparedStatement) cn.prepareStatement("UPDATE Matiere SET designation=? WHERE IdMatiere =?");   
        			cmd.setString(1,mat);         
        			cmd.setInt(2,num);           
        			cmd.execute() ;              
        		}              
        		catch (Exception e) {     
        			e.printStackTrace();         
        		}      
            }     
            else{
            %>
            <script>alert('désolé cette séance est ocuppée');</script>      
            <% 
            }
         } }
     	catch (Exception e) {     
    		e.printStackTrace();         
    	}   
         %>
      

 <fieldset class="f1">  
    <table  border= "2px" width="90%" rules ="all"  cellpadding ="17" cellspacing = "30" id="tab" >
      		<tr id="entete" >
		        <th colspan="5"> EMPLOI DU TEMPS : <% out.print(request.getParameter("F"));%> -- <%  out.print(request.getParameter("S")); %>--<%  out.print(request.getParameter("A")); %> </th>   
		    </tr>                                 
	  <tr id="l1">  
	    <th >           </th>                 
	    <th>8h-------10h</th>
		<th>10h------12h</th>
		<th>2h-------4h</th>
		<th>4h-------6h</th>      
	  </tr>
	  <tr>
	    <th>Lundi</th>   
		<td><% if (i!=-1) { out.print(Ar.get(i));   %> <% } %></td>   
		<td><% if(i!=-1 ){ out.print(Ar.get(i+1)); %> <% } %> </td>
		<td><% if(i!=-1 ){ out.print(Ar.get(i+2)); %><% } %> </td>
		<td><% if(i!=-1 ){ out.print(Ar.get(i+3)); %><% } %></td>
	  </tr>
	  <tr>
	    <th>Mardi</th>
		<td><% if(i!=-1){ out.print(Ar.get(i+4)); %><% } %></td>     
		<td><% if(i!=-1 ){ out.print(Ar.get(i+5)); %><% } %></td>
		<td><% if(i!=-1 ){ out.print(Ar.get(i+6)); %><% } %></td>
		<td><% if(i!=-1 ){ out.print(Ar.get(i+7)); %><br /><% } %></td>
	  </tr>
	  <tr>
	    <th>Mercredi</th>  
		<td><% if(i!=-1 ){ out.print(Ar.get(i+8));  %><% } %></td>   
		<td><% if(i!=-1){ out.print(Ar.get(i+9));  %><% } %></td>
		<td><% if(i!=-1){ out.print(Ar.get(i+10)); %><% } %></td>
		<td><% if(i!=-1){ out.print(Ar.get(i+11)); %><% } %></td>  
	  </tr>
	  <tr>
	    <th>Jeudi</th>
		<td><% if(i!=-1){ out.print(Ar.get(i+12)); %><% } %></td>   
		<td><% if(i!=-1 ){ out.print(Ar.get(i+13)); %><% } %></td>
		<td><% if(i!=-1){ out.print(Ar.get(i+14)); %><% } %></td>
		<td><% if(i!=-1){ out.print(Ar.get(i+15)); %><% } %></td>  
	  </tr>
	  <tr>
	    <th>Verdredi</th>
		<td><% if(i!=-1){ out.print(Ar.get(i+16)); %><% } %></td>   
		<td><% if(i!=-1){ out.print(Ar.get(i+17)); %><% } %></td>
		<td><% if(i!=-1){ out.print(Ar.get(i+18)); %><% } %></td>
		<td><% if(i!=-1 ){ out.print(Ar.get(i+19)); %><% } %></td>
	  </tr>
	  <tr>
	    <th>Samedi</th>        
		<td><% if(i!=-1){ out.print(Ar.get(i+20)); %><% } %></td>   
		<td><% if(i!=-1){ out.print(Ar.get(i+21)); %><% } %></td>
		<td><% if(i!=-1){ out.print(Ar.get(i+22)); %><% } %></td>
		<td><% if(i!=-1){ out.print(Ar.get(i+23)); %><% } %></td>     
	  </tr>
	</table>    
	</fieldset>
	<br />
	</div>	            
   
</body>
</html>