package br.com.farmacia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_funcionarios")
public class Funcionarios {
	

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="fun_id")
	private Long id;
	
	@Column(name="fun_nome", length = 50, nullable = false )
	private String nome;
	
	@Column(name="fun_cpf", length = 14, nullable = false, unique = true )
	private String cpf;
	
	@Column(name="fun_senha", length = 50, nullable = false  )
	private String seha;
	
	@Column(name="fun_funcao", length = 50, nullable = false  )
	private String funcao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSeha() {
		return seha;
	}

	public void setSeha(String seha) {
		this.seha = seha;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	
	
}
