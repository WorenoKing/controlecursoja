<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="br.com.cursoja.controlecursoja.model.entidade.Professor" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editando Professores</title>
</head>
<body>
	<% 
		Professor professor = (Professor) request.getAttribute("professor");
		
	%>
	<form method="post" action="AlterarProfessor" >
		<input type="hidden" name="id" value="<%= professor.getId() %>">
		<input type="text" name="nome" value="<%= professor.getNome() %>" placeholder="Nome completo" required>
		<input type="text" name="celular" value="<%= professor.getCelular() %>" placeholder="Celular" required>
		<input type="number" name="valorhora" value="<%= professor.getValorHora() %>" placeholder="Valor Hora" step="0.01" required>
		<input type="submit" value="Editar">
		<input type="reset"  value="Limpar">
	</form>
</body>
</html>