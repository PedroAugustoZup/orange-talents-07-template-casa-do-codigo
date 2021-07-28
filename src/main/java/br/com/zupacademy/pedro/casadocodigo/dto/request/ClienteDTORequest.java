package br.com.zupacademy.pedro.casadocodigo.dto.request;

import br.com.zupacademy.pedro.casadocodigo.config.exception.EstadoInvalidoException;
import br.com.zupacademy.pedro.casadocodigo.config.validator.bean.CampoExistente;
import br.com.zupacademy.pedro.casadocodigo.config.validator.bean.CampoUnico;
import br.com.zupacademy.pedro.casadocodigo.config.validator.bean.CpfCnpj;
import br.com.zupacademy.pedro.casadocodigo.model.Cliente;
import br.com.zupacademy.pedro.casadocodigo.model.Estado;
import br.com.zupacademy.pedro.casadocodigo.model.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ClienteDTORequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @Email
    @CampoUnico(table = Cliente.class, field = "email")
    private String email;
    @NotBlank
    @CpfCnpj
    @CampoUnico(table = Cliente.class, field = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @CampoExistente(table = Pais.class, field = "id")
    private Integer pais;
    @CampoExistente(table = Estado.class, field = "id")
    private Integer estado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    @Deprecated
    public ClienteDTORequest() {
    }

    public ClienteDTORequest(String nome, String sobrenome, String email, String documento,
                             String endereco, String complemento, String cidade, Integer pais,
                             String telefone, String cep) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Integer getPais() {
        return pais;
    }

    public Integer getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Cliente toModel(EntityManager manager) {
        Pais paisFind = manager.find(Pais.class, this.pais);
        Cliente cliente = new Cliente(this.nome, this.sobrenome, this.email, this.documento, this.endereco, this.complemento,
                this.cidade, paisFind, this.telefone, this.cep);
        if(this.estado == null){
            return cliente;
        }
        Estado estado = manager.find(Estado.class, this.estado);
        if(estado.pertenceAPais(paisFind)){
            cliente.setEstado(estado);
            return cliente;
        }
        throw new EstadoInvalidoException("Estado inválido");
    }

    public boolean temEstado() {
        return Optional.ofNullable(estado).isPresent();
    }
}
