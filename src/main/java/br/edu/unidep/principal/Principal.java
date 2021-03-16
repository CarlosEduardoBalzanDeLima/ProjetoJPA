package br.edu.unidep.principal;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unidep.dao.ClienteDao;
import br.edu.unidep.dao.ContaDao;
import br.edu.unidep.dao.ProdutoDao;
import br.edu.unidep.dao.VendedorDao;
import br.edu.unidep.model.Cliente;
import br.edu.unidep.model.Conta;
import br.edu.unidep.model.Produto;
import br.edu.unidep.model.Vendedor;
import br.edu.unidep.util.JPAUtil;

public class Principal {

	public static void main(String[] args) {
		
		Conta contaCarlos = new Conta("Carlos Eduardo", 250);
		Conta contaMateus = new Conta("Mateus", 200);
		
		LocalDate dataCliente = LocalDate.of(2021, 02, 15);
		Cliente clienteCarlos = new Cliente("Carlos", 16551165.32, dataCliente, "Coronel Vivida", true);
		Cliente clienteMateus = new Cliente("Mateus", 16551165.32, dataCliente, "Mariopolis", false);
		
		LocalDate dataVendedor = LocalDate.of(2021, 02, 15);
		Vendedor vendedorCarlos = new Vendedor("Jair Belo", "Sistem Logistics", dataVendedor, 26262622.01, true);
		Vendedor vendedorMateus = new Vendedor("Mateus Belo", "Sistem Logistics", dataVendedor, 26262622.01, false);
		
		
		
//		LocalDate dataCliente = LocalDate.of(2021, 02, 15);
//		Produto produtoNovo = new Produto("Coca cola", true, 100, "Litro", dataProduto);
		

		EntityManager em = new JPAUtil().getEntityManager();

		ContaDao contaDao = new ContaDao();
		ClienteDao clienteDao = new ClienteDao();
		VendedorDao vendedorDao = new VendedorDao();
		ProdutoDao produtoDao = new ProdutoDao();
		
		
		em.getTransaction().begin();
		
		
//		em.persist(contaCarlos);
//		contaDao.atualizar(em, contaMateus, 2L);		
//		contaDao.inserir(em, contaCarlos);		
//		contaDao.deletar(em, 3L);		
//		System.out.println(contaDao.buscarPorId(em, 1L));
//		List<Conta> contas = contaDao.buscarTodos(em);
//		
//		for (Conta conta : contas) {
//			System.out.println(conta);
//		}	
		
		
		em.persist(clienteCarlos);
//		clienteDao.deletar(em, 1L);
//		clienteDao.atualizar(em, clienteMateus, 1L);		
//		clienteDao.inserir(em, clienteMateus);		
//		System.out.println(clienteDao.buscarPorId(em, 2L));
//		List<Cliente> clientes = clienteDao.buscarTodos(em);		
//		for (Cliente cliente : clientes) {
//			System.out.println(cliente);
//		}
		
		
		
		em.persist(vendedorCarlos);
//		vendedorDao.deletar(em, 1L);
//		vendedorDao.atualizar(em, vendedorMateus, 1L);
//		vendedorDao.inserir(em, vendedorMateus);
//		System.out.println(vendedorDao.buscarPorId(em, 1L));
//		List<Vendedor> vendedores = vendedorDao.buscarTodos(em);
//		for (Vendedor vendedor : vendedores) {
//			System.out.println(vendedor);
//		}
		
//		em.persist(produtoNovo);
//		List<Produto> produtos = produtoDao.buscarTodos(em);
//		for (Produto produto : produtos) {
//			System.out.println(produto);
//		}

		
		em.getTransaction().commit();
		
		em.close();
	}
	
	
}