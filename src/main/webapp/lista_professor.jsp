<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.cursosja.controlecursoja.model.dao.ProfessorDao" %>
<%@ page import="br.com.cursosja.controlecursoja.model.entidade.Professor" %>
<%@ page import="java.util.List" %>    
<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Lista de Professores</h1>
	
	<%
		String nomeBusca = "";
	
		if (request.getParameter("nomeBusca") != null){
			nomeBusca = request.getParameter("nomeBusca");
		}
	%>
	<form method="post" action="lista_professor.jsp">
		<input type="text" name="nomeBusca" value="<%= nomeBusca %>" />
		
		<input type="submit" value="Buscar" />
	</form>
	
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
			
			List<Professor> professores = dao.listar(nomeBusca);

			DecimalFormat fmt = new DecimalFormat("###,##0.00");
			String strValor = "";
			for (Professor c: professores) {
				ValorHora = fmt.format( c.getValorHora() ); 
			%>
			<tr>
				<td><%= c.getNome() %></td>
				<td><%= c.getCelular() %></td>
				<td><%= ValorHora %></td>
				<td>
					<a href="IniciarAlterarProfessor?id=<%= c.getId() %>">
						Alterar
					</a>
					<a href="ExcluirProfessor?id=<%= c.getId() %>"
						onclick="return confirm('Deseja excluir esse registro?'); ">
						Excluir
					</a>
				</td>
			</tr>
		
			<% } %>
		</tbody>
	</table>
</body>
</html>