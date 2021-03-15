package br.edu.unidep.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "disponivel_estoque")
	private Boolean disponivel;
	
	@Column(name = "quantidade")
	private Integer quantidade;
	
	@Column(name = "tipo_unidade")
	private String unidade;
	
	@Column(name = "validade")
	private Date dataValidade;

	public Produto() {
		super();
	}

	
	
	public Produto(Long codigo, String nome, Boolean disponivel, Integer quantidade, String unidade, Date dataValidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.disponivel = disponivel;
		this.quantidade = quantidade;
		this.unidade = unidade;
		this.dataValidade = dataValidade;
	}



	public Produto(String nome, Boolean disponivel, Integer quantidade, String unidade, Date dataValidade) {
		super();
		this.nome = nome;
		this.disponivel = disponivel;
		this.quantidade = quantidade;
		this.unidade = unidade;
		this.dataValidade = dataValidade;
	}



	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", disponivel=" + disponivel + ", quantidade="
				+ quantidade + ", unidade=" + unidade + ", dataValidade=" + dataValidade + "]";
	}
	
	
}
