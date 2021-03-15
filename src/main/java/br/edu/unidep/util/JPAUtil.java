package br.edu.unidep.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/* Nessa classe sera realizada a criaçao da comunicaçao com o BD (Fábrica de conexão*/
public class JPAUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoJPA");
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	
	
	
}
