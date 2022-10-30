package com.example.CompanyApp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Company ID is already present in DataBase")
public class CompanyIDAlreadyExists extends Exception{


}
