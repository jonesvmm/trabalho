package br.com.turma.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.turma.jdbc.Conexao;

public class UsuarioDao {
	public void cadastrar(Usuario usuario) {
		Connection con = Conexao.obterConexao();

		String sql = "INSERT INTO trabalho(nome,sobrenome,data_nascimento,login,senha,email,telefone) VALUES(?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getSobrenome());
			preparador.setDate(3, new Date(usuario.getDataNascimento().getTime()));
			preparador.setString(4, usuario.getLogin());
			preparador.setString(5, usuario.getSenha());
			preparador.setString(6, usuario.getEmail());
			preparador.setString(7, usuario.getTelefone());


			preparador.execute();
			con.close();
			System.out.println("Usuario cadastado!!");

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public ArrayList<Usuario> mostrarTodos() {

		Connection con = Conexao.obterConexao();
		ArrayList<Usuario> usuarios = new ArrayList<>();
		String sql = "SELECT * FROM trabalho";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setCodigo(resultado.getInt("codigo"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setSobrenome(resultado.getString("sobrenome"));
				usuario.setDataNascimento(new java.util.Date(resultado.getDate("data_nascimento").getTime()));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				usuario.setEmail(resultado.getString("email"));
				usuario.setTelefone(resultado.getString("telefone"));

				usuarios.add(usuario);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return usuarios;
	}

	public Usuario buscarPorCodigo(Integer codigo) {
		Connection con = Conexao.obterConexao();
		Usuario usuario = null;
		String sql = "SELECT * FROM trabalho WHERE codigo=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, codigo);
			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				usuario = new Usuario();
				usuario.setCodigo(resultado.getInt("codigo"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setSobrenome(resultado.getString("sobrenome"));
				usuario.setDataNascimento(new java.util.Date(resultado.getDate("data_nascimento").getTime()));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				usuario.setEmail(resultado.getString("email"));
				usuario.setTelefone(resultado.getString("telefone"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return usuario;

	}

	public void remover(Integer codigo) {
		Connection con = Conexao.obterConexao();
		String sql = "DELETE FROM trabalho WHERE codigo=?";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, codigo);
			preparador.execute();
			preparador.close();
			System.out.println("Usuario removido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Usuario usuario) {
		Connection con = Conexao.obterConexao();
		String sql = "UPDATE trabalho SET nome=?,sobrenome=?,data_nascimento=?,login=?,senha=?,email=?,telefone=? WHERE codigo=?";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getSobrenome());
			preparador.setDate(3, new Date(usuario.getDataNascimento().getTime()));
			preparador.setString(4, usuario.getLogin());
			preparador.setString(5, usuario.getSenha());
			preparador.setString(6, usuario.getEmail());
			preparador.setString(7, usuario.getTelefone());
			preparador.setInt(8, usuario.getCodigo());

			preparador.execute();
			preparador.close();

			System.out.println("Usuario alterado com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Usuario verificarLogin(String login, String senha) {

		Connection con = Conexao.obterConexao();
		String sql = "SELECT * FROM trabalho WHERE login=? and senha=?";
		Usuario usuario = null;

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, login);
			preparador.setString(2, senha);

			ResultSet rs = preparador.executeQuery();

			if (rs.next()) {
				usuario = new Usuario();
				usuario.setCodigo(rs.getInt("codigo"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSobrenome(rs.getString("sobrenome"));
				usuario.setDataNascimento(rs.getDate("data_nascimento"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefone(rs.getString("telefone"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}


public void cadastrarProduto(Produto produto) {
	Connection con = Conexao.obterConexao();

	String sql = "INSERT INTO produto(produto,valor) VALUES(?,?)";

	try {
		PreparedStatement preparador = con.prepareStatement(sql);
		preparador.setString(1, produto.getProdutos());
		preparador.setDouble(2, produto.getValor());


		preparador.execute();
		con.close();
		System.out.println("produto cadastrado!!");

	} catch (SQLException e) {
		e.printStackTrace();

	}
}

public ArrayList<Produto> mostrarTodosProdutos() {

	Connection con = Conexao.obterConexao();
	ArrayList<Produto> produtos = new ArrayList<>();
	String sql = "SELECT * FROM produto";

	try {
		PreparedStatement preparador = con.prepareStatement(sql);
		ResultSet resultado = preparador.executeQuery();

		while (resultado.next()) {
			Produto produto = new Produto();
			produto.setCodigo(resultado.getInt("codigo"));
			produto.setProdutos(resultado.getString("produtos"));
			produto.setValor(resultado.getDouble("valor"));
			
			produtos.add(produto);

		}
	} catch (SQLException e) {

		e.printStackTrace();
	}
	return produtos;
}






}


