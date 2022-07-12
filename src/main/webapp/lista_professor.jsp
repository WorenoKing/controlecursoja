<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.cursoja.controlecursoja.model.dao.ProfessorDao" %>
<%@ page import="br.com.cursoja.controlecursoja.model.entidade.Professor" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nossos Professores</title>
</head>
<body>
	<h1>Todos os Professores</h1>
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Celular</th>
				<th>Valor Hora</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
		<%
			ProfessorDao dao = new ProfessorDao();
			List<Professor> professor = dao.listar("");
			for (Professor p: professor){
		%>
			<tr>
				<td><%= p.getNome() %></td>
				<td><%= p.getCelular() %></td>
				<td><%= p.getValorHora() %></td>
				<td>
					<a href="IniciarAlterarProfessor?id=<%= p.getId()%>">Alterar</a> 
					<a href="ExcluirProfessor?id=<%= p.getId()%>">Excluir</a>
				</td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>