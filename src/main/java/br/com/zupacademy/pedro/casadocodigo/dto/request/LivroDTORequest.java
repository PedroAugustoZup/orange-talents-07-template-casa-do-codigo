package br.com.zupacademy.pedro.casadocodigo.dto.request;

import br.com.zupacademy.pedro.casadocodigo.config.validator.CampoExistente;
import br.com.zupacademy.pedro.casadocodigo.config.validator.CampoUnico;
import br.com.zupacademy.pedro.casadocodigo.model.Autor;
import br.com.zupacademy.pedro.casadocodigo.model.Categoria;
import br.com.zupacademy.pedro.casadocodigo.model.Livro;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class LivroDTORequest {

    @NotBlank
    @CampoUnico(table = Livro.class, field = "titulo")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumario;
    @Min(value = 20)
    private Float preco;
    @Min(value = 100)
    private Integer numPaginas;
    @NotBlank
    @CampoUnico(table = Livro.class, field = "isbn")
    private String isbn;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;
    @NotNull
    @CampoExistente(table = Categoria.class, field = "id")
    private Integer categoria;
    @NotNull
    @CampoExistente(table = Autor.class, field = "id")
    private Integer autor;


    public LivroDTORequest() {
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public LivroDTORequest(String titulo, String resumo, String sumario, Float preco, Integer numPaginas,
                           String isbn, LocalDate dataPublicacao, Integer categoria, Integer autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Float getPreco() {
        return preco;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public Integer getAutor() {
        return autor;
    }

    public Livro toModel(EntityManager manager) {

        Autor autorFind = manager.find(Autor.class, this.autor);
        Categoria categoriaFind = manager.find(Categoria.class, this.categoria);
        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numPaginas, this.isbn,
                    this.dataPublicacao, categoriaFind, autorFind);
    }
}
