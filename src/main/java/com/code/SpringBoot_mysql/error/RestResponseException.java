package com.code.SpringBoot_mysql.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus(HttpStatus.NOT_FOUND)
@ResponseBody
public class RestResponseException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public String Errorresponsemethod(DepartmentNotFoundException exception)
    {
          //ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
        // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        return exception.getMessage();

    }

}
