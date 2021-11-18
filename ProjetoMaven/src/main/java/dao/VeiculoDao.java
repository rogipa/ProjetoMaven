package dao;

import javax.persistence.EntityManager;

import basica.Veiculo;

public class VeiculoDao {
	
	EntityManager em = GetEntityManager.getConnectionJpa();
	
	public void adicionar(Veiculo v) {
		
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		
	}
	
	public Veiculo buscarId(int id) {
		return em.find(Veiculo.class, id);
	}
	
	public void atualizar(Veiculo v) {
		
		em.getTransaction().begin();
		
		em.merge(v);
		
		em.getTransaction().commit();
		
	}

}
