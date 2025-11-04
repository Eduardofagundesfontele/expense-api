package com.expense.api.api;

import com.expense.api.domain.Expense;
import com.expense.api.repository.ExpenseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class ExpenseController {

    private ExpenseRepository expenseRepository;

    public ExpenseController(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;

    }


    @GetMapping("/expenses")
    public List<Expense> findAll(){
        return StreamSupport.stream(expenseRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

}
