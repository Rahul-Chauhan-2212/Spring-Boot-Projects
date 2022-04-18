package com.spring.boot.http.integration.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.http.integration.test.model.Income;

@RestController
public class TransactionsEndpoint {
	

    static List<Income> incomeList = new ArrayList();
 
    static {
        incomeList.add(new Income("First Income", 1000.0));
    }
 
    @GetMapping("/incomes")
    public List getAllIncomes() {
        return incomeList;
    }

}
