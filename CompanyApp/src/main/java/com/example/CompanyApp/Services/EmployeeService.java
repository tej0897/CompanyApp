package com.example.CompanyApp.Services;

import com.example.CompanyApp.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {

    private RestTemplate restTemplate;

    @Autowired
    public EmployeeService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public String registerEmp(Employee employee){
        HttpEntity<Employee> entity = new HttpEntity<>(employee);
        return restTemplate.exchange("http://localhost:8080/auth/emp/registerEmp", HttpMethod.POST, entity, String.class).getBody();
    }

    public String loginEmp(Employee employee){
        HttpEntity<Employee> entity1 = new HttpEntity<>(employee);
        return restTemplate.exchange("http://localhost:8080/auth/emp/login", HttpMethod.POST, entity1, String.class).getBody();
    }

}
