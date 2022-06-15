package br.com.turma.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.turma.modelo.Usuario;
import br.com.turma.modelo.UsuarioDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String login= request.getParameter("txtlogin");
		String senha=request.getParameter("txtsenha");
		
		UsuarioDao usuarioDao=new UsuarioDao();
		Usuario usuario =usuarioDao.verificarLogin(login,senha);
		
		if(usuario!=null) {
			response.sendRedirect("mostrar");
			
		}else {
			response.sendRedirect("formlogin.html");
		}
	}
	

}
