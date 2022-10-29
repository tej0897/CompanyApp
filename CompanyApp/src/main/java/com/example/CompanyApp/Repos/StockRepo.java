package com.example.CompanyApp.Repos;

import com.example.CompanyApp.Model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
@Transactional
public interface StockRepo extends JpaRepository<Stock, Integer> {

    @Query(value="select s from Stock s where s.companyIDFK= :companyID")
    public Set<Stock> getStockList(int companyID);

    @Modifying
    @Query(value = "delete from Stock where companyIDFK= :companyID")
    public void deleteStockData(int companyID);
}
