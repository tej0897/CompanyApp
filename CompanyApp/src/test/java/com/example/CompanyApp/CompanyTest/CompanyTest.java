package com.example.CompanyApp.CompanyTest;

import com.example.CompanyApp.Model.Company;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CompanyTest {
    @Test
    public void test(){
        Company company = Mockito.mock(Company.class);
        when(company.getCompanyName()).thenReturn(null);

        Company company1 = new Company();

        String companyNew = company.setCompanyName("Wipro");

        String companyNew1 = company.getCompanyName();

        System.out.println(companyNew);
        when(company.getCompanyName()).thenReturn(companyNew1);

        assertEquals(companyNew, companyNew1);


    }
}
