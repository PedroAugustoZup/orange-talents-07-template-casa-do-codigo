package br.com.zupacademy.pedro.casadocodigo.repository;

import br.com.zupacademy.pedro.casadocodigo.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
    List<Estado> findByPaisId(Integer pais);
}
