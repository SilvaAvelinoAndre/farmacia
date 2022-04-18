package br.com.farmacia.domain;

public class Produtos {
	
	private Long id;
	private String descricao;
	private Long quantidade;
	private Double preco;
	private Fornecedores fornecedores = new Fornecedores();
	
	
	public Produtos() {
		
	}


	public Produtos(Long id, String descricao, Long quantidade, Double preco, Fornecedores fornecedores) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.fornecedores = fornecedores;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Long getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public Fornecedores getFornecedores() {
		return fornecedores;
	}


	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}


	
}
