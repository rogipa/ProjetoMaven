package br.edu.ifba.regranegocios;

import java.util.List;

import br.edu.ifba.basicas.Categoria;
import br.edu.ifba.dao.CategoriaDao;

public class CategoriaRn {
	
	CategoriaDao c = new CategoriaDao();
	
	public void adicionarCategoria(Categoria categoria) throws CategoriaJaCadastradaException {
		
		List<Categoria> lista = c.listarCategorias();
		
		for(Categoria temp:lista) {
			
			if(temp.getNome().equalsIgnoreCase(categoria.getNome())) {
				CategoriaJaCadastradaException ex = new CategoriaJaCadastradaException(categoria.getNome());
				throw(ex);
			}
			
		}
		
	
			c.adiciona(categoria);
	
		
	}
	
	public Categoria procurarCategoriaId(int id) {
		
		return c.procurarCategoriaId(id);
		
	}
	
	public List<Categoria> listarCategorias(){
		
		return c.listarCategorias();
		
	}
	
	public void atualizarCategoria(Categoria categoria) {
		
		c.atualizarCategoria(categoria);
		
	}
	
	public void removerCategoria(Categoria categoria) {
		
		c.removerCategoriaId(categoria);
		
	}
	
	public List<Categoria> procurarCategoriaNome(String nome){
		
		return c.procurarCategoriaNome(nome);
		
	}
	
	
	
	

}
