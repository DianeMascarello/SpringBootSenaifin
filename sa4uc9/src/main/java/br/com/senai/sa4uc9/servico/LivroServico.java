package br.com.senai.sa4uc9.servico;

import java.util.List;

import br.com.senai.sa4uc9.orm.Livro;

public interface LivroServico {
	public List<Livro> listarLivros();
	
	public void apagarLivros(Integer id);
	
	public Livro consultarLivrosId(Integer id);
	
	public Livro atualizarLivros(Livro livro);
	
	public Livro salvarLivros(Livro livro);
}
