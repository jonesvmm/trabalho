package br.com.turma.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.turma.modelo.Usuario;
import br.com.turma.modelo.UsuarioDao;
@WebServlet("/mostrar")
public class MostrarUsuarioServlet extends HttpServlet {
@Override

protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	UsuarioDao usuarioDao = new UsuarioDao();
	ArrayList<Usuario>usuarios=usuarioDao.mostrarTodos();
	
	request.setAttribute("usuarios",usuarios);
	RequestDispatcher rd= request.getRequestDispatcher("/formMostraUsuarios.jsp");
	rd.forward(request, response);

}
}
