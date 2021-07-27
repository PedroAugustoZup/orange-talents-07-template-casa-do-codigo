package br.com.zupacademy.pedro.casadocodigo.repository;

import br.com.zupacademy.pedro.casadocodigo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
