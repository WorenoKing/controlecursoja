<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Professores</title>
</head>
<body>
	<jsp:include page="verificaSessao.jsp"></jsp:include>
	<form method="post" action="IncluirProfessor">
		<input type="text" name="nomeprofessor" placeholder="Nome completo" required>
		<input type="text" name="celular" placeholder="Celular" required>
		<input type="number" name="valorhora" placeholder="Valor hora" step="0.01" required>
		<input type="submit" value="Ok">
		<input type="reset" value="Limpar">
	</form>
</body>
</html>