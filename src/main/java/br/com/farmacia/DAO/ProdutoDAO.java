package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.factory.ConexaoFactory;

public class ProdutoDAO {

	public void salvar(Produtos p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO produtos ");
		sql.append("(descricao, preco, quantidade, fornecedores_idfornecedores) ");
		sql.append("VALUES (?,?,?,?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, p.getDescricao());
		comando.setDouble(2, p.getPreco());
		comando.setLong(3, p.getQuantidade());
		comando.setLong(4, p.getFornecedores().getId());
		comando.executeUpdate();

	}

	public void excluir(Produtos p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM produtos ");
		sql.append("WHERE idprodutos = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, p.getId());
		comando.executeUpdate();

	}

	public void editar(Produtos p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE produtos ");
		sql.append("SET descricao= ?, quantidade = ?, preco = ?, fornecedores_idfornecedores = ? ");
		sql.append("WHERE idprodutos= ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, p.getDescricao());
		comando.setLong(2, p.getQuantidade());
		comando.setDouble(3, p.getPreco());
		comando.setLong(4, p.getFornecedores().getId());
		comando.setLong(5, p.getId());
		comando.executeUpdate();

	}

	public Produtos buscarPorId(Produtos p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idprodutos, descricao ");
		sql.append("FROM produtos ");
		sql.append("WHERE idprodutos = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, p.getId());

		ResultSet resultado = comando.executeQuery();
		Produtos retorno = null;
		if (resultado.next()) {
			retorno = new Produtos();
			retorno.setId(resultado.getLong("idprodutos"));
			retorno.setDescricao(resultado.getString("descricao"));
		}
		return retorno;

	}

	public ArrayList<Produtos> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.idprodutos, p.descricao, p.preco, p.quantidade, f.idfornecedores, f.descricao ");
		sql.append("FROM produtos p ");
		sql.append("INNER JOIN fornecedores f ON f.idfornecedores = p.fornecedores_idfornecedores");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Produtos> lista = new ArrayList<Produtos>();

		while (resultado.next()) {
			Fornecedores f = new Fornecedores();	
			f.setId(resultado.getLong("f.idfornecedores"));
			f.setDescricao(resultado.getString("f.descricao"));
			
			Produtos p = new Produtos();
			p.setId(resultado.getLong("p.idprodutos"));
			p.setDescricao(resultado.getString("p.descricao"));
			p.setQuantidade(resultado.getInt("p.quantidade"));
			p.setPreco(resultado.getDouble("p.preco"));
			p.setFornecedores(f);
			lista.add(p);
		}
		return lista;
	}

	public ArrayList<Produtos> buscarPorDescricao(Produtos p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idprodutos, descricao ");
		sql.append("FROM produtos ");
		sql.append("WHERE descricao LIKE ? ");
		sql.append("ORDER BY descricao ASC ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, "%" + p.getDescricao() + "%");

		ResultSet resultado = comando.executeQuery();

		ArrayList<Produtos> lista = new ArrayList<Produtos>();

		while (resultado.next()) {
			Produtos item = new Produtos();
			item.setId(resultado.getLong("idprodutos"));
			item.setDescricao(resultado.getString("descricao"));
			lista.add(item);
		}
		return lista;

	}
}