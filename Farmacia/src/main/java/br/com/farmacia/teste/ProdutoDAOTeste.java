package br.com.farmacia.teste;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;

public class ProdutoDAOTeste {
	
	@Test
	@Ignore
	public void salvar() throws SQLException {	
	
	Produtos p1 = new Produtos();
	p1.setDescricao("Xarope");
	p1.setPreco(25.79);
	p1.setQuantidade(25L);
	
	Fornecedores f = new Fornecedores();
	f.setId(41L);
	p1.setFornecedores(f);
	
	ProdutoDAO pdao = new ProdutoDAO();
	pdao.salvar(p1);
	
	}
	
	@Test
	@Ignore
	public void listar() throws SQLException {
		ProdutoDAO pdao = new ProdutoDAO();
		
		ArrayList<Produtos> lista = pdao.listar();
		
		for(Produtos p : lista) {
			System.out.println("Id do Produto " + p.getId());
			System.out.println("Descri??o do Produto " + p.getDescricao());
			System.out.println("Quantidade do Produto " + p.getQuantidade());
			System.out.println("Pre?o do Produto " + p.getPreco());
			System.out.println("Id do Fornecedor " + p.getFornecedores().getId());
			System.out.println("Descri??o do Fornecedor " + p.getFornecedores().getDescricao());
			System.out.println("");
		}
	}
	@Test
	@Ignore
	public void excluir() throws SQLException {
		Produtos p = new Produtos();
		p.setId(8L);
		
		ProdutoDAO pdao = new ProdutoDAO();
		pdao.excluir(p);
		
		
		
	}
	
	@Test
	public void editar() throws SQLException {
		Produtos p = new Produtos();
		p.setId(7L);
		p.setDescricao("Ranitidina");
		p.setQuantidade(10L);
		p.setPreco(15.90);
		
		Fornecedores f = new Fornecedores();
		f.setId(39L);
		p.setFornecedores(f);
		
		ProdutoDAO pdao = new ProdutoDAO();
		pdao.editar(p);
		
		
		
	}
	
}
