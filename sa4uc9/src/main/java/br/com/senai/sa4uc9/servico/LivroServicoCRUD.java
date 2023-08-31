package br.com.senai.sa4uc9.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.sa4uc9.orm.Livro;
import br.com.senai.sa4uc9.repository.LivroRepository;

@Service
public class LivroServicoCRUD implements LivroServico {
	
	@Autowired
	private LivroRepository repositorio;

	public List<Livro> listarLivros() {
		return (List<Livro>) repositorio.findAll();
	}
	public void apagarLivros(Integer id) {
		repositorio.deleteById(id);
	}
	
	public Livro consultarLivrosId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public Livro atualizarLivros(Livro livro) {
		return repositorio.save(livro);
	}
	
	public Livro salvarLivros(Livro livro) {
		return repositorio.save(livro);
		
	}
}
