package br.usjt.web.realnews.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.web.realnews.model.Comentario;
import br.usjt.web.realnews.model.Usuario;

public class ComentarioDAO {
	Connection conexao;

	public void inserir(Comentario comentario) {
		String slqInsert = "INSERT INTO comentario(idNoticia, idUsuario, texto) VALUES (?, ?, ?)";
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(slqInsert);
			stm.setInt(1, comentario.getIdNoticia());
			stm.setInt(2, comentario.getUsuario().getId());
			stm.setString(3, comentario.getTexto());
			stm.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Comentario comentario) {
		String sqlUpdate = "UPDATE comentario SET idNoticia = ?, idUsuario = ?, texto = ? WHERE id = ?";
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(sqlUpdate);
			stm.setInt(1, comentario.getIdNoticia());
			stm.setInt(2, comentario.getUsuario().getId());
			stm.setString(3, comentario.getTexto());
			stm.setInt(4, comentario.getId());
			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM comentario WHERE id=?";
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlDelete);
			ps.setInt(1, id);
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Comentario consultar(int idNoticia) {
		String sqlSelect = "SELECT id, idNoticia, idUsuario, texto FROM comentario WHERE idNoticia=?";
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(sqlSelect);
			stm.setInt(1, idNoticia);

			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					Comentario comentario = new Comentario();
					Usuario usuario = new Usuario();
					comentario.setId(rs.getInt(1));
					comentario.setIdNoticia(rs.getInt(2));
					usuario.setId(rs.getInt(3));
					comentario.setUsuario(usuario);
					comentario.setTexto(rs.getString(4));
					return comentario;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException ex) {
			System.out.print(ex.getStackTrace());
		}
		return null;
	}
	
	public ArrayList<Comentario> listarComentarios(int idNoticia) {
		String sqlSelect = "SELECT * FROM comentario WHERE idNoticia=?";
		ArrayList<Comentario> lista = new ArrayList<>();
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(sqlSelect);
			stm.setInt(1, idNoticia);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				Comentario comentario = new Comentario();
				Usuario usuario = new Usuario();
				comentario.setId(rs.getInt(1));
				comentario.setIdNoticia(rs.getInt(2));
				usuario.setId(rs.getInt(3));
				comentario.setUsuario(usuario);
				comentario.setTexto(rs.getString(4));
				lista.add(comentario);
			}
			return lista;
		} catch (SQLException ex) {
			System.out.print(ex.getStackTrace());
		}
		return null;
	}
	
	public int comentarioNoticia() {
		String sqlSelect = "SELECT idNoticia,\r\n" + 
				"COUNT(idNoticia) AS quantidade\r\n" + 
				"FROM comentario\r\n" + 
				"GROUP BY idNoticia\r\n" + 
				"order by quantidade desc limit 1;";
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(sqlSelect);

			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException ex) {
			System.out.print(ex.getStackTrace());
		}
		return -1;
	}

}






