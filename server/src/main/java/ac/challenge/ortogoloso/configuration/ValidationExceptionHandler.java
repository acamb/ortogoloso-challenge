package ac.challenge.ortogoloso.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Advice per gestire gli errori di validazione e ritornare delle chiavi.
 * Attualmente il FE ignora questi messaggi, ma possono essere facilmente agganciati e tradotti
 */
@ControllerAdvice
public class ValidationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public Map<String,String> handle(MethodArgumentNotValidException ex){
        return ex.getBindingResult().getAllErrors().stream().collect(Collectors.toMap(
                error -> ((FieldError)error).getField(),
                error -> error.getDefaultMessage() != null ? error.getDefaultMessage() : "Not specified"
        ));
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseBody
    public List<String> handle(ConstraintViolationException ex){
        return ex.getConstraintViolations().stream().map(constraintViolation -> String.format("%s value '%s' %s", constraintViolation.getPropertyPath(),
                constraintViolation.getInvalidValue(), constraintViolation.getMessage())).collect(Collectors.toList());

    }

}
