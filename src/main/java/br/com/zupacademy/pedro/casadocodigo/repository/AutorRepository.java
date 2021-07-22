package br.com.zupacademy.pedro.casadocodigo.repository;


import br.com.zupacademy.pedro.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
