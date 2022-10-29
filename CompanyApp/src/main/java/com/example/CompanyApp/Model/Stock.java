package com.example.CompanyApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Entity
public class Stock {

    @Id
    @GeneratedValue
    private int transactionID;

    int stockPrice;

    Date timeStamp;

    private int companyIDFK;



    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(int stockPrice) {
        this.stockPrice = stockPrice;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getCompanyIDFK() {
        return companyIDFK;
    }

    public void setCompanyIDFK(int companyIDFK) {
        this.companyIDFK = companyIDFK;
    }

    @PrePersist
    public void setTimeStamp(){
        if (this.timeStamp == null){
            SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            timeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Chennai"));
        }
    }
}
