package br.com.zupacademy.pedro.casadocodigo.dto.request;

import br.com.zupacademy.pedro.casadocodigo.config.validator.CampoUnico;
import br.com.zupacademy.pedro.casadocodigo.model.Pais;

import javax.validation.constraints.NotBlank;

public class PaisDTORequest {

    @NotBlank
    @CampoUnico(table = Pais.class, field = "nome")
    private String nome;

    @Deprecated
    public PaisDTORequest() {
    }

    public PaisDTORequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Pais toModel() {
        return new Pais(this.nome);
    }
}
