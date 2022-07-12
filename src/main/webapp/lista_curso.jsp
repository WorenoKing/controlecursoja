<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.cursoja.controlecursoja.model.dao.CursoDao" %>
<%@ page import="br.com.cursoja.controlecursoja.model.entidade.Curso" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nossos Cursos</title>
</head>
<body>
	<jsp:include page="verificaSessao.jsp"></jsp:include>
	<a href="area_interna.jsp">Voltar a página anterior</a>
	<a href="incluir_curso.jsp">Cadastro de Cursos</a>
	<h1>Todos os Cursos</h1>
	<%
		String nomeBusca = "";
		if(request.getParameter("nomeBusca")!= null){
			nomeBusca = request.getParameter("nomeBusca");
		}
	%>
	<form method="post" action="lista_curso.jsp">
    	<input type="text" name="nomeBusca" value="<%=nomeBusca%>"/>
    	<input type="submit" value="Buscar"/>
	</form>
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Mensalidade</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
		<%
			CursoDao dao = new CursoDao();
			List<Curso> cursos = dao.listar(nomeBusca);
			DecimalFormat fmt = new DecimalFormat("###, ##0.00");
			String strValor = "";
			for (Curso c: cursos){
				strValor = fmt.format(c.getValor());
		%>
			<tr>
				<td><%= c.getNome() %></td>
				<td><%= strValor %></td>
				<td>
					<a href="IniciarAlterarCurso?id=<%= c.getId()%>">Alterar</a> 
					<a href="ExcluirCurso?id=<%= c.getId()%>" onclick="return confirm('Deseja realmente excluir esse registro?');">Excluir</a>
				</td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>