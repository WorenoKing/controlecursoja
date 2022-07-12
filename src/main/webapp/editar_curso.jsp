<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.cursosja.controlecursoja.model.entidade.Curso" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		Curso curso = (Curso) request.getAttribute("curso");
	%>
	<form method="post" action="AlterarCurso">
		<input type="hidden" name="id" 
		       value="<%= curso.getId() %>" />
		
		<input type="text" name="nome" required
		       value="<%= curso.getNome() %>" />
		
		<input type="number" name="mensalidade" step="0.01" required
			   value="<%= curso.getValor() %>" />
		
		<input type="submit" value="Editar" />
		
		<input type="reset" value="Limpar" />
		
	</form>
</body>
</html>