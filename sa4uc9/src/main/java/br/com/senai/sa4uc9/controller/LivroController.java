package br.com.senai.sa4uc9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.senai.sa4uc9.orm.Livro;
import br.com.senai.sa4uc9.servico.LivroServico;

@Controller
public class LivroController {
	
	@Autowired
	private LivroServico servico;
		
	@GetMapping({"/livro"})
	public String listarLivros(Model modelo) {
		modelo.addAttribute("livro", servico.listarLivros());
		return "livro"; //mostrar a página livro.html
	}
	
	@GetMapping({"/livro/{id}"})
	public String apagarLivros(@PathVariable Integer id) {
		servico.apagarLivros(id);
		return "redirect:/livro"; //mostrar a página livro.html
	}
	
	@GetMapping({"/livro/editar/{id}"})
	public String editarLivros(@PathVariable Integer id, Model modelo) {
		modelo.addAttribute("livro", servico.consultarLivrosId(id));
		return "editarLivro"; //mostrar a página Editar Livro
	}
	
	@PostMapping("/livro/{id}")
	public String atualizarLivros(@PathVariable Integer id, @ModelAttribute("livro") Livro livro, Model modelo) {
		Livro liv = servico.consultarLivrosId(id);
		liv.setId(id);
		liv.setTituloLivro(livro.getTituloLivro());
		liv.setAutorLivro(livro.getAutorLivro());
		liv.setIsbn(livro.getIsbn());
		servico.atualizarLivros(liv);
		return "redirect:/livro";
	}
	
	@GetMapping("/livro/adicionar")
	public String adicionarLivros(Model modelo) {
		Livro livro = new Livro();
		modelo.addAttribute("livro", livro);
		return "formLivro";
	}
	
	@PostMapping("/livro")
	public String salvarLivros(@ModelAttribute("livro") Livro livro) {
		servico.salvarLivros(livro);
		return "redirect:/livro";
	}

}