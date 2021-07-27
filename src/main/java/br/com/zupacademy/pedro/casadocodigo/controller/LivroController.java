package br.com.zupacademy.pedro.casadocodigo.controller;

import br.com.zupacademy.pedro.casadocodigo.dto.request.LivroDTORequest;
import br.com.zupacademy.pedro.casadocodigo.dto.response.LivroDTOResponse;
import br.com.zupacademy.pedro.casadocodigo.model.Livro;
import br.com.zupacademy.pedro.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid LivroDTORequest request){
        Livro livro = request.toModel(manager);
        livroRepository.save(livro);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<LivroDTOResponse>> listar(){
        List<LivroDTOResponse> retorno = new ArrayList<>();
        livroRepository.findAll().forEach(item-> retorno.add(new LivroDTOResponse(item.getId(), item.getTitulo())));
        return ResponseEntity.ok(retorno);
    }
}
