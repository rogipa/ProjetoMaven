package br.edu.ifba.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifba.basicas.Categoria;

public class CategoriaDao {
	
	EntityManager em = GetEntityManager.getConnectionJpa();
	
	public void adiciona(Categoria categoria) {
		
		em.getTransaction().begin();
		
			em.persist(categoria);
		
		em.getTransaction().commit();
		
	}
	
	public Categoria procurarCategoriaId(int id) {
		
		return em.find(Categoria.class, id);
		
	}
	
	public List<Categoria> listarCategorias(){
		
		return em.createQuery("select c from Categoria c", Categoria.class).getResultList();
		
	}
	
	public void atualizarCategoria(Categoria c) {
		
		em.getTransaction().begin();
			em.merge(c);
		em.getTransaction().commit();
		
	}
	
	public void removerCategoriaId(Categoria c) {
		
		em.getTransaction().begin();
			em.remove(c);
		em.getTransaction().commit();
		
	}
	
	public List<Categoria> procurarCategoriaNome(String nome) {
		
		TypedQuery<Categoria> query = em.createQuery("select c from Categoria c where c.nome like :n", Categoria.class);
		query.setParameter("n", "%" + nome + "%");
		
		return query.getResultList();
		
	}
	
	

}
