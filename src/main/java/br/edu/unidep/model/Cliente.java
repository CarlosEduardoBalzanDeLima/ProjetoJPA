package br.edu.unidep.model;

import java.time.LocalDate;

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
	
	@Column(name = "data_nascimento")
	private LocalDate dataAniversario;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "ativo")
	private Boolean ativo;

	public Cliente() {
		super();
	}

	public Cliente(Long codigo, String nome, Double cpf, LocalDate dataAniversario, String cidade, Boolean ativo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.dataAniversario = dataAniversario;
		this.cidade = cidade;
		this.ativo = ativo;
	}

	public Cliente(String nome, Double cpf, LocalDate dataAniversario, String cidade, Boolean ativo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataAniversario = dataAniversario;
		this.cidade = cidade;
		this.ativo = ativo;
	}

	
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getCpf() {
		return cpf;
	}

	public void setCpf(Double cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(LocalDate dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", dataAniversario=" + dataAniversario
				+ ", cidade=" + cidade + ", ativo=" + ativo + "]";
	}

	
}
