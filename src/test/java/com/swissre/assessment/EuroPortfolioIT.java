package com.swissre.assessment;

import org.junit.jupiter.api.Test;

class EuroPortfolioIT {

    @Test
    void checkPortfolio() {
        String[] args = {"/payload/portfolio.txt"};
        EuroPortfolio.main(args);
    }
}
