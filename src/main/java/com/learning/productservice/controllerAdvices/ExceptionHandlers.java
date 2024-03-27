package com.learning.productservice.controllerAdvices;

import com.learning.productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> arithemticExceptionError(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.message = "Arithmetic Exception";
        return new ResponseEntity<>(exceptionDto, HttpStatus.FORBIDDEN);
    }
}
