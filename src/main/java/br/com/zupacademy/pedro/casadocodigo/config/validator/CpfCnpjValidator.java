package br.com.zupacademy.pedro.casadocodigo.config.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfCnpjValidator implements ConstraintValidator<CpfCnpj, String>{
    @Override
    public void initialize(CpfCnpj constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s.length()==14 || s.length()==18){
            return true;
        }
        return false;
    }
}
