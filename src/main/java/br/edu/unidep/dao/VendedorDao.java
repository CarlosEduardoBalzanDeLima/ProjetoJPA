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
		List<Vendedor> vendedores = new ArrayList<Vendedor>();
		String sql = "select * from vendedor where codigo = :id";
		Query query = em.createNativeQuery(sql);
		query.setParameter("id", id);
		
		@SuppressWarnings("unchecked")
		List<Object[]> vendedoresObject = query.getResultList();
		
		for (Object[] objects : vendedoresObject) {
			Vendedor vendedor = criarVendedor(objects);
			vendedores.add(vendedor);
		}
		
		return vendedores.get(0);	}

	@Override
	public void inserir(EntityManager em, Vendedor vendedor) {
		String sql = "insert into vendedor (nome, empresa, data_admissao, cpf, ativo) values (:nome, :empresa, :data, :cpf, :ativo)";
		Query query = em.createNativeQuery(sql);
		query.setParameter("nome", vendedor.getNome());
		query.setParameter("empresa", vendedor.getEmpresa());
		query.setParameter("data", vendedor.getDataAdmissao());
		query.setParameter("cpf", vendedor.getCpf());
		query.setParameter("ativo", vendedor.getAtivo());
		query.executeUpdate();
	}

	@Override
	public void atualizar(EntityManager em, Vendedor vendedorAtualizado, Long id) {
		Vendedor vendedor = buscarPorId(em, id);
		String sql = "update vendedor set nome = :nome, empresa = :empresa, data_admissao = :data, cpf = :cpf, ativo = :ativo where codigo = :id";
		Query query = em.createNativeQuery(sql);
		query.setParameter("nome", vendedorAtualizado.getNome());
		query.setParameter("empresa",  vendedorAtualizado.getEmpresa());
		query.setParameter("data", vendedorAtualizado.getDataAdmissao());
		query.setParameter("cpf", vendedorAtualizado.getCpf());
		query.setParameter("ativo", vendedorAtualizado.getAtivo());
		query.setParameter("id", vendedor.getCodigo());
		query.executeUpdate();
	}

	@Override
	public void deletar(EntityManager em, Long id) {
		String sql = "delete from vendedor where codigo = :id";
		Query query = em.createNativeQuery(sql);
		query.setParameter("id", id);
		query.executeUpdate();
	}

	public Vendedor criarVendedor(Object[] array) {
		java.sql.Date dataSql = (java.sql.Date) array[3];
		BigInteger codigo = (BigInteger) array[0];
		return new Vendedor(codigo.longValue(), (String) array[5], (String) array[4], dataSql.toLocalDate(), (Double) array[2], (Boolean) array[1]);
	}
}
