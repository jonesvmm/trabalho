<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>	Lista de produtos</title>
<a href="cadastroProduto.html"><button>Cadastrar Produto</button></a>
</head>
<body>
	<h1>Lista de Produto</h1>
		<c:if test="${not empty usuarios }">
		
		<table border="1" style="width: 40%">
				<thead>

				<tr style="background-color: black; color: white">
					<th>codigo_produto<th>
					<th>produto<th>
					<th>valor<th>
				
					
					<th colspan="1">Ação</th>

				<tr>
			<thead>
			<tbody>
				<c:forEach var="usuario" items="${usuarios }">
				<tr>
					<td>${usuario.codigo_produto}<td>
					<td>${usuario.produto}<td>
					<td>${usuario.valor}<td>
					
					
					<td><a href="formMostraUsuarios.jsp">Voltar</a></td>
				<tr>
					</c:forEach>
				
			</tbody>
		</table>
		</c:if>
		<c:if test="${empty usuarios }">
					<h4>Nenhum item Cadastrado!</h4>
		
		</c:if>	
</body>
</html>
