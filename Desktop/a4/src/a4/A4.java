package a4;
/**
 * List of Rules as provided in Java Programming Style Guide
 * 24. Abbreviations in names should be avoided.
 * 4. Variable names must be in mixed case starting with lower case.
 * 5. Names representing constants (final variables) must be all uppercase using underscore to separate words.
 * 58. Floating point constants should always be written with decimal point and at least one decimal.
 * 6. Names representing methods must contain a verb and written in mixed case starting with lower case.
 * 73. -Operators should be surrounded by a space character. 
 * - Java reserved words should be followed by a white space. 
 * - Commas should be followed by a white space.  
 * -Colons should be surrounded by white space.
 * - Semicolons in for statements should be followed by a space character.
 * 10. All names should be written in English.
 * 11. Variables with average large scope should have long names, variables with average small scope can have short names.
 * 14. is prefix should be used for boolean variables and methods.
 * 15. The term compute can be used in methods where something is computed.
 * 45. Variables must never have dual meaning.
 * 37. The package statement must be the first statement of the file. All files should belong to a specific package.
 * 7. Abbreviations and acronyms should not be uppercase when used as name.
 * 80. All comments should be written in English.
 * 81. Javadoc comments should have the following form:
 * 82. There should be a space after the comment identifier.
 * 83. Use // for all non-JavaDoc comments, including multi-line comments.
 * 84. Comments should be indented relative to their position in the code.  
 */
