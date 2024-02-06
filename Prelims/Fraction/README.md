# Fraction Operations Program
This Java program, with the Main class as the driver class, performs operations on fractions using the Fraction template for fractions and OperationsOnFractions template for the operations.

## Usage
1. Choose an operation from the menu.
2. Enter the numerators and denominators of two fractions when prompted.
3. The program will display the result of the chosen operation on the two fractions.
## Documentation
### Classes and Methods
#### `Fraction`
- `Fraction()`: Default constructor.
- `Fraction(int numerator, int denominator)`: Constructor with parameters.
- `setNumerator(int numerator)`: Setter method for the numerator.
- `setDenominator(int denominator)`: Setter method for the denominator.
- `getNumerator()`: Getter method for the numerator.
- `getDenominator()`: Getter method for the denominator.
- `toDecimal()`: Converts the fraction to its decimal form with three decimal places.
- `toString()`: Overrides the `toString()` method to return the fraction as a string.
#### `FractionOperations`
- `add(Fraction fraction1, Fraction fraction2)`: Adds two fractions.
- `subtract(Fraction fraction1, Fraction fraction2)`: Subtracts one fraction from another.
- `multiply(Fraction fraction1, Fraction fraction2)`: Multiplies two fractions.
- `divide(Fraction fraction1, Fraction fraction2)`: Divides one fraction by another.
### Examples
```java
// Create two fractions
Fraction fraction1 = new Fraction(1, 2);
Fraction fraction2 = new Fraction(3, 4);
// Perform addition
Fraction sum = operate.add(fraction1, fraction2);
System.out.println("Sum: " + sum);
// Perform subtraction
Fraction difference = operate.subtract(fraction1, fraction2);
System.out.println("Difference: " + difference);
// Perform multiplication
Fraction product = operate.multiply(fraction1, fraction2);
System.out.println("Product: " + product);
// Perform division
Fraction quotient = operate.divide(fraction1, fraction2);
System.out.println("Quotient: " + quotient);
