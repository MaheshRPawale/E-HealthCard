package com.Medical.HealthCard.centalexception;

import com.Medical.HealthCard.DTO.ApiResponse;
import com.Medical.HealthCard.Uitls.ExceptionXHandlers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CommonException {

    @ExceptionHandler(ExceptionXHandlers.class)
    public ResponseEntity<ApiResponse> exceptionHandler(ExceptionXHandlers exceptionXHandlers){
        final ApiResponse apiResponse = ApiResponse.builder().massage(exceptionXHandlers.getMessage()).success(false).httpStatus(HttpStatus.BAD_REQUEST).build();
         return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodArgumentNotValidException(MethodArgumentNotValidException e){
        final List<ObjectError> allErrors = e.getAllErrors();
        Map<String,String> map=new HashMap<>();
        ApiResponse apiResponse1=new ApiResponse();
        allErrors.stream().map(arg->{
            String defaultMasage=arg.getDefaultMessage();
            String FiledName=arg.getObjectName();

           map.put(FiledName,defaultMasage);
           return map;
        }).collect(Collectors.toList());
    return new ResponseEntity<>(map,HttpStatus.OK);
    }



}
