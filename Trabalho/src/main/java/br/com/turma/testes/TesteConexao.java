package br.com.turma.testes;

import java.sql.SQLException;


import br.com.turma.jdbc.Conexao;

public class TesteConexao {

	public static void main(String[] args) throws SQLException  {
		Conexao.obterConexao();
	}

}
