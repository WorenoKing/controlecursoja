<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.cursoja.controlecursoja.model.dao.CursoDao" %>
<%@ page import="br.com.cursoja.controlecursoja.model.entidade.Curso" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nossos Cursos</title>
</head>
<body>
	<h1>Todos os Cursos</h1>
	<table>
		<thead>
			<tr>
				<th>Nome </th>
				<th>Mensalidade </th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
		<%
			CursoDao dao = new CursoDao();
			List<Curso> cursos = dao.listar("");
			for (Curso c: cursos){
		%>
			<tr>
				<td><%= c.getNome() %></td>
				<td><%= c.getValor() %></td>
				<td>
					<a href="IniciarAlterarCurso?id=<%= c.getId()%>">Alterar</a> 
					<a href="ExcluirCurso?id=<%= c.getId()%>">Excluir</a>
				</td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>