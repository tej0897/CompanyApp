package com.example.CompanyApp.CompanyServiceImplTest;


import com.example.CompanyApp.Model.Company;
import com.example.CompanyApp.Repos.CompanyRepo;
import com.example.CompanyApp.Services.CompanyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
public class CompanyServiceImplTest {

    @Mock
    private CompanyRepo companyRepo;

    @InjectMocks
    private CompanyServiceImpl companyService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(companyService).build();
    }

    List<Company> companyList = new ArrayList<>();

    @Test
    public void getAllCompany() throws Exception{
        Company company = new Company();
        company.setCompanyID(123);
        company.setCompanyName("Google");

        companyList.add(company);
        when(companyRepo.findAll()).thenReturn(companyList);

        List<Company> companies = companyService.getAllCompanies();
        assertEquals(companyList, companies);

    }



    @Test
    public void addCompany() throws Exception{
        Company company = new Company();
        company.setCompanyID(123);
        company.setCompanyName("Infosys");

        companyList.add(company);
        when(companyRepo.save(any())).thenReturn(company);

        Company company1 =  companyService.addCompany(company);
        assertEquals(company, company1);

    }
}
