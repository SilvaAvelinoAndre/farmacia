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
	public void salvar() {	
	
	Produtos p1 = new Produtos();
	p1.setDescricao("Aspirina");
	p1.setPreco(12.99);
	p1.setQuantidade(5L);
	
	Fornecedores f = new Fornecedores();
	f.setId(8);
	p1.setFornecedores(f);
	
//	Produtos p2 = new Produtos();
//	p2.setDescricao("Diclofenaco");

	ProdutoDAO pdao = new ProdutoDAO();
	
	try {
		pdao.salvar(p1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
	@Test
	@Ignore
	public void listar() throws SQLException {
		ProdutoDAO pdao = new ProdutoDAO();
		
		ArrayList<Produtos> lista = pdao.listar();
		
		for(Produtos p : lista) {
			System.out.println("Id do Produto " + p.getId());
			System.out.println("Descri��o do Produto " + p.getDescricao());
			System.out.println("Quantidade do Produto " + p.getQuantidade());
			System.out.println("Pre�o do Produto " + p.getPreco());
			System.out.println("Id do Fornecedor " + p.getFornecedores().getId());
			System.out.println("Descri��o do Fornecedor " + p.getFornecedores().getDescricao());
			System.out.println("");
		}
	}
	@Test
	@Ignore
	public void excluir() throws SQLException {
		Produtos p = new Produtos();
		p.setId(3L);
		
		ProdutoDAO pdao = new ProdutoDAO();
		pdao.excluir(p);
		
		
		
	}
	
}