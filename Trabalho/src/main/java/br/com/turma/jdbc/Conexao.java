package br.com.turma.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection obterConexao() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho?useTimezone=true&serverTimezone=UTC","root","root");
		System.out.println("Banco de Dados Conectado com sucesso!!");
		
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("Não foi possivel conectar ao banco de dados!!");
			e.printStackTrace();
		}
		return con;
		
	}


}
