package br.edu.unidep.repositorios;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unidep.model.Cliente;

public interface ClienteRepositorio {
	
	List<Cliente> buscarTodos(EntityManager em);
	Cliente buscarPorId(EntityManager em, Long id);
	void inserir(EntityManager em, Cliente cliente);
	void atualizar(EntityManager em, Cliente clienteAtualizado, Long id);
	void deletar(EntityManager em, Long id);
}
