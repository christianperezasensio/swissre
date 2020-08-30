package com.swissre.assessment.math;

import java.math.BigDecimal;

import static java.math.RoundingMode.CEILING;

public class Calculator {

    public BigDecimal getRate(String response) {
        return new BigDecimal(response.substring(response.indexOf(":") + 1, response.indexOf("}")));
    }

    public BigDecimal calculateAmount(String fromAmount, BigDecimal fromRate) {
        return new BigDecimal(fromAmount).multiply(fromRate);
    }

    public BigDecimal twoDecimalValue(BigDecimal value) {
        return value.setScale(2, CEILING);
    }
}
