package CS122Exercises.OperationsOnFractions;

public class Fraction {
    private int numerator;
    private int denominator;
    private final String VINCULUM = "/";

    // Default constructor
    public Fraction(){

    }

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

        // Check if the denominator is 0 and the numerator is positive, place the negative sign on the numerator for better readability on output
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

    @Override
    public String toString() {
        return getNumerator() + VINCULUM + getDenominator();
    }
}
