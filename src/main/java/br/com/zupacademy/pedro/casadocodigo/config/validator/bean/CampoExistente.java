package br.com.zupacademy.pedro.casadocodigo.config.validator.bean;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CampoExistenteValidator.class)
public @interface CampoExistente {
    String message() default "Valor do campo inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "";

    Class<?> table();

    String field();
}
