package com.stacksimplify.restservices.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Date;

//@ControllerAdvice
public class CustomGlobalExceptionHandler  extends ResponseEntityExceptionHandler {


    //you have to do what you asked to do (look at class user (@NotEmpty @Size))  if not the exception will throw automatically.
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
                "From ArgumentNotValid Exception in MH",
                  ex.getMessage());

        return new ResponseEntity<Object>(customErrorDetails,HttpStatus.BAD_REQUEST);
    }

    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
                "From HttpRequestMethodNotSupportedException in MH - Method Not Allowed",
                ex.getMessage());

        return  new ResponseEntity<Object>(customErrorDetails,HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(UserNameNotFoundException.class)
    public final   ResponseEntity<Object> handleUserNameNotFoundException(UserNameNotFoundException ex,  WebRequest request){
        CustomErrorDetails  customErrorDetails = new CustomErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return  new ResponseEntity<>(customErrorDetails, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object>  handleconstraintViolationException(ConstraintViolationException ex, WebRequest request){
        CustomErrorDetails  customErrorDetails = new CustomErrorDetails(
                                                 new Date(), ex.getMessage()+"this is it",
                                                  request.getDescription(false));
        return  new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);

    }


}
