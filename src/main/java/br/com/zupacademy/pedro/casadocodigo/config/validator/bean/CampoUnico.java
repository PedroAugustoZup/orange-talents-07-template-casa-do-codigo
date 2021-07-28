package br.com.zupacademy.pedro.casadocodigo.config.validator.bean;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CampoUnicoValidator.class)
public @interface CampoUnico {
    String message() default "Está valor já existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "";

    Class<?> table();

    String field();
}
