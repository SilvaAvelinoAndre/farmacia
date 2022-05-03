package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.util.JFSUtil;

@ManagedBean(name = "MBProdutos")
@ViewScoped
public class ProdutosBean {

	private Produtos produtos;
	private ArrayList<Produtos> itens;
	private ArrayList<Produtos> itensFiltrados;
	private ArrayList<Fornecedores> comboFornecedores;

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Produtos> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Produtos> itens) {
		this.itens = itens;
	}

	public ArrayList<Produtos> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Produtos> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public ArrayList<Fornecedores> getComboFornecedores() {
		return comboFornecedores;
	}

	public void setComboFornecedores(ArrayList<Fornecedores> comboFornecedores) {
		this.comboFornecedores = comboFornecedores;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			ProdutoDAO pdao = new ProdutoDAO();
			itens = pdao.listar();

		} catch (SQLException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}

	public void prepararNovo() {

		try {
			produtos = new Produtos();
			FornecedoresDAO fdao = new FornecedoresDAO();
			comboFornecedores = fdao.listar();
		} catch (SQLException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}

	public void novo() {

		try {
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.salvar(produtos);
			itens = pdao.listar();

			JFSUtil.mensagemSucesso("Salvo com sucesso!!!");
		} catch (SQLException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void excluir() {
		try {
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.excluir(produtos);
			itens = pdao.listar();
			
			
			JFSUtil.mensagemSucesso("Deletado com sucesso!!!");
		} catch (SQLException e) {
			JFSUtil.mensagemErro("Não é posssivel excluir um fornecedor que tenha um produto associado!!!");
			e.printStackTrace();
		}
	}
	public void prepararEditar() {

		try {
			produtos = new Produtos();
			FornecedoresDAO fdao = new FornecedoresDAO();
			comboFornecedores = fdao.listar();
		} catch (SQLException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public void editar() {
		try {
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.editar(produtos);
			itens = pdao.listar();
			
			
			JFSUtil.mensagemSucesso("Atualizado com sucesso!!!");
		} catch (SQLException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}

}
