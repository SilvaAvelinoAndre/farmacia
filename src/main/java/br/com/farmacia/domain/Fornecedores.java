package br.com.farmacia.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="tb_fornecedores")
public class Fornecedores {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="for_id")
	private Long id;
	
	@Column(name="for_descricao", length =50, nullable =false)
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
