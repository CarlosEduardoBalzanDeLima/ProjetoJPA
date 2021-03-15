package br.edu.unidep.repositorios;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unidep.model.Vendedor;

public interface VendedorRepositorio {
	
	List<Vendedor> buscarTodos(EntityManager em);
	Vendedor buscarPorId(EntityManager em, Long id);
	void inserir(EntityManager em, Vendedor vendedor);
	void atualizar(EntityManager em, Vendedor vendedorAtualizado, Long id);
	void deletar(EntityManager em, Long id);
}
