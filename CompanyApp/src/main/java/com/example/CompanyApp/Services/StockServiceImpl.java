package com.example.CompanyApp.Services;

import com.example.CompanyApp.Model.Company;
import com.example.CompanyApp.Model.Stock;
import com.example.CompanyApp.Repos.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepo stockRepo;

    @Override
    public Set<Stock> getAllStocks(int companyID) {
        return stockRepo.getStockList(companyID);
    }

    @Override
    public boolean deleteStock(int companyID) {
        stockRepo.deleteStockData(companyID);
        return true;
    }

    @Override
    public boolean addStock(Stock stock) {
        Stock stock1 = new Stock();

        stock1.setStockPrice(stock.getStockPrice());
        stock1.setCompanyIDFK(stock.getCompanyIDFK());
        stock1.setTimeStamp(stock.getTimeStamp());
        stockRepo.saveAndFlush(stock1);
        return true;
    }


}
