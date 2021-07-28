package br.com.zupacademy.pedro.casadocodigo.dto.request;

import br.com.zupacademy.pedro.casadocodigo.config.validator.bean.CampoExistente;
import br.com.zupacademy.pedro.casadocodigo.config.validator.bean.CampoUnico;
import br.com.zupacademy.pedro.casadocodigo.model.Estado;
import br.com.zupacademy.pedro.casadocodigo.model.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoDTORequest {

    @NotBlank
    @CampoUnico(table = Estado.class, field = "nome")
    private String nome;

    @NotNull
    @CampoExistente(table = Pais.class, field = "id")
    private Integer paisId;

    @Deprecated
    public EstadoDTORequest() {
    }

    public EstadoDTORequest(String nome, Integer paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaisId() {
        return paisId;
    }

    public Estado toModel(EntityManager manager) {
        return new Estado(this.nome, manager.find(Pais.class, this.paisId));
    }
}
