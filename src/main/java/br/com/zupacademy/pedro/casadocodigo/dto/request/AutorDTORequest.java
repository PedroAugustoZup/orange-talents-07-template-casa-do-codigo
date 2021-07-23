package br.com.zupacademy.pedro.casadocodigo.dto.request;

import br.com.zupacademy.pedro.casadocodigo.model.Autor;
import br.com.zupacademy.pedro.casadocodigo.repository.AutorRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorDTORequest {
    @NotNull
    @NotBlank
    private String nome;
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotNull
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor converter() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
