package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.util.JFSUtil;

@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {
	
	private Fornecedores fornecedores;
	
	
	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}

	private ListDataModel<Fornecedores> itens;

	public ListDataModel<Fornecedores> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Fornecedores> itens) {
		this.itens = itens;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			ArrayList<Fornecedores> lista = fdao.listar();
			itens = new ListDataModel<Fornecedores>(lista);
		} catch (SQLException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}
	public void prepararNovo() {
		fornecedores =  new Fornecedores();
	}
	
	public void novo() {
		
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.salvar(fornecedores);
			ArrayList<Fornecedores> lista = fdao.listar();
			itens = new ListDataModel<Fornecedores>(lista);
			
			JFSUtil.mensagemSucesso("Salvo com sucesso!!!");
		} catch (SQLException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}
	public void prepararExcluir() {
		fornecedores = itens.getRowData();
	}
	public void excluir() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.excluir(fornecedores);
			ArrayList<Fornecedores> lista = fdao.listar();
			itens = new ListDataModel<Fornecedores>(lista);
			
			JFSUtil.mensagemSucesso("Deletado com sucesso!!!");
		} catch (SQLException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}
	
}
