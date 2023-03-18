package com.leniolabs.challenge.caculator.factory;

import com.leniolabs.challenge.calculator.factory.FeeCalculatorFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FeeCalculatorFactoryTest {
    private final String ACCOUNT_TYPE_CORPORATE="COR";
    private final String ACCOUNT_TYPE_PERSONAL="PER";

    @Autowired
    FeeCalculatorFactory feeCalculatorFactory;


    @Test
    @DisplayName("Given an account type personal when request calculator fee then return the fee")
    public void GivenAnaccount_type_personalWhen_request_calculator_feeThen_return_the_fee() throws Exception {
        assertTrue(this.feeCalculatorFactory.calculateFee(ACCOUNT_TYPE_PERSONAL).toString().equals("0.01"));
    }

    @Test
    @DisplayName("Given an account type corporate when request calculator fee then return the fee")
    public void GivenAnaccount_type_corporateWhen_request_calculator_feeThen_return_the_fee() throws Exception {
        assertTrue(this.feeCalculatorFactory.calculateFee(ACCOUNT_TYPE_CORPORATE).equals(0.05));
    }


}


