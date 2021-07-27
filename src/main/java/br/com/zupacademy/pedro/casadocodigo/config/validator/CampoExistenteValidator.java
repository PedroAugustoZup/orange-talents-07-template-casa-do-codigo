package br.com.zupacademy.pedro.casadocodigo.config.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CampoExistenteValidator implements ConstraintValidator<CampoExistente, Object> {
    private Class<?> table;
    private String field;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(CampoExistente campoUnicoValidator) {
        table = campoUnicoValidator.table();
        field = campoUnicoValidator.field();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o == null) {
            return true;
        }
        List<?> lista = entityManager.createQuery("select 1 from " + table.getName() + " where " + field + " = :value")
                    .setParameter("value", o).getResultList();
        return !(lista.isEmpty());
    }
}
