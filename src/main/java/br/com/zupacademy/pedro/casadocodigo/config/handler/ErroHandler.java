package br.com.zupacademy.pedro.casadocodigo.config.handler;


import br.com.zupacademy.pedro.casadocodigo.config.exception.EstadoInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDeCadastro> handle(MethodArgumentNotValidException exception) {
        List<ErroDeCadastro> dto = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroDeCadastro erro = new ErroDeCadastro(e.getField(), mensagem);
            dto.add(erro);
        });

        return dto;
    }
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EstadoInvalidoException.class)
    public ErroDeCadastro handle(EstadoInvalidoException exception){
        return new ErroDeCadastro("estado", exception.getMessage());
    }
}
