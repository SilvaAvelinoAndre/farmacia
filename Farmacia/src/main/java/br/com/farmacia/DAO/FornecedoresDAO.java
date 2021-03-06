package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.factory.ConexaoFactory;

public class FornecedoresDAO {

	public void salvar(Fornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedores ");
		sql.append("(descricao) ");
		sql.append("VALUES (?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.executeUpdate();

	}

	public void excluir(Fornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedores ");
		sql.append("WHERE idfornecedores = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getId());
		comando.executeUpdate();

	}

	public void editar(Fornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fornecedores ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE idfornecedores = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setLong(2, f.getId());
		comando.executeUpdate();

	}

	public Fornecedores buscarPorId(Fornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idfornecedores, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE idfornecedores = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getId());

		ResultSet resultado = comando.executeQuery();
		Fornecedores retorno = null;
		if (resultado.next()) {
			retorno = new Fornecedores();
			retorno.setId(resultado.getLong("idfornecedores"));
			retorno.setDescricao(resultado.getString("descricao"));
		}
		return retorno;

	}

	public ArrayList<Fornecedores> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idfornecedores, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("ORDER BY descricao ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();

		while (resultado.next()) {
			Fornecedores f = new Fornecedores();
			f.setId(resultado.getLong("idfornecedores"));
			f.setDescricao(resultado.getString("descricao"));
			lista.add(f);
		}
		return lista;
	}

	public ArrayList<Fornecedores> buscarPorDescricao(Fornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idfornecedores, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE descricao LIKE ? ");
		sql.append("ORDER BY descricao ASC ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, "%" + f.getDescricao() + "%");

		ResultSet resultado = comando.executeQuery();

		ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();

		while (resultado.next()) {
			Fornecedores item = new Fornecedores();
			item.setId(resultado.getLong("idfornecedores"));
			item.setDescricao(resultado.getString("descricao"));
			lista.add(item);
		}
		return lista;

	}

	public static void main(String[] args) {
		
		Fornecedores f1 = new Fornecedores();
		f1.setDescricao("inser??o para teste 9");
		Fornecedores f2 = new Fornecedores();
		f2.setDescricao("DESCRI??O 6");

		FornecedoresDAO fdao = new FornecedoresDAO();
		try {
			fdao.salvar(f1);
			fdao.salvar(f2);
			System.out.println("Salvo com sucesso!!!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao salvar!!!");
		}
		 

		/*
		 * Fornecedores f1 = new Fornecedores(); f1.setId(2);
		 * 
		 * FornecedoresDAO fdao = new FornecedoresDAO(); try { fdao.excluir(f1);
		 * 
		 * System.out.println("Deletado com sucesso!!!"); } catch (SQLException e) {
		 * e.printStackTrace(); System.out.println("Erro ao deletar!!!"); }
		 */

		/*
		 * Fornecedores f1 = new Fornecedores(); f1.setId(1);
		 * f1.setDescricao("teste de edi??o");
		 * 
		 * FornecedoresDAO fdao = new FornecedoresDAO(); try { fdao.editar(f1);
		 * 
		 * System.out.println("Atualizado com sucesso!!!"); } catch (SQLException e) {
		 * e.printStackTrace(); System.out.println("Falha ao atualizar!!!"); }
		 */

		/*
		 * Fornecedores f1 = new Fornecedores(); f1.setId(1); Fornecedores f2 = new
		 * Fornecedores(); f2.setId(5);
		 * 
		 * FornecedoresDAO fdao = new FornecedoresDAO(); try { Fornecedores f3 =
		 * fdao.buscarPorId(f1); Fornecedores f4 = fdao.buscarPorId(f2);
		 * System.out.println("Resultado 1: " + f3); System.out.println("Resultado 2: "
		 * + f4); } catch (SQLException e) { e.printStackTrace();
		 * System.out.println("Resultado n?o encontrado!!!"); }
		 */
		/*
		 * FornecedoresDAO fdao = new FornecedoresDAO(); 
		 * try {
		 *  ArrayList<Fornecedores>
		 * lista = fdao.listar(); for(Fornecedores f : lista) {
		 * System.out.println("Resultado: " + f); }
		 * 
		 * 
		 * } catch (SQLException e) { 
		 * e.printStackTrace();
		 * System.out.println("Resultado n?o encontrado!!!"); }
		 */
		/*
		Fornecedores f1 = new Fornecedores();
		f1.setDescricao("tes");
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		try {
			ArrayList<Fornecedores> lista = fdao.buscarPorDescricao(f1);
			for(Fornecedores f : lista) {
				System.out.println("Resultado " + f);
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Falha ao buscar!!!");
		}*/
			
		
		
		
	
		
		
	}
}
