package br.com.zupacademy.pedro.casadocodigo.dto.response;

public class LivroDTOResponse {

    private Integer id;
    private String titulo;

    public LivroDTOResponse(Integer id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
