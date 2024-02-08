package CS122Exercises.OperationsOnFractions.Version2;

// Can't make those comments a javadoc in my ide so I used multiline comments instead
public class FractionOperations {

    // Default Constructor but explicitly added
    public FractionOperations(){

    }


    /**
     * Adds two fractions and returns the result as a new Fraction object.
     *
     * @param fraction1 The first fraction, addend
     * @param fraction2 The second fraction, addend
     * @return The sum of the two fractions.
     */
    public Fraction add(Fraction fraction1, Fraction fraction2) {

        // Create an instance of the Fraction to store the resulting sum and return
        Fraction sumOfTwoFractions = new Fraction();


        // Set the denominator of the sumOfTwoFractions Fraction by multiplying the denominators
        sumOfTwoFractions.setDenominator(fraction1.getDenominator() * fraction2.getDenominator());


        // Set the numerator of the sumOfTwoFractions Fraction by cross multiplying and adding
        sumOfTwoFractions.setNumerator((fraction1.getNumerator() * fraction2.getDenominator()) +
                                        (fraction2.getNumerator() * fraction1.getDenominator()));


        // Reduce the fraction if possible
        reduceIfPossible(sumOfTwoFractions);

        return sumOfTwoFractions;
    }




    /**
     * Subtracts the first fraction to the second fraction and returns the result as a new Fraction Object
     *
     * @param fraction1 The first fraction, minuend
     * @param fraction2 The second fraction, subtrahend
     * @return Fraction -> The difference of the two fractions.
     */
    public Fraction subtract(Fraction fraction1, Fraction fraction2){

        // Create an instance of the Fraction to place the resulting difference and return
        Fraction differenceOfTwoFractions = new Fraction();


        // Set the numerator of the 'differenceOfTwoFractions' Fraction by Cross Multiply and Subtracting
        differenceOfTwoFractions.setNumerator((fraction1.getNumerator() * fraction2.getDenominator()) -
                                               fraction2.getNumerator() * fraction1.getDenominator());


        // Set the denominator of the 'differenceOfTwoFractions' Fraction by multiplying the denominators
        differenceOfTwoFractions.setDenominator(fraction1.getDenominator() * fraction2.getDenominator());


        // Reduce if possible
        reduceIfPossible(differenceOfTwoFractions);

        return differenceOfTwoFractions;
    }




    /**
     * Multiplies the two fractions and returns the product as a new Fraction Object
     *
     * @param fraction1 The first fraction, multiplicand
     * @param fraction2 The second fraction, multiplier
     * @return Fraction -> The product of the two fractions
     */
    public Fraction multiply(Fraction fraction1, Fraction fraction2){

        // Create an instance of the Fraction to place the resulting product and return
        Fraction productOfTwoFractions = new Fraction();


        // Set the numerator of the 'productOfTwoFractions' Fraction by multiplying the numerators
        productOfTwoFractions.setNumerator(fraction1.getNumerator() * fraction2.getNumerator());


        // Set the denominator of the 'productOfTwoFractions' Fraction by multiplying the denominators
        productOfTwoFractions.setDenominator(fraction1.getDenominator() * fraction2.getDenominator());

        // Reduce if possible
        reduceIfPossible(productOfTwoFractions);

        return productOfTwoFractions;
    }




    /**
     * Divides the first fraction by the second fraction and returns the result as a new Fraction object.
     *
     * @param fraction1 The first fraction (dividend).
     * @param fraction2 The second fraction (divisor).
     * @return The quotient of the two fractions.
     */
    public Fraction divide(Fraction fraction1, Fraction fraction2) {

        // Create an instance of the Fraction to store the resulting quotient and return
        Fraction quotientOfTwoFractions = new Fraction();


        // Set the numerator of the quotientOfTwoFractions Fraction by multiplying the numerator of the first fraction
        // by the denominator of the second fraction
        quotientOfTwoFractions.setNumerator(fraction1.getNumerator() * fraction2.getDenominator());


        // Set the denominator of the quotientOfTwoFractions Fraction by multiplying the denominators of the two fractions
        quotientOfTwoFractions.setDenominator(fraction1.getDenominator() * fraction2.getNumerator());


        // Reduce the fraction if possible
        reduceIfPossible(quotientOfTwoFractions);

        return quotientOfTwoFractions;
    }




    /**
     * Reduces the fraction to its simplest form
     *
     * @param fraction The fraction to be reduced
     */
    private void reduceIfPossible(Fraction fraction){
        // Get the positive / absolute value of the num and denom, because they might be negative
        int numerator = Math.abs(fraction.getNumerator());
        int denominator = Math.abs(fraction.getDenominator());


        findGreatestCommonFactor(Math.min(numerator, denominator), fraction);
    }




    /**
     *
     * start from the lowest , for example 30/50, start from 30 to 2 and check if it can divide both num and denom
     * if so, then that should be their greatest common factor
     * update the numerator and denominator, and return
     *
     * @param min the lower value between the numerator and denominator
     * @param fraction the fraction to be reduced
     */
    private void findGreatestCommonFactor(int min, Fraction fraction) {
        for(int i = min; i > 1; i--){
            if (fraction.getNumerator() % i == 0 && fraction.getDenominator() % i == 0){
                fraction.setNumerator(fraction.getNumerator() / i);
                fraction.setDenominator(fraction.getDenominator() / i);
                return;
            }
        }
    }
}
