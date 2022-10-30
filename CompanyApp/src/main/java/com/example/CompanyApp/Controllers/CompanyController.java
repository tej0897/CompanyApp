package com.example.CompanyApp.Controllers;

import com.example.CompanyApp.Exceptions.CompanyIDAlreadyExists;
import com.example.CompanyApp.Model.Company;
import com.example.CompanyApp.Model.Stock;
import com.example.CompanyApp.ResponseHandler.MyResponse;
import com.example.CompanyApp.Services.CompanyServiceImpl;
import com.example.CompanyApp.Services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1")
public class CompanyController {
    @Autowired
    private CompanyServiceImpl companyService;

    @Autowired
    private StockService stockService;


    @GetMapping("/getAllCompanies")
    public ResponseEntity<?> getAllCompany(){
        List<Company> companyList = companyService.getAllCompanies();
        if (companyList!=null){
//            return new ResponseEntity<>(companyList, HttpStatus.OK);

            for (Company company : companyList){
                Set<Stock> stockSet = stockService.getAllStocks(company.getCompanyID());
                company.setStockList(stockSet);
            }
            // return new ResponseEntity<>(companyList, HttpStatus.OK);

            return MyResponse.generateCustomResponseFormat("Data Retrieved Successfully!", HttpStatus.OK, companyList);
        }
        return MyResponse.generateCustomResponseFormat("Could not Retrieve Data", HttpStatus.CONFLICT, companyList);
        // return new ResponseEntity<>("Could not Pull data", HttpStatus.CONFLICT);
    }

    @PostMapping("/addCompany")
    public ResponseEntity<?> addCompany(@RequestBody Company company) throws CompanyIDAlreadyExists {
        if (companyService.addCompany(company)!=null){
            return new ResponseEntity<>(company, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Operation Failure", HttpStatus.CONFLICT);
    }

    @DeleteMapping("/deleteCompany/{companyID}")
    public ResponseEntity<?> deleteCompany(@PathVariable("companyID") int companyID){
        if (companyService.deleteCompany(companyID) & stockService.deleteStock(companyID)){   //stockService.deleteStock(companyID)
            return new ResponseEntity<>("Record Deleted", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("record cannot be deleted", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PutMapping("/updateCompany")
    public ResponseEntity<?> updateCompany(@RequestBody Company company){
        if (companyService.updateCompany(company)){
            return new ResponseEntity<>(company, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("cannot be updated", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/getCompanyByID/{companyID}")
    public ResponseEntity<?> getCompanyByID(@PathVariable("companyID") int companyID){
        Company company = companyService.getCompanyByID(companyID);

        if (company!=null){
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
        return new ResponseEntity<>("No Data to display", HttpStatus.NO_CONTENT);
    }


}
