package br.edu.unidep.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/* Nessa classe sera realizada a cria�ao da comunica�ao com o BD (F�brica de conex�o*/
public class JPAUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoJPA");
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	
	
	
}
