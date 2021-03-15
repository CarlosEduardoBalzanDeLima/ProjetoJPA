package br.edu.unidep.repositorios;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unidep.model.Produto;

public interface ProdutoRepositorio {
	
	List<Produto> buscarTodos(EntityManager em);
	Produto buscarPorId(EntityManager em, Long id);
	void inserir(EntityManager em, Produto produto);
	void atualizar(EntityManager em, Produto produtoAtualizado, Long id);
	void deletar(EntityManager em, Long id);
}
