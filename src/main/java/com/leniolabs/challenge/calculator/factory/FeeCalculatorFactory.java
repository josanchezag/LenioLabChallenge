package com.leniolabs.challenge.calculator.factory;


import com.leniolabs.challenge.calculator.FeeCalculatorIF;
import com.leniolabs.challenge.constants.AccountType;
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
        if (accountType.trim().equals(AccountType.CORPORATE.getId()))
        {
            return this.corporateAccountFeeCalculator.calculateFee();
        } else if (accountType.trim().equals(AccountType.PERSONAL.getId())) {
            return this.personalAccountFeeCalculator.calculateFee();
        }
        else {
            throw new Exception("accountType don't exist");
        }

    }

    
}
