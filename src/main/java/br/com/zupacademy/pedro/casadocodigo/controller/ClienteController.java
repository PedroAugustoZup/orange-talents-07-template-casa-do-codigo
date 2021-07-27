package br.com.zupacademy.pedro.casadocodigo.controller;

import br.com.zupacademy.pedro.casadocodigo.dto.request.ClienteDTORequest;
import br.com.zupacademy.pedro.casadocodigo.model.Cliente;
import br.com.zupacademy.pedro.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.pedro.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> salvar(@RequestBody @Valid ClienteDTORequest request){
        Cliente cliente = request.toModel(manager);
        return ResponseEntity.ok(clienteRepository.save(cliente).getId());
    }
}
