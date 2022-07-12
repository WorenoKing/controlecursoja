<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.cursoja.controlecursoja.model.dao.CursoDao" %>    
<%@ page import="br.com.cursoja.controlecursoja.model.entidade.Curso" %>  
<%@ page import="br.com.cursoja.controlecursoja.model.dao.ProfessorDao" %>    
<%@ page import="br.com.cursoja.controlecursoja.model.entidade.Professor" %>  
<%@ page import="java.util.List" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Turmas CursoJá</title>
</head>
<body>
	<jsp:include page="verificaSessao.jsp"></jsp:include>
	<form method="post" action="IncluirTurma">
		<select name="curso" required>
		<% 
			CursoDao dao = new CursoDao();
			List<Curso> lista = dao.listar("");
			for(Curso c: lista){
		%>
			<option value="<%= c.getId() %>"><%= c.getNome() %></option>
		<% } %>
		</select>
		<select name="professor" required>
		<%
		ProfessorDao dao1 = new ProfessorDao();
		List<Professor> lista1 = dao1.listar("");
		for(Professor p: lista1){
		%>
		<option value="<%= p.getId() %>"><%= p.getNome() %></option>
		<% } %>
		</select>
		<input type="date" name="inicio" placeholder="Data de Início" required>
		<input type="date" name="fim" placeholder="Data de Término" required>
		<input type="submit" value="Enviar">
		<input type="reset" value="Limpar">
	</form>
</body>
</html>