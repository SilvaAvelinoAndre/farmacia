package br.com.farmacia.domain;

public class Fornecedores {
	
	private Long id;
	private String descricao;
	
	
	public Fornecedores() {
		
	}


	public Fornecedores(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
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
	
	@Override
	public String toString() {
		return "Id do Fornecedor = " + id + ", Descricao = " + descricao + "!";
	}

}
