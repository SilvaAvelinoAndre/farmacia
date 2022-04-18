package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.util.JFSUtil;

@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {
	
	private Fornecedores fornecedores;
	private ArrayList<Fornecedores> itens;
	private ArrayList<Fornecedores> itensFiltrados;
	
	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}

	public ArrayList<Fornecedores> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Fornecedores> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Fornecedores> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(ArrayList<Fornecedores> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
		itens = fdao.listar();
			
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
			itens = fdao.listar();
			
			
			JFSUtil.mensagemSucesso("Salvo com sucesso!!!");
		} catch (SQLException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public void excluir() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.excluir(fornecedores);
			itens = fdao.listar();
			
			
			JFSUtil.mensagemSucesso("Deletado com sucesso!!!");
		} catch (SQLException e) {
			JFSUtil.mensagemErro("Não é posssivel excluir um fornecedor que tenha um produto associado!!!");
			e.printStackTrace();
		}
	}
	
	public void editar() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.editar(fornecedores);
			itens = fdao.listar();
			
			
			JFSUtil.mensagemSucesso("Atualizado com sucesso!!!");
		} catch (SQLException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}
	
}
