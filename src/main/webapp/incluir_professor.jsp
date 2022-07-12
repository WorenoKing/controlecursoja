<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="IncluirProfessor">
	
		<input type="text" name="nome"
				required
		       placeholder="Nome do professor"/>
		       
		<input type="text" name="celular"
				required
		       placeholder="contato professor"/>
		
		<input type="number" name="valorhora"
		       step="0.01" required
		       placeholder="Valor hora professor" />
		
		<input type="submit" value="Ok" />
		<input type="reset" value="Limpar" />
	</form>
</body>
</html>