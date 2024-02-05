package CS122Exercises.OperationsOnFractions;

public class FractionOperations {

    // Default Constructor but explicitly added
    public FractionOperations(){

    }


    public Fraction add(Fraction fraction1, Fraction fraction2){
        // Create an instance of the Fraction to place the resulting sum and return
        Fraction sumOfTwoFractions = new Fraction();


        /*
         * Set the denominator of the 'sumOfTwoFractions' Fraction
         * Basically just multiply the two denominators
         * */
        sumOfTwoFractions.setDenominator(fraction1.getDenominator() * fraction2.getDenominator());


        /*
         * Set the numerator of the 'sumOfTwoFractions' Fraction
         * Cross Multiply and Add
         */
        sumOfTwoFractions.setNumerator((fraction1.getNumerator() * fraction2.getDenominator()) +
                                        fraction2.getNumerator() * fraction1.getDenominator());

        // Reduce if possible
        reduceIfPossible(sumOfTwoFractions);

        return sumOfTwoFractions;
    }




    public Fraction subtract(Fraction fraction1, Fraction fraction2){
        // Create an instance of the Fraction to place the resulting difference and return
        Fraction differenceOfTwoFractions = new Fraction();


        /*
         * Set the numerator of the 'differenceOfTwoFractions' Fraction
         * Cross Multiply and Subtract
         */
        differenceOfTwoFractions.setNumerator((fraction1.getNumerator() * fraction2.getDenominator()) -
                                               fraction2.getNumerator() * fraction1.getDenominator());


        /*
         * Set the denominator of the 'differenceOfTwoFractions' Fraction
         * Basically just multiply the two denominators
         * */
        differenceOfTwoFractions.setDenominator(fraction1.getDenominator() * fraction2.getDenominator());


        // Reduce if possible
        reduceIfPossible(differenceOfTwoFractions);

        return differenceOfTwoFractions;
    }


    public Fraction multiply(Fraction fraction1, Fraction fraction2){
        // Create an instance of the Fraction to place the resulting product and return
        Fraction productOfTwoFractions = new Fraction();

        /*
         * Set the numerator of the 'productOfTwoFractions' Fraction
         * Basically just multiply the two numerators
         * */
        productOfTwoFractions.setNumerator(fraction1.getNumerator() * fraction2.getNumerator());


        /*
         * Set the denominator of the 'productOfTwoFractions' Fraction
         * Basically just multiply the two denominators
         * */
        productOfTwoFractions.setDenominator(fraction1.getDenominator() * fraction2.getDenominator());

        // Reduce if possible
        reduceIfPossible(productOfTwoFractions);

        return productOfTwoFractions;
    }



    public Fraction divide(Fraction fraction1, Fraction fraction2){
        // Create an instance of the Fraction to place the resulting difference and return
        Fraction quotientOfTwoFractions = new Fraction();

        /*
         * Set the numerator of the 'quotientOfTwoFractions' Fraction
         * Basically just multiply the numerator of the first fraction to the denominator of the second fraction
         * Interchange the values of the numerator and denominator of the second fraction then just do straight multiplication
         * */
        quotientOfTwoFractions.setNumerator(fraction1.getNumerator() * fraction2.getDenominator());


        /*
         * Set the denominator of the 'quotientOfTwoFractions' Fraction
         * Basically just multiply the two denominators
         * */
        quotientOfTwoFractions.setDenominator(fraction1.getDenominator() * fraction2.getNumerator());

        // Reduce if possible
        reduceIfPossible(quotientOfTwoFractions);

        return quotientOfTwoFractions;
    }


    private void reduceIfPossible(Fraction fraction){
        int numerator = Math.abs(fraction.getNumerator());
        int denominator = Math.abs(fraction.getDenominator());
        for(int i = Math.min(numerator, denominator); i > 1; i--){
            if (fraction.getNumerator() % i == 0 && fraction.getDenominator() % i == 0){
                fraction.setNumerator(fraction.getNumerator() / i);
                fraction.setDenominator(fraction.getDenominator() / i);
                break;
            }
        }
    }
}
