package br.com.turma.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.turma.modelo.Produto;
import br.com.turma.modelo.Usuario;
import br.com.turma.modelo.UsuarioDao;

@WebServlet("/cadastroProduto")
public class cadastroProduto extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String produto = request.getParameter("txtproduto");
		Object valor=request.getParameter("txtvalor");
		
		Produto produtos =new Produto (produto,(Double) valor);
		
		UsuarioDao usuarioDao= new UsuarioDao();
		usuarioDao.cadastrarProduto(produtos);
		response.sendRedirect("mostrarProduto");	
		
	}
}