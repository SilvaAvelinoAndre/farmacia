package br.com.farmacia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_produtos")
public class Produtos {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="pro_id")
	private Long id;
	
	@Column(name="pro_descricao")
	private String descricao;
	
	@Column(name="pro_quantidade")
	private Integer quantidade;
	
	@Column(name="pro_preco", length = 50, nullable = false, scale= 2, precision= 10 )
	private Double preco;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tb_forncedores_for_id", referencedColumnName = "for_id", nullable = false)
	private Fornecedores fornecedores; 
	
	
	public Produtos() {
		
	}


	public Produtos(Long id, String descricao, Integer quantidade, Double preco, Fornecedores fornecedores) {
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


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
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
