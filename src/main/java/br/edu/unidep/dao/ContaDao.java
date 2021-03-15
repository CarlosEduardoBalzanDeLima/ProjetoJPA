package br.edu.unidep.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unidep.model.Conta;
import br.edu.unidep.repositorios.ContaRepositorio;

public class ContaDao implements ContaRepositorio{

	@Override
	public List<Conta> buscarTodos(EntityManager em) {
		List<Conta> contas = new ArrayList<Conta>();
		
		String sql = "select * from conta";
		Query query = em.createNativeQuery(sql);
		
		@SuppressWarnings("unchecked")
		List<Object[]> contasObject = query.getResultList();
		
		for (Object[] objects : contasObject) {
			Conta conta = criarConta(objects);
			contas.add(conta);
		}
		
		return contas;
	}

	@Override
	public Conta buscarPorId(EntityManager em, Long id) {
		List<Conta> contas = new ArrayList<Conta>();
		String sql = "select * from conta where codigo = :id";
		Query query = em.createNativeQuery(sql);
		query.setParameter("id", id);
		
		@SuppressWarnings("unchecked")
		List<Object[]> contasObject = query.getResultList();
		
		for (Object[] objects : contasObject) {
			Conta conta = criarConta(objects);
			contas.add(conta);
		}
		
		return contas.get(0);
	}

	@Override
	public void inserir(EntityManager em, Conta conta) {
		String sql = "insert into conta (titular, saldo_conta) values (:tit, :saldo)";
		Query query = em.createNativeQuery(sql);
		query.setParameter("tit", conta.getTitular());
		query.setParameter("saldo", conta.getSaldoConta());
		query.executeUpdate();
	}

	@Override
	public void atualizar(EntityManager em, Conta contaAtualizada, Long id) {
		Conta conta = buscarPorId(em, id);
		String sql = "update conta set titular = :tit, saldo_conta = :saldo where codigo = :id";
		Query query = em.createNativeQuery(sql);
		query.setParameter("tit", contaAtualizada.getTitular());
		query.setParameter("saldo", contaAtualizada.getSaldoConta());
		query.setParameter("id", conta.getCodigo());
		query.executeUpdate();
	}

	@Override
	public void deletar(EntityManager em, Long id) {
		String sql = "delete from conta where codigo = :id";
		Query query = em.createNativeQuery(sql);
		query.setParameter("id", id);
		query.executeUpdate();
	}
	
	public Conta criarConta(Object[] array) {
		BigInteger codigo = (BigInteger) array[0];
		return new Conta(codigo.longValue(), (String) array[2], (Double) array[1]);
	}
	
	private void updateDados(Conta conta, Conta contaAtualizada) {
		conta.setTitular(contaAtualizada.getTitular());
		conta.setSaldoConta(contaAtualizada.getSaldoConta());
	}
}
