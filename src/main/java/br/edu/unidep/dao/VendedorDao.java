package br.edu.unidep.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unidep.model.Vendedor;
import br.edu.unidep.repositorios.VendedorRepositorio;

public class VendedorDao implements VendedorRepositorio{

	@Override
	public List<Vendedor> buscarTodos(EntityManager em) {
		List<Vendedor> vendedores = new ArrayList<Vendedor>();
		
		String sql = "select * from vendedor";
		Query query = em.createNativeQuery(sql);
		
		@SuppressWarnings("unchecked")
		List<Object[]> vendedoresObject = query.getResultList();
		
		for (Object[] objects : vendedoresObject) {
			Vendedor vendedor = criarVendedor(objects);
			vendedores.add(vendedor);
		}
		
		return vendedores;
	}

	@Override
	public Vendedor buscarPorId(EntityManager em, Long id) {
		return null;
	}

	@Override
	public void inserir(EntityManager em, Vendedor vendedor) {
		
	}

	@Override
	public void atualizar(EntityManager em, Vendedor vendedorAtualizado, Long id) {
		
	}

	@Override
	public void deletar(EntityManager em, Long id) {
		
	}

	public Vendedor criarVendedor(Object[] array) {
		BigInteger codigo = (BigInteger) array[0];
		return new Vendedor(codigo.longValue(), (String) array[5], (String) array[4], (java.util.Date) array[3], (Double) array[2], (Boolean) array[1]);
	}
}
