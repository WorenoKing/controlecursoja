<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.cursosja.controlecursoja.model.entidade.Professor" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		Professor professor = (Professor) request.getAttribute("professor");
	%>
	<form method="post" action="AlterarProfessor">
		<input type="hidden" name="id" 
		       value="<%= professor.getId() %>" />
		       
		<input type="text" name="nome" 
		       value="<%= professor.getNome() %>" />
		
		<input type="text" name="celular" required
		       value="<%= professor.getCelular() %>" />
		
		<input type="number" name="valorhora" step="0.01" required
			   value="<%= professor.getValorHora() %>" />
		
		<input type="submit" value="Editar" />
		
		<input type="reset" value="Limpar" />
		
	</form>
</body>
</html>