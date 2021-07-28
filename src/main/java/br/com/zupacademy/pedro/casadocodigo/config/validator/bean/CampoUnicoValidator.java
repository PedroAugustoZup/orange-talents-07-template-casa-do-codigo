package br.com.zupacademy.pedro.casadocodigo.config.validator.bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CampoUnicoValidator implements ConstraintValidator<CampoUnico, Object> {
    private Class<?> table;
    private String field;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(CampoUnico campoUnicoValidator) {
        table = campoUnicoValidator.table();
        field = campoUnicoValidator.field();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o == null) {
            return true;
        }

        Query sql = entityManager.createQuery("select 1 from " + table.getName() + " where "+ field + " = :value")
        .setParameter("value", o);
        List<?> list = sql.getResultList();
        return list.isEmpty();
    }
}
