<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro dos Cursos</title>
</head>
<body>
	<form method="post" action="IncluirCurso">
		<input type="text" name="nomecurso" placeholder="Nome do curso" required>
		<input type="number" name="mensalidade" placeholder="Valor da mensalidade" step="0.01" required>
		<input type="submit" value="Ok">
		<input type="reset" value="Limpar">
	</form>
</body>
</html>