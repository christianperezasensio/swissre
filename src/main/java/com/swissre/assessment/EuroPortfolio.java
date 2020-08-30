package com.swissre.assessment;

import com.swissre.assessment.io.FileReader;
import com.swissre.assessment.math.Calculator;
import com.swissre.assessment.rest.RestClient;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class EuroPortfolio {

    private static final String FROM_SYMBOL_KEY = "fsym";
    private static final String TO_SYMBOL_KEY = "tsyms";
    private static final String TO_SYMBOL_VALUE = "EUR";
    private static final int SYMBOL_POSITION = 0;
    private static final int AMOUNT_POSITION = 1;

    public static void main(String[] args) {
        String file = args[0];

        FileReader fileReader = new FileReader();
        RestClient restClient = new RestClient();
        Calculator calculator = new Calculator();

        String portfolio = fileReader.readFile(file);
        BigDecimal totalValue = BigDecimal.ZERO;

        for (String line : portfolio.split("\n")) {
            Map<String, String> parameters = new HashMap<>();
            String[] symbolAndAmount = line.split("=");
            parameters.put(FROM_SYMBOL_KEY, symbolAndAmount[SYMBOL_POSITION]);
            parameters.put(TO_SYMBOL_KEY, TO_SYMBOL_VALUE);

            BigDecimal value = calculator.calculateAmount(symbolAndAmount[AMOUNT_POSITION], calculator.getRate(restClient.sendRequest(parameters)));
            System.out.println(symbolAndAmount[SYMBOL_POSITION] + "=" + calculator.twoDecimalValue(value));
            totalValue = totalValue.add(value);
        }
        System.out.println("Total=" + calculator.twoDecimalValue(totalValue));
    }
}
