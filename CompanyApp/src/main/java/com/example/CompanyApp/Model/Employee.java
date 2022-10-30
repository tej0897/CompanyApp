package com.example.CompanyApp.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    private int empID;
    private String empName;
    private String password;

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String setPassword) {
        this.password = setPassword;
    }

    public Employee(int empID, String empName, String password) {
        this.empID = empID;
        this.empName = empName;
        this.password = password;
    }

    public Employee() {
    }
}
