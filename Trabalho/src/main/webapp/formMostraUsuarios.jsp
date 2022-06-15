<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Usuários</title>
<a href="formCadastro.html"><button>Cadastrar Usuario</button></a>
<a href="formlogin.html"><button>sair</button></a>
<a href="produto.jsp"><button>tabela produtos</button></a>



</head>
<body>
	
	<h1>Lista de Usuários</h1>
			<c:if test="${not empty usuarios }">
		
		<table border="1" style="width: 80%">
			<thead>
				<tr style="background-color: black; color: white">
					<th>Codigo<th>
					<th>Nome<th>
					<th>sobrenome<th>
					<th>Data Nascimento<th>
					<th>Login<th>
					<th>senha<th>
					<th>email<th>
					<th>telefone<th>
					
					<th colspan="2">Ação</th>
				<tr>
			<thead>
			<tbody>
				<c:forEach var="usuario" items="${usuarios }">
				<tr>
					<td>${usuario.codigo}<td>
					<td>${usuario.nome}<td>
					<td>${usuario.sobrenome}<td>
					<td><fmt:formatDate value="${usuario.dataNascimento}" pattern="dd/MM/yyyy"/><td>
					<td>${usuario.login}<td>
					<td>${usuario.senha}<td>
					<td>${usuario.email}<td>
					<td>${usuario.telefone}<td>
					
					<td><a href="alterar?codigo=${usuario.codigo}">Alterar</a></td>
					<td><a href="excluir?codigo=${usuario.codigo}">Excluir</a></td>
				<tr>
					</c:forEach>
				
			</tbody>
		</table>
		</c:if>
		<c:if test="${empty usuarios }">
					<h4>Nenhum Usuário Cadastrado!</h4>
		
		</c:if>	
</body>
</html>