package br.com.zupacademy.pedro.casadocodigo.controller;

import br.com.zupacademy.pedro.casadocodigo.dto.request.CategoriaDTORequest;
import br.com.zupacademy.pedro.casadocodigo.model.Categoria;
import br.com.zupacademy.pedro.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid CategoriaDTORequest request){
        Categoria categoria = request.toModel();
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }
}
