package br.usjt.web.realnews.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	//MUDAR USER E SENHA!!!
	public static Connection conectar() throws SQLException {
		String url = "jdbc:mysql://localhost/webjornal?useSSL=false&&useTimezone=true&serverTimezone=UTC";
		String user = "";
		String senha = "";
		return DriverManager.getConnection(url, user, senha);
	}

	public static void desconectar(Connection conexao) throws SQLException {
		conexao.close();
	}

}
