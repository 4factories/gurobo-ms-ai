package it.gurobo.ms.ai.run.configuration;

import it.gurobo.spring.shared.core.conf.ACommonHandlerAdvice;
import it.gurobo.spring.shared.core.exception.FatalityDataException;
import it.gurobo.spring.shared.core.exception.GuroboGenericException;
import it.gurobo.spring.shared.core.exception.GuroboValidationException;
import it.gurobo.spring.shared.core.exception.RestCallException;
import it.gurobo.spring.shared.core.response.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ACommonHandlerAdvice {

    @Autowired
    public ExceptionHandlerAdvice(MessageSource messageSource) {
        super(messageSource);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ResponseWrapper<?>> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        return buildHttpMessageNotReadableResponse(ex);
    }

    @ExceptionHandler(GuroboValidationException.class)
    protected ResponseEntity<ResponseWrapper<?>> handleMethodArgumentNotValid(GuroboValidationException ex) {
        return buildGuroboValidationResponse(ex);
    }

    @ExceptionHandler(RestCallException.class)
    protected ResponseEntity<ResponseWrapper<?>> restCallException(RestCallException ex) {
        return buildRestCallResponse(ex);
    }

    @ExceptionHandler(FatalityDataException.class)
    protected ResponseEntity<ResponseWrapper<?>> baseDataExceptionHandling(FatalityDataException ex) {
        return buildFatalityDataResponse(ex);
    }

    @ExceptionHandler(GuroboGenericException.class)
    protected ResponseEntity<ResponseWrapper<?>> handleGuroboGenericException(GuroboGenericException ex) {
        return buildGuroboGenericResponse(ex);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ResponseWrapper<?>> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return buildResponseWrapperResponseEntity(ex);
    }

}