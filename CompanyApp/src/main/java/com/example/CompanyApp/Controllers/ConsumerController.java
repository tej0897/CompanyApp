package com.example.CompanyApp.Controllers;

import com.example.CompanyApp.Model.Employee;
import com.example.CompanyApp.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("auth/cmp")
@RestController
public class ConsumerController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/register")
    public String registerEmp(@RequestBody Employee employee){
        return employeeService.registerEmp(employee);
    }

    @PostMapping("/login")
    public String loginEmp(@RequestBody Employee employee){
        return employeeService.loginEmp(employee);
    }

}
