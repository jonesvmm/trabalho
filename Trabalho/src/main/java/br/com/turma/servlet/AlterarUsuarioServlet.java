package br.com.turma.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.turma.modelo.Usuario;
import br.com.turma.modelo.UsuarioDao;

@WebServlet("/alterar")

public class AlterarUsuarioServlet extends HttpServlet {
	Usuario usuario = null;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer codigo = Integer.valueOf(request.getParameter("codigo"));
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuario = usuarioDao.buscarPorCodigo(codigo);
		

		request.setAttribute("usuario", usuario);
		RequestDispatcher rd = request.getRequestDispatcher("/formAlterarUsuario.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer codigo = Integer.valueOf(request.getParameter("txtcodigo"));

		String nome = request.getParameter("txtnome");
		String sobrenome = request.getParameter("txtsobrenome");
		Date dataNascimento = converterParaDate(request.getParameter("txtdatanascimento"));
		String login = request.getParameter("txtlogin");
		String senha = request.getParameter("txtsenha");
		String email = request.getParameter("txtemail");
		String telefone = request.getParameter("txttelefone");

		Usuario usuario = new Usuario();
		usuario.setCodigo(codigo);
		usuario.setSobrenome(sobrenome);
		usuario.setNome(nome);
		usuario.setDataNascimento(dataNascimento);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setEmail(email);
		usuario.setTelefone(telefone);

		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.alterar(usuario);
		response.sendRedirect("mostrar");

	}

	private Date converterParaDate(String dataComoString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataFormatada = null;

		try {
			dataFormatada = sdf.parse(dataComoString);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return dataFormatada;

	}
}
