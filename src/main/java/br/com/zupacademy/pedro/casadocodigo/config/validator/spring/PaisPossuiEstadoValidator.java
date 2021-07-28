package br.com.zupacademy.pedro.casadocodigo.config.validator.spring;

import br.com.zupacademy.pedro.casadocodigo.dto.request.ClienteDTORequest;
import br.com.zupacademy.pedro.casadocodigo.model.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class PaisPossuiEstadoValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return ClienteDTORequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        ClienteDTORequest cliente = (ClienteDTORequest) o;
        Pais pais = manager.find(Pais.class, cliente.getPais());
        List<?> lista = manager.createQuery("select e from Estado e where e.pais.id = :paisId")
                .setParameter("paisId", pais.getId())
                .getResultList();
        if (lista.size()>0 && cliente.getEstado() == null) {
            errors.rejectValue("estado", null, "O país selecionado necessita de um estado");
        }

    }
}
