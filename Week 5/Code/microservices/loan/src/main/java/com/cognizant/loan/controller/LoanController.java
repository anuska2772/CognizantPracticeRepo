package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping("/{number}")
    public Map<String, Object> getLoan(@PathVariable String number) {
        return Map.of(
                "number", number,
                "type", "car",
                "loan", 400000,
                "emi", 3258,
                "tenure", 18
        );
    }

    @GetMapping("/status")
    public String getLoanStatus() {
        return "Loan service is up and running!";
    }
}
