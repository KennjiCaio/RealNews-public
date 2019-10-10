package br.usjt.web.realnews.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.web.realnews.model.Noticia;

public class NoticiaDAO {

	Connection conexao;

	public void inserir(Noticia noticia) {
		String slqInsert = "INSERT INTO noticia (titulo, resumo, texto, arquivo, id_usuario) values (?, ?, ?, ?, ?)";
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(slqInsert);
			stm.setString(1, noticia.getTitulo());
			stm.setString(2, noticia.getResumo());
			stm.setString(3, noticia.getTexto());
			stm.setString(4, noticia.getArquivo());
			stm.setInt(5, noticia.getIdUsuario());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Noticia noticia) {
		String sqlUpdate = "UPDATE noticia SET titulo = ?, resumo = ?, texto = ?,  arquivo = ?, id_usuario = ? WHERE id = ?";
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(sqlUpdate);
			stm.setString(1, noticia.getTitulo());
			stm.setString(2, noticia.getResumo());
			stm.setString(3, noticia.getTexto());
			stm.setString(4, noticia.getArquivo());
			stm.setInt(5, noticia.getIdUsuario());
			stm.setInt(6, noticia.getId());
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM noticia WHERE id=?";
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(sqlDelete);
			stm.setInt(1, id);
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Noticia consultar(int id) {
		String sqlSelect = "SELECT * FROM noticia WHERE id=?";
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(sqlSelect);
			stm.setInt(1, id);

			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					Noticia noticia = new Noticia();
					noticia.setId(rs.getInt(1));
					noticia.setTitulo(rs.getString(2));
					noticia.setResumo(rs.getString(3));
					noticia.setTexto(rs.getString(4));
					noticia.setArquivo(rs.getString(5));
					noticia.setIdUsuario(rs.getInt(6));
					return noticia;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException ex) {
			System.out.print(ex.getStackTrace());
		}
		return null;
	}
	
	public ArrayList<Noticia> listarNoticias(){
		String sqlSelect="SELECT * FROM noticia";
		ArrayList<Noticia> lista = new ArrayList<>();
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(sqlSelect);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				Noticia noticia = new Noticia();
				noticia.setId(rs.getInt(1));
				noticia.setTitulo(rs.getString(2));
				noticia.setResumo(rs.getString(3));
				noticia.setTexto(rs.getString(4));
				noticia.setArquivo(rs.getString(5));
				noticia.setIdUsuario(rs.getInt(6));
				lista.add(noticia);
			}
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Noticia> listarNoticiasMin(){
		String sqlSelect="SELECT * FROM noticia ORDER BY id desc limit 6";
		ArrayList<Noticia> lista = new ArrayList<>();
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(sqlSelect);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				Noticia noticia = new Noticia();
				noticia.setId(rs.getInt(1));
				noticia.setTitulo(rs.getString(2));
				noticia.setResumo(rs.getString(3));
				noticia.setTexto(rs.getString(4));
				noticia.setArquivo(rs.getString(5));
				noticia.setIdUsuario(rs.getInt(6));
				lista.add(noticia);
			}
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Noticia> listarNoticiasNome(String titulo){
		String sqlSelect="SELECT * FROM noticia WHERE titulo LIKE '%?%'";
		ArrayList<Noticia> lista = new ArrayList<>();
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(sqlSelect);
			stm.setString(1, titulo);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				Noticia noticia = new Noticia();
				noticia.setId(rs.getInt(1));
				noticia.setTitulo(rs.getString(2));
				noticia.setResumo(rs.getString(3));
				noticia.setTexto(rs.getString(4));
				noticia.setArquivo(rs.getString(5));
				noticia.setIdUsuario(rs.getInt(6));
				lista.add(noticia);
			}
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}






