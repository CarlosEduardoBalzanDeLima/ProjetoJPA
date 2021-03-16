package br.edu.unidep.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vendedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "empresa")
	private String empresa;
	
	@Column(name = "data_admissao")
	private LocalDate dataAdmissao;
	
	@Column(name = "cpf")
	private Double cpf;
	
	@Column(name = "ativo")
	private Boolean ativo;

	public Vendedor() {
		super();
	}

	public Vendedor(Long codigo, String nome, String empresa, LocalDate dataAdmissao, Double cpf, Boolean ativo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.empresa = empresa;
		this.dataAdmissao = dataAdmissao;
		this.cpf = cpf;
		this.ativo = ativo;
	}

	public Vendedor(String nome, String empresa, LocalDate dataAdmissao, Double cpf, Boolean ativo) {
		super();
		this.nome = nome;
		this.empresa = empresa;
		this.dataAdmissao = dataAdmissao;
		this.cpf = cpf;
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

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Double getCpf() {
		return cpf;
	}

	public void setCpf(Double cpf) {
		this.cpf = cpf;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Vendedor [codigo=" + codigo + ", nome=" + nome + ", empresa=" + empresa + ", dataAdmissao="
				+ dataAdmissao + ", cpf=" + cpf + ", ativo=" + ativo + "]";
	}

	
	
	
}
