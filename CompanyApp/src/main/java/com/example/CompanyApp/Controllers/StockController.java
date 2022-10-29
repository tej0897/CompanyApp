package com.example.CompanyApp.Controllers;

import com.example.CompanyApp.Model.Company;
import com.example.CompanyApp.Model.Stock;
import com.example.CompanyApp.Services.CompanyService;
import com.example.CompanyApp.Services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private CompanyService companyService;

    @PostMapping("/add/{companyID}")
    public ResponseEntity<?> addStock(@PathVariable("companyID") int companyID, @RequestBody Stock stock){
        Company existStock = companyService.getCompanyByID(companyID);
        if (existStock != null) {
            existStock.setStockPrice(stock.getStockPrice());    // will go to Company Table
            stock.setStockPrice(stock.getStockPrice());         // will go to Stock Table
            stock.setCompanyIDFK(stock.getCompanyIDFK());
            stock.setTimeStamp(stock.getTimeStamp());

            if (companyService.updateCompany(existStock) && stockService.addStock(stock))
                return new ResponseEntity<>(stock, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Stock Details cannot be added", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/getAllStocks")
    public ResponseEntity<?> getAllReaders(@RequestParam("companyID") int companyID){

        Set<Stock> stockList = stockService.getAllStocks(companyID);
        if (stockList != null && !stockList.isEmpty()){
            return new ResponseEntity<>(stockList, HttpStatus.OK);
        }
        return new ResponseEntity<>("No Data Available", HttpStatus.NO_CONTENT);
    }

}
