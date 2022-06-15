package br.com.turma.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.turma.modelo.Usuario;
import br.com.turma.modelo.UsuarioDao;

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("txtnome");
		String sobrenome=request.getParameter("txtsobrenome");
		Date dataNascimento= converterParaDate(request.getParameter("txtdatanascimento"));
		String login = request.getParameter("txtlogin");
		String senha= request.getParameter("txtsenha");
		String email= request.getParameter("txtemail");
		String telefone=request.getParameter("txttelefone");
		
		Usuario usuario =new Usuario(nome,sobrenome,dataNascimento,login,senha,email,telefone);
		
		UsuarioDao usuarioDao= new UsuarioDao();
		usuarioDao.cadastrar(usuario);
		response.sendRedirect("mostrar");	
		
	}

	private Date converterParaDate(String dataComoString) {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		
		Date dataFormatada=null;
		
		try {
			 dataFormatada = sdf.parse(dataComoString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dataFormatada;
	}

	
	

}
