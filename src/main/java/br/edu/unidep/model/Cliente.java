package br.edu.unidep.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "nome_cliente")
	private String nome;
	
	@Column(name = "cpf")
	private Double cpf;
	
	@Column(name = "data_nascimeto")
	private Date dataAniversario;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "ativo")
	private Boolean ativo;

	public Cliente() {
		super();
	}

	public Cliente(Long codigo, String nome, Double cpf, Date dataAniversario, String cidade, Boolean ativo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.dataAniversario = dataAniversario;
		this.cidade = cidade;
		this.ativo = ativo;
	}

	public Cliente(String nome, Double cpf, Date dataAniversario, String cidade, Boolean ativo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataAniversario = dataAniversario;
		this.cidade = cidade;
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", dataAniversario=" + dataAniversario
				+ ", cidade=" + cidade + ", ativo=" + ativo + "]";
	}

	
}
