package br.edu.unidep.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unidep.model.Cliente;
import br.edu.unidep.repositorios.ClienteRepositorio;

public class ClienteDao implements ClienteRepositorio {

	@Override
	public List<Cliente> buscarTodos(EntityManager em) {
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		String sql = "select * from cliente";
		Query query = em.createNativeQuery(sql);
		
		@SuppressWarnings("unchecked")
		List<Object[]> clientesObject = query.getResultList();
		
		for (Object[] objects : clientesObject) {
			Cliente cliente = criarCliente(objects);
			clientes.add(cliente);
		}
		
		return clientes;
	}

	@Override
	public Cliente buscarPorId(EntityManager em, Long id) {
		
		return null;
	}

	@Override
	public void inserir(EntityManager em, Cliente cliente) {
		
	}

	@Override
	public void atualizar(EntityManager em, Cliente clienteAtualizado, Long id) {
		
	}

	@Override
	public void deletar(EntityManager em, Long id) {
		
	}
	
	public Cliente criarCliente(Object[] array) {
		BigInteger codigo = (BigInteger) array[0];
		return new Cliente(codigo.longValue(), (String) array[5], (Double) array[3], (java.util.Date) array[4], (String) array[2], (Boolean) array[1]);
	}
}
