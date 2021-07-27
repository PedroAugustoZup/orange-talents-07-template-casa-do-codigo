package br.com.zupacademy.pedro.casadocodigo.dto.response;

import br.com.zupacademy.pedro.casadocodigo.model.Livro;

import java.time.LocalDate;
import java.util.Optional;

public class LivroEspecificoDTOResponse {
    private String titulo;
    private String resumo;
    private String sumario;
    private Float preco;
    private Integer numPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private String categoria;
    private String autor;
    private String descricaoAutor;

    public LivroEspecificoDTOResponse(Optional<Livro> livro) {
        this.titulo = livro.get().getTitulo();
        this.resumo = livro.get().getResumo();
        this.sumario = livro.get().getSumario();
        this.preco = livro.get().getPreco();
        this.numPaginas = livro.get().getNumPaginas();
        this.isbn = livro.get().getIsbn();
        this.dataPublicacao = livro.get().getDataPublicacao();
        this.categoria = livro.get().getCategoria().getNome();
        this.autor = livro.get().getAutor().getNome();
        this.descricaoAutor = livro.get().getAutor().getDescricao();
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

    public String getCategoria() {
        return categoria;
    }

    public String getAutor() {
        return autor;
    }

    public String getDescricaoAutor() {
        return descricaoAutor;
    }
}
