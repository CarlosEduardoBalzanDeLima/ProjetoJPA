package br.edu.unidep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "titular")
	private String titular;

	@Column(name = "saldo_conta")
	private double saldoConta;

	public Conta() {
		super();
	}

	public Conta(Long codigo, String titular, double saldoConta) {
		super();
		this.codigo = codigo;
		this.titular = titular;
		this.saldoConta = saldoConta;
	}

	public Conta(String titular, double saldoConta) {
		super();
		this.titular = titular;
		this.saldoConta = saldoConta;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldoConta() {
		return saldoConta;
	}

	public void setSaldoConta(double saldoConta) {
		this.saldoConta = saldoConta;
	}

	@Override
	public String toString() {
		return "Conta [codigo=" + codigo + ", titular=" + titular + ", saldoConta=" + saldoConta + "]";
	}

}
