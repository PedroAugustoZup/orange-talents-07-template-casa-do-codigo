package br.com.zupacademy.pedro.casadocodigo.config.validator;

import br.com.zupacademy.pedro.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUnicoValidator implements ConstraintValidator<EmailUnico, String> {
    private String value;

    @Autowired
    private AutorRepository repository;

    @Override
    public void initialize(EmailUnico constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
       return !(repository.existsByEmail(s));
    }
}
