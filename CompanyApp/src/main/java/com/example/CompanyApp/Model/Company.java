package com.example.CompanyApp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Company {

    @Id
    private int companyID;
    private String companyName;
    private String companyCEO;
    private int turnover;
    private String website;

    private int stockPrice;

    public int getStockPrice() {
        return stockPrice;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyID=" + companyID +
                ", companyName='" + companyName + '\'' +
                ", companyCEO='" + companyCEO + '\'' +
                ", turnover=" + turnover +
                ", website='" + website + '\'' +
                ", stockPrice=" + stockPrice +
                ", stockList=" + stockList +
                '}';
    }

    public void setStockPrice(int stockPrice) {
        this.stockPrice = stockPrice;
    }

    @JsonIgnore
    @OneToMany(targetEntity = Stock.class)
    private Set<Stock> stockList;

    public Company() {
    }


    public Set<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(Set<Stock> stockList) {
        this.stockList = stockList;
    }

    public Company(int companyID, String companyName, String companyCEO, int turnover, String website) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.companyCEO = companyCEO;
        this.turnover = turnover;
        this.website = website;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCEO() {
        return companyCEO;
    }

    public void setCompanyCEO(String companyCEO) {
        this.companyCEO = companyCEO;
    }

    public int getTurnover() {
        return turnover;
    }

    public void setTurnover(int turnover) {
        this.turnover = turnover;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}
