package dasturlash.uz.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(BookBadException.class)
    public ResponseEntity<String>handle(BookBadException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(StudentBadException.class)
    public ResponseEntity<String>handle(StudentBadException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
