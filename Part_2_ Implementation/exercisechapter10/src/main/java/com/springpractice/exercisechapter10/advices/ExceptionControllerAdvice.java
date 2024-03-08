package com.springpractice.exercisechapter10.advices;


import com.springpractice.exercisechapter10.exceptions.NotEnoughMoneyException;
import com.springpractice.exercisechapter10.models.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {


    @ExceptionHandler(NotEnoughMoneyException.class)

    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler(){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("There is not enough money to proceed.");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);

    }
}
