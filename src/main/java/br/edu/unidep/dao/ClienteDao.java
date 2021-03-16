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
		List<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "select * from cliente where codigo = :id";
		Query query = em.createNativeQuery(sql);
		query.setParameter("id", id);
		
		@SuppressWarnings("unchecked")
		List<Object[]> clientesObject = query.getResultList();
		
		for (Object[] objects : clientesObject) {
			Cliente conta = criarCliente(objects);
			clientes.add(conta);
		}
		
		return clientes.get(0);
	}

	@Override
	public void inserir(EntityManager em, Cliente cliente) {
		String sql = "insert into cliente (nome_cliente, cpf, data_nascimento, cidade, ativo) values (:nome, :cpf, :data, :cidade, :ativo)";
		Query query = em.createNativeQuery(sql);
		query.setParameter("nome", cliente.getNome());
		query.setParameter("cpf", cliente.getCpf());
		query.setParameter("data", cliente.getDataAniversario());
		query.setParameter("cidade", cliente.getCidade());
		query.setParameter("ativo", cliente.getAtivo());
		query.executeUpdate();
	}

	@Override
	public void atualizar(EntityManager em, Cliente clienteAtualizado, Long id) {
		Cliente cliente = buscarPorId(em, id);
		String sql = "update cliente set nome_cliente = :nome, cpf = :cpf, data_nascimento = :data, cidade = :cidade, ativo = :ativo where codigo = :id";
		Query query = em.createNativeQuery(sql);
		query.setParameter("nome", clienteAtualizado.getNome());
		query.setParameter("cpf",  clienteAtualizado.getCpf());
		query.setParameter("data", clienteAtualizado.getDataAniversario());
		query.setParameter("cidade", clienteAtualizado.getCidade());
		query.setParameter("ativo", clienteAtualizado.getAtivo());
		query.setParameter("id", cliente.getCodigo());
		query.executeUpdate();
	}

	@Override
	public void deletar(EntityManager em, Long id) {
		String sql = "delete from cliente where codigo = :id";
		Query query = em.createNativeQuery(sql);
		query.setParameter("id", id);
		query.executeUpdate();
	}
	
	public Cliente criarCliente(Object[] array) {
		java.sql.Date dataSql = (java.sql.Date) array[4];
		BigInteger codigo = (BigInteger) array[0];
		return new Cliente(codigo.longValue(), (String) array[5], (Double) array[3], dataSql.toLocalDate(), (String) array[2], (Boolean) array[1]);
	}
}
