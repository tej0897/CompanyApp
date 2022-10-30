package com.example.CompanyApp.ResponseHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class MyResponse {
    public static ResponseEntity<Object> generateCustomResponseFormat(String message, HttpStatus status, Object responseObject){
        Map<String, Object> mapObject = new HashMap<>();

        mapObject.put("Message", message);
        mapObject.put("Status", status);
        mapObject.put("Data", responseObject);
        return new ResponseEntity<>(mapObject, status);
    }
}
