package dao;

import javax.persistence.EntityManager;

import basica.Endereco;

public class EnderecoDao {
	
	EntityManager em = GetEntityManager.getConnectionJpa();
	
	public Endereco buscarId(int id) {
		return em.find(Endereco.class, id);
	}
	
	public void atualizarEndereco(Endereco e) {
		
		em.getTransaction().begin();
		
			em.merge(e);
			
		em.getTransaction().commit();
		
	}

}
