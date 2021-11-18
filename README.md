# swissre assessment

## To run

You can run EuroPortfolioIT from the IDE, but if you would rather compile and run, then you can either use Maven to build or the java compiler

To run as a Maven project:
- Go to swissre\target\classes
- Execute java com.swissre.assessment.EuroPortfolio /bobs_crypto.txt

If Maven is not allowed to compile this exercise, then
- Go to src\main\java
- Execute javac com\swissre\assessment\EuroPortfolio.java
- Move the classes and resources to a common classpath while keeping the packages structure
- Execute java com.swissre.assessment.EuroPortfolio /bobs_crypto.txt
