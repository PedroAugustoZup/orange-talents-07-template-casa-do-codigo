package br.com.zupacademy.pedro.casadocodigo.dto.request;

import br.com.zupacademy.pedro.casadocodigo.config.validator.CampoUnico;
import br.com.zupacademy.pedro.casadocodigo.model.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoriaDTORequest {
    @NotNull
    @NotBlank
    @CampoUnico(field = "nome", table = Categoria.class)
    private String nome;

    @Deprecated
    public CategoriaDTORequest() {
    }

    public CategoriaDTORequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }
}