/**
 * Library of statistical functions using Generics for different statistical
 * calculations.
 * 
 * see http://www.calculator.net/standard-deviation-calculator.html
 * for sample standard deviation calculations
 *
 * @author Joey Programmer
 * @authorShip :“I, Aneri Parikh, 000770402, certify that this material is my original work. 
 * No other person's work has been used without due acknowledgement and 
 * I have not made my work available to anyone else.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public final class A4 {
/**
 * computeAverage method is used to find average of the array list.
 * @param <T> defines datatype of the isPositiveDigits list
 * @param listOfDigits defines collection of the numbers
 * @param isPositiveDigits is boolean variable which shows positive numbers
 * @return average number values of type double
 */
    public static <T extends Number> double computeAverage (ArrayList<T> listOfDigits, boolean isPositiveDigits) {
        double sum = calculateSum(listOfDigits, isPositiveDigits); // declared sum variable to store return values
        int counter = 0; // initialize the counter with zero , which countes positive number of listOfDigits
        for (int i = 0; i < listOfDigits.size(); i++) {
            if (isPositiveDigits || listOfDigits.get(i).doubleValue() >= 0) {
                counter++;
            }
            // check the conditions , count the total number of array list
        }
        // It checks the condition when counter == 0 
        if (counter == 0) {
            // throws the IllegalArgumentException if no values are positive
            throw new IllegalArgumentException("no values are > 0");
        }
        return sum / counter; // returns the value after computing sun / counter to get the average number.
    }
    /**
     * sum method is used to find sum of the array list.
     * @param <T> defines datatype of the isPositiveDigits list
     * @param listOfDigits defines collection of the numbers
     * @param isPositiveDigits is boolean variable which shows positive numbers
     * @return calculated value for sum of type double
     */
    public static <T extends Number> double calculateSum (ArrayList<T> listOfDigits, boolean isPositiveDigits) {
        // check the condition if listOfDigits < 0 
        if (listOfDigits.size() < 0) {
            // throws the IllegalArgumentException if listOfDigits is empty
            throw new IllegalArgumentException("listOfDigits cannot be empty");
        }
        
        double sum = 0.0; // declared variable sum and initialized with double type 0.0
        for (T val : listOfDigits) {
            // initialize double type value which type cast the values comming from listOfDigits
            double value = val.doubleValue();
            // check the conditions if the values are grater and equal to 0 
            if (isPositiveDigits || value >= 0) {
                sum += value; // add the values in sum
            }
        }
        return sum; // return the sum
    }
    /**
     * this method is to find out the median value of the array list
     * @param <T> defines datatype of the isPositiveDigits list
     * @param listOfDigits defines collection of the numbers
     * @return calculate value of median type double 
     */
    public static <T extends Number & Comparable> double calculateMedian (ArrayList<T> listOfDigits) {
        // check the condition fro empty listOfDigits
        if (listOfDigits.isEmpty()) {
            throw new IllegalArgumentException("Size of array must be greater than 0"); // throws the IllegalArgumentException is the array list is not filled
        }

        Collections.sort(listOfDigits); // predefined function Collections.sort is used to sort the listOfDigits

        double median = listOfDigits.get(listOfDigits.size() / 2).doubleValue(); // divide the size of the listOfDigits of the array with 2 to find out the median of type double
        // it checks odd and even values
        if (listOfDigits.size() % 2 == 0) {
            // // if the size value is odd than listOfDigits size by 2 and for even than addition of size devide by 2 and (size by 2) - 1, and devide by 2
            median = (listOfDigits.get(listOfDigits.size() / 2).doubleValue() + listOfDigits.get(listOfDigits.size() / 2 - 1).doubleValue()) / 2;
        }
        // return the value of the calculated median of type double 
        return median;
    }
    
    /**
     * calculateStandardDeviation method is used to find StandardDeviation of the array list.
     * @param <T> defines datatype of the isPositiveDigits list
     * @param listOfDigits defines collection of the numbers
     * @return calculate value of StandardDeviation type double 
     */
    public static <T extends Number> double calculateStandardDeviation (ArrayList<T> listOfDigits) {
        //check the condition whether the size of the listOfDigits less than or equal to 1
        if (listOfDigits.size() <= 1) {
            throw new IllegalArgumentException("Size of array must be greater than 1"); // throws the IllegalArgumentException if the Size of array is less than 1
        }
        
        int sizeOflist = listOfDigits.size(); // declared the variable sizeOflist of type int to store the size of listOfDigits
        double sigma  = 0; // declared the variable sigma of type double which initialize with value zero 
        double average = computeAverage(listOfDigits,true); // declared the variable average of type double to store return value of computeAverage
        
        for (int i = 0; i < sizeOflist; i++) {
            double valueOfTypeDouble = listOfDigits.get(i).doubleValue(); // initialize double type valueOfTypeDouble which type cast the values comming from listOfDigits
            sigma += Math.pow(valueOfTypeDouble - average,2); // calculated value from given expression is adding value to sigma variable 
        }
        double StandardDeviation = Math.sqrt(sigma / (sizeOflist - 1)); // calculate the expression using predefine function Math.sqrt which can be store in StandardDeviation variable of type double 
        return StandardDeviation; // return the calculated value of StandardDeviation 
    }

    // Simple set of tests that confirm that functions operate correctly
    public static void main(String[] args) {
        ArrayList<Integer> testDataForInteger = new ArrayList<>(Arrays.asList(1,2,3,4,5)); // ArrayList is declared and initialized with type Integer which contains variable TEST_DATA_FOR_INTEGER
        ArrayList<Double> testDataForDouble = new ArrayList<>(Arrays.asList(2.2, 3.3, 66.2, 17.5, 30.2, 31.1)); // ArrayList is declared and initialized with type Double which contains variable TEST_DATA_FOR_Double

        System.out.printf("The sum of the Integer array = %.0f\n", calculateSum(testDataForInteger, true)); // print the calculateSum of the array list which calculate upto zero decimal place of type integer

        System.out.printf("The average of the Integer test set = %.0f\n", computeAverage(testDataForInteger, true)); // print the computeAverage of the array list which calculate upto zero decimal place of type integer
        System.out.printf("The average of the Double test set = %.2f\n", computeAverage(testDataForDouble, true)); // print the computeAverage of the array list which calculate upto two decimal place of type double

        System.out.printf("The median value of the Integer data set = %.1f\n", calculateMedian(testDataForInteger)); // print the calculateMedian of the array list which calculate upto one decimal place of type integer
        System.out.printf("The median value of the Double data set = %.1f\n", calculateMedian(testDataForDouble)); // print the calculateMedian of the array list which calculate upto one decimal place of type double
        
        System.out.printf("The sample standard deviation of the Integer test set = %.2f\n", calculateStandardDeviation(testDataForInteger)); // print the calculateStandardDeviation of the array list which calculate upto two decimal place of type integer
        System.out.printf("The sample standard deviation of the Double test set = %.2f\n", calculateStandardDeviation(testDataForDouble)); // print the calculateStandardDeviation of the array list which calculate upto two decimal place of type double
    }
}
