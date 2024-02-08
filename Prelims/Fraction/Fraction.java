package CS122Exercises.OperationsOnFractions.Version1;

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

    // Setter method for numerator
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    // Setter method for denominator
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

    // Getter method for numerator
    public int getNumerator() {
        return numerator;
    }

    // Getter method for denominator
    public int getDenominator() {
        return denominator;
    }

    /**
     * Method for converting fraction to its decimal form
     * Only return the 3 decimal places better output view, though less accurate
     * wow my first javadoc comment
     * @return double
     */
    public double toDecimal(){
        double decimal =  (double) getNumerator() / getDenominator();
        String decimalString =  String.format("%.3f", decimal);
        return Double.parseDouble(decimalString);
    }

    // Built-in method but I don't want its pre-made format
    @Override
    public String toString() {
        if (numerator == 0 || denominator == 1) return String.valueOf(numerator);
        else if (denominator == 0) return "undefined"; // for division
        return getNumerator() + VINCULUM + getDenominator();
    }
}
