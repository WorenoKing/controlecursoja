<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.cursoja.controlecursoja.model.entidade.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard CursoJá</title>
</head>
<body>
	<jsp:include page="verificaSessao.jsp"></jsp:include>
	<%
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
	%>
	<h1>Olá, <%= usuario.getNome() %></h1>
	<br>
	<a href="lista_curso.jsp">Nossos Cursos</a>
	<br>
	<a href="lista_professor.jsp">Nossos Professores</a>
	<br>
	<a href="incluir_turma.jsp">Nossas Turmas</a>
	<br>
	<a href="LogoutServlet">Sair</a>
</body>
</html>