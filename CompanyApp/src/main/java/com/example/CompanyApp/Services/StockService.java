package com.example.CompanyApp.Services;

import com.example.CompanyApp.Model.Company;
import com.example.CompanyApp.Model.Stock;

import java.util.Set;

public interface StockService {
    public Set<Stock> getAllStocks(int companyID);

    public boolean deleteStock(int companyID);

    public boolean addStock(Stock stock);

}
