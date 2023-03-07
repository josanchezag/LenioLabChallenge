package com.leniolabs.challenge.calculator.factory;


import com.leniolabs.challenge.calculator.FeeCalculatorIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FeeCalculatorFactory {
    @Autowired
    @Qualifier("corporate")
    FeeCalculatorIF corporateAccountFeeCalculator;
    @Autowired
    @Qualifier("personal")
    FeeCalculatorIF personalAccountFeeCalculator;

    public Double calculateFee(String accountType) throws Exception {
        if (accountType.trim().equals("COR"))
        {
            return this.corporateAccountFeeCalculator.calculateFee();
        } else if (accountType.trim().equals("PER")) {
            return this.personalAccountFeeCalculator.calculateFee();
        }
        else {
            throw new Exception("accountType don't exist");
        }

    }

    
}
