<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar</title>
</head>
<body>

	<h1>Alteração Dos Dados Do Usuário</h1>
	
	<form method="post" action="alterar">
	
	Codigo:<input type="text" name="txtcodigo" value="${usuario.codigo}"readonly><br><br>
	
	Nome:<input type="text" name="txtnome" value="${usuario.nome}"><br><br>
	Sobrenome:<input type="text" name="txtsobrenome" value="${usuario.sobrenome}"><br><br>
	
	Data Nascimento:<input type="date" name="txtdatanascimento"
	value="<fmt:formatDate value="${usuario.dataNascimento}" pattern="yyyy-MM-dd"/>"><br><br>
	
	
	Login:<input type="text" name="txtlogin" value="${usuario.login}"><br><br>
	Senha:<input type="password" name="txtsenha" value="${usuario.senha}"><br><br>
	Email:<input type="text" name="txtemail" value="${usuario.email}"><br><br>
	telefone:<input type="text" name="txtnome" value="${usuario.telefone}"><br><br>
	
	<input type="submit" value="Salvar"><br><br>
	</form>
</body>
</html>