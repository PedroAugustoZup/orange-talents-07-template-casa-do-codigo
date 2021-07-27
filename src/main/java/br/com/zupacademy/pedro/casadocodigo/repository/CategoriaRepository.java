package br.com.zupacademy.pedro.casadocodigo.repository;

import br.com.zupacademy.pedro.casadocodigo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
