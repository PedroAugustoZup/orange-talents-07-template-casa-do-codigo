package br.com.zupacademy.pedro.casadocodigo.config.handler;

public class ErroDeCadastro {
    private final String mensagem;
    private final String field;

    public ErroDeCadastro(String field, String mensagem) {
        this.field = field;
        this.mensagem = mensagem;
    }

    public String getField() {
        return field;
    }


    public String getMensagem() {
        return mensagem;
    }
}
