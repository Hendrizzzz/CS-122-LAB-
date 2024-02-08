package CS122Exercises.OperationsOnFractions.Version2;

public class Fraction {
    private int numerator;
    private int denominator;
    private final String VINCULUM = "/";

    // Default constructor
    public Fraction(){

    }

    // * this is not used, it can be used but the driver/main class would need edit because it differs a lil bit in the program design/structure. I'm lazy to do that rn
    // Constructor with parameters
    public Fraction(int numerator, int denominator){
        // Check if the numerator is 0, then the fraction is simply 0;
        if(numerator == 0){
            this.denominator = 0;
            this.numerator = 0;
            return;
        }

        // Check if the fraction has both numerator and denominator negative, then the fraction is positive
        else if (numerator < 0 && denominator < 0){
            this.numerator = Math.abs(numerator);
            this.denominator = Math.abs(denominator);
            return;
        }

        // Check if the denominator is negative and the numerator is positive, place the negative sign on the numerator for better readability on output
        else if (denominator < 0){
            this.numerator = -numerator;
            this.denominator = Math.abs(denominator);
            return;
        }

        // Instantiate the attributes to the values passed
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Sets the numerator of the fraction to the specified value.
     *
     * @param numerator The numerator value to set.
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }


    /**
     * Setter the denominator of the fraction to the specified value.
     *
     * @param denominator The denominator value to set
     */

    public void setDenominator(int denominator) {
        // If the numerator and denominator is negative, then the fraction is positive
        if(getNumerator() < 0 && denominator < 0){
            setNumerator(-getNumerator());
            this.denominator = -denominator;
            return;
        }
        else if (denominator < 0 && getNumerator() > 0){
            setNumerator(-getNumerator());
            this.denominator = -denominator;
            return;
        }
        this.denominator = denominator;
    }


    /**
     * Retrieves the numerator of the fraction.
     *
     * @return The numerator value of the fraction.
     */
    public int getNumerator() {
        return numerator;
    }


    /**
     * Retrieves the denominator of the fraction
     *
     * @return The denominator value of the fraction
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Converts the fraction to its decimal form.
     * Returns the decimal value with three decimal places for better output view, though less accurate.
     *
     * @return The decimal form of the fraction with three decimal places.
     */
    public double toDecimal() {
        double decimal = (double) getNumerator() / getDenominator();
        String decimalString = String.format("%.3f", decimal);
        return Double.parseDouble(decimalString);
    }


    /**
     * Returns the string representation of the fraction.
     * If the denominator is 0, returns "undefined" (for division).
     * If the numerator is 0 or the denominator is 1, returns only the numerator.
     * Otherwise, returns the fraction in the format "numerator/denominator".
     *
     * @return The string representation of the fraction.
     */
    @Override
    public String toString() {
        if (numerator == 0 || denominator == 1) {
            return String.valueOf(numerator);
        } else if (denominator == 0) {
            return "undefined"; // for division
        }
        return getNumerator() + VINCULUM + getDenominator();
    }

}
