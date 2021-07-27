package br.com.zupacademy.pedro.casadocodigo.dto.request;

import br.com.zupacademy.pedro.casadocodigo.config.validator.CampoExistente;
import br.com.zupacademy.pedro.casadocodigo.config.validator.CampoUnico;
import br.com.zupacademy.pedro.casadocodigo.config.validator.CpfCnpj;
import br.com.zupacademy.pedro.casadocodigo.model.Cliente;
import br.com.zupacademy.pedro.casadocodigo.model.Estado;
import br.com.zupacademy.pedro.casadocodigo.model.Pais;
import br.com.zupacademy.pedro.casadocodigo.repository.EstadoRepository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.security.InvalidParameterException;
import java.util.List;
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
        if(this.estado != null){
            Estado estado = manager.find(Estado.class, this.estado);
            if(estado.isValid(paisFind)) {
                return new Cliente(this.nome,this.sobrenome, this.email, this.documento, this.endereco, this.complemento,
                        this.cidade, paisFind, estado, this.telefone, this.cep);
            }
        }
        throw new IllegalArgumentException("Estado inválido");
    }
}
