package com.example.CompanyApp.Services;

import com.example.CompanyApp.Exceptions.CompanyIDAlreadyExists;
import com.example.CompanyApp.Model.Company;
import com.example.CompanyApp.Repos.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepo companyRepo;


    @Override
    public List<Company> getAllCompanies() {
        List<Company> companyList = companyRepo.findAll();
        if (companyList.size() > 0){
            return companyList;
        } else {
            return null;
        }
    }


    @Override
    public Company addCompany(Company company) throws CompanyIDAlreadyExists {
        Optional <Company> companyOptional = companyRepo.findById(company.getCompanyID());
        if (companyOptional.isPresent()){
            throw new CompanyIDAlreadyExists();
        }
        companyRepo.saveAndFlush(company);
        return company;
    }


    @Override
    public boolean deleteCompany(int companyID) {
        companyRepo.deleteById(companyID);
        return true;
    }

    @Override
    public boolean updateCompany(Company company) {
        Company company1 = companyRepo.getById(company.getCompanyID());

        if (company1 != null) {
            company1.setCompanyName(company.getCompanyName());
            company1.setCompanyCEO(company.getCompanyCEO());
            company1.setTurnover(company.getTurnover());
            company1.setWebsite(company.getWebsite());
            companyRepo.saveAndFlush(company1);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCompanyByID(int companyID, Company company) {
        Company company1 = companyRepo.getById(company.getCompanyID());
        if (company1 != null) {
            company1.setCompanyName(company.getCompanyName());
            company1.setCompanyCEO(company.getCompanyCEO());
            company1.setTurnover(company.getTurnover());
            company1.setWebsite(company.getWebsite());
            companyRepo.saveAndFlush(company1);
            return true;
        }
        return false;
    }


    @Override
    public Company getCompanyByID(int companyID) {
        Optional <Company> company = companyRepo.findById(companyID);
        if (company.isPresent()){
            return company.get();
        }
        return null;
    }
}
