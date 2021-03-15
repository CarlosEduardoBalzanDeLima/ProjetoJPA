package br.edu.unidep.repositorios;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unidep.model.Conta;

public interface ContaRepositorio {
	
	List<Conta> buscarTodos(EntityManager em);
	Conta buscarPorId(EntityManager em, Long id);
	void inserir(EntityManager em, Conta conta);
	void atualizar(EntityManager em, Conta contaAtualizada, Long id);
	void deletar(EntityManager em, Long id);
	
}
