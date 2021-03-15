package br.edu.unidep.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unidep.model.Produto;
import br.edu.unidep.repositorios.ProdutoRepositorio;

public class ProdutoDao implements ProdutoRepositorio{

	@Override
	public List<Produto> buscarTodos(EntityManager em) {
		List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "select * from produto";
		Query query = em.createNativeQuery(sql);
		
		@SuppressWarnings("unchecked")
		List<Object[]> produtosObject = query.getResultList();
		
		for (Object[] objects : produtosObject) {
			Produto produto = criarProduto(objects);
			produtos.add(produto);
		}
		
		return produtos;
	}

	@Override
	public Produto buscarPorId(EntityManager em, Long id) {
		return null;
	}

	@Override
	public void inserir(EntityManager em, Produto produto) {
		
	}

	@Override
	public void atualizar(EntityManager em, Produto produtoAtualizado, Long id) {
		
	}

	@Override
	public void deletar(EntityManager em, Long id) {
		
	}
	
	public Produto criarProduto(Object[] array) {
		BigInteger codigo = (BigInteger) array[0];
		return new Produto(codigo.longValue(), (String) array[3], (Boolean) array[2], (Integer) array[4], (String) array[5], (java.util.Date) array[1]);
	}
}
