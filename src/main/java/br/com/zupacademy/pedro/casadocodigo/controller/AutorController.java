package br.com.zupacademy.pedro.casadocodigo.controller;

import br.com.zupacademy.pedro.casadocodigo.dto.request.AutorDTORequest;
import br.com.zupacademy.pedro.casadocodigo.model.Autor;
import br.com.zupacademy.pedro.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid AutorDTORequest autorDto, UriComponentsBuilder uriBuilder){
        Autor autor = autorDto.converter();
        autorRepository.save(autor);

        URI uri = uriBuilder.path("/autor/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.ok().build();
    }
}
