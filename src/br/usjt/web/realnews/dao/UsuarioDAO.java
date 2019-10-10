package br.usjt.web.realnews.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.web.realnews.model.Usuario;

public class UsuarioDAO {

	Connection conexao;

	public int inserir(Usuario usuario) {
		String sqlInsert = "INSERT INTO usuario (email, nome, senha, adm) VALUES (?, ?, ?, ?)";
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setString(1, usuario.getEmail());
			stm.setString(2, usuario.getNome());
			stm.setString(3, usuario.getSenha());
			stm.setBoolean(4, usuario.getAdm());
			stm.execute();
			
			ResultSet rs = stm.getGeneratedKeys();
			if(rs.next()) {
				int idGerado = rs.getInt(1);
				return idGerado;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void alterar(Usuario usuario) {
		String sqlUpdate = "UPDATE usuario SET email=?, nome=?, senha=?, adm=? WHERE id=?";
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(sqlUpdate);
			stm.setString(1, usuario.getEmail());
			stm.setString(2, usuario.getNome());
			stm.setString(3, usuario.getSenha());
			stm.setBoolean(4, usuario.getAdm());
			stm.setInt(5, usuario.getId());
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM usuario WHERE id=?";
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(sqlDelete);
			stm.setInt(1, id);
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Usuario consultar(int id) {
		String sqlSelect = "SELECT id, email, nome, senha, adm FROM usuario WHERE id=?";
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(sqlSelect);
			stm.setInt(1, id);

			try (ResultSet rs = stm.executeQuery();) {
				if(rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt(1));
					usuario.setEmail(rs.getString(2));
					usuario.setNome(rs.getString(3));
					usuario.setSenha(rs.getString(4));
					usuario.setAdm(rs.getBoolean(5));
					return usuario;
				}
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.print(e.getStackTrace());
		}
		return null;
	}

	public ArrayList<Usuario> listarUsuarios() {
		String sqlSelect = "SELECT * FROM usuario";
		ArrayList<Usuario> lista = new ArrayList<>();
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(sqlSelect);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt(1));
				usuario.setEmail(rs.getString(2));
				usuario.setNome(rs.getString(3));
				usuario.setSenha(rs.getString(4));
				usuario.setAdm(rs.getBoolean(5));
				lista.add(usuario);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Usuario consultaLogin(Usuario usuario) {
		String sqlSelect = "SELECT * FROM usuario WHERE email = ?";
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(sqlSelect);
			stm.setString(1, usuario.getEmail());
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				Usuario usuario2 = new Usuario();
				usuario2.setId(rs.getInt(1));
				usuario2.setEmail(rs.getString(2));
				usuario2.setNome(rs.getString(3));
				usuario2.setSenha(rs.getString(4));
				usuario2.setAdm(rs.getBoolean(5));
				return usuario2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	public ArrayList<Usuario> listaNome(String nome) {
		String sqlSelect = "SELECT * FROM usuario WHERE nome LIKE '%?%'";
		ArrayList<Usuario> lista = new ArrayList<>();
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(sqlSelect);
			stm.setString(1, nome);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt(1));
				usuario.setEmail(rs.getString(2));
				usuario.setNome(rs.getString(3));
				usuario.setSenha(rs.getString(4));
				usuario.setAdm(rs.getBoolean(5));
				lista.add(usuario);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
