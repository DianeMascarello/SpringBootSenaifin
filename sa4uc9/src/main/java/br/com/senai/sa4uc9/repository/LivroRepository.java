package br.com.senai.sa4uc9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.sa4uc9.orm.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
