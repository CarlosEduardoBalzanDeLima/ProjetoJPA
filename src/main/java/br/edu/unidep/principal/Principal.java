package br.edu.unidep.principal;

import java.util.Date;
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
		
		Date dataCliente = new Date();
		dataCliente.setDate(12);
		dataCliente.setMonth(02);
		dataCliente.setYear(1912);
		Cliente clienteCarlos = new Cliente("Carlos", 16551165.32, dataCliente, "Coronel Vivida", true);
		
		Date dataVendedor = new Date();
		dataVendedor.setDate(12);
		dataVendedor.setMonth(02);
		dataVendedor.setYear(1912);
		Vendedor vendedorCarlos = new Vendedor("Jair Belo", "Sistem Logistics", dataVendedor, 26262622.01, true);
		
		Date dataProduto = new Date();
		dataProduto.setDate(12);
		dataProduto.setMonth(02);
		dataProduto.setYear(1912);
		Produto produtoNovo = new Produto("Coca cola", true, 100, "Litro", dataProduto);
		

		EntityManager em = new JPAUtil().getEntityManager();

		ContaDao contaDao = new ContaDao();
		ClienteDao clienteDao = new ClienteDao();
		VendedorDao vendedorDao = new VendedorDao();
		ProdutoDao produtoDao = new ProdutoDao();
		
		
		em.getTransaction().begin();
		
		contaDao.atualizar(em, contaMateus, 2L);
		
//		contaDao.inserir(em, contaCarlos);
		
//		contaDao.deletar(em, 3L);
		
		
//		em.persist(contaCarlos);
//		List<Conta> contas = contaDao.buscarTodos(em);
//		
//		for (Conta conta : contas) {
//			System.out.println(conta);
//		}	
		
//		em.persist(clienteCarlos);		
//		List<Cliente> clientes = clienteDao.buscarTodos(em);
//		
//		for (Cliente cliente : clientes) {
//			System.out.println(cliente);
//		}
		
//		em.persist(vendedorCarlos);
//		List<Vendedor> vendedores = vendedorDao.buscarTodos(em);
//		for (Vendedor vendedor : vendedores) {
//			System.out.println(vendedor);
//		}
		
//		em.persist(produtoNovo);
//		List<Produto> produtos = produtoDao.buscarTodos(em);
//		for (Produto produto : produtos) {
//			System.out.println(produto);
//		}

		
//		Vendedor vendedorMateus = em.find(Vendedor.class, 1L);
//		System.out.println(vendedorMateus);
			
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	
}