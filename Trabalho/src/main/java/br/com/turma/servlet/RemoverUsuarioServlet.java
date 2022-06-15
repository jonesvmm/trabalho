package br.com.turma.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.turma.modelo.UsuarioDao;


@WebServlet("/excluir")
public class RemoverUsuarioServlet extends HttpServlet {

	@Override
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer codigo= Integer.valueOf(request.getParameter("codigo"));
		
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.remover(codigo);
		
		response.sendRedirect("mostrar");	

	}
	}


