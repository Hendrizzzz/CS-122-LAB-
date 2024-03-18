## Classes

### Fraction

Represents a fraction with a numerator and a denominator. This class provides methods for performing basic arithmetic operations and reducing fractions to their simplest form.

#### Constructors

- `Fraction()`: Constructs a Fraction object with default values (numerator = 0, denominator = 1).
- `Fraction(int numerator, int denominator)`: Constructs a Fraction object with the given numerator and denominator.

#### Methods

- `add(Fraction other)`: Adds another fraction to this fraction.
- `subtract(Fraction other)`: Subtracts another fraction from this fraction.
- `multiplyBy(Fraction other)`: Multiplies this fraction by another fraction.
- `divideBy(Fraction other)`: Divides this fraction by another fraction.
- `reduce()`: Reduces the fraction to its simplest form.
- `toDouble()`: Converts the fraction to a double value.
- `getNumerator()`: Returns the numerator of the fraction.
- `getDenominator()`: Returns the denominator of the fraction.

### MixedFraction

Extends the Fraction class to handle mixed fractions, which consist of a whole number part and a fractional part. This class provides methods for performing arithmetic operations with mixed fractions and converting between mixed fractions and improper fractions.

#### Constructors

- `MixedFraction()`: Constructs a MixedFraction object with default values (whole = 0, fraction part = 0/1).
- `MixedFraction(int whole, Fraction fraction)`: Constructs a MixedFraction object with the given whole number and fraction.
- `MixedFraction(int whole, int numerator, int denominator)`: Constructs a MixedFraction object with the given whole number, numerator, and denominator.
- `MixedFraction(Fraction fraction)`: Constructs a MixedFraction object from a Fraction object.

#### Methods

- `setWholePart(int whole)`: Sets the whole number part of the mixed fraction.
- `setFractionPart(Fraction fraction)`: Sets the fraction part of the mixed fraction.
- `getWhole()`: Retrieves the whole part of the mixed fraction.
- `getFractionPart()`: Retrieves the fractional part of the mixed fraction as a Fraction object.
- `toFraction()`: Converts the mixed fraction to an equivalent improper fraction.
- `add(MixedFraction other)`: Adds another mixed fraction to this mixed fraction.
- `subtract(MixedFraction other)`: Subtracts another mixed fraction from this mixed fraction.
- `multiplyBy(MixedFraction other)`: Multiplies this mixed fraction by another mixed fraction.
- `divideBy(MixedFraction other)`: Divides this mixed fraction by another mixed fraction.
- `simplify()`: Simplifies the mixed fraction, converting any improper fractions to mixed numbers if necessary.

### FractionCalculatorGUI

Provides a graphical user interface (GUI) for performing fraction calculations, including reducing fractions and performing arithmetic operations.


![image](https://github.com/Hendrizzzz/CS-122-LAB-/assets/139997209/bd4f0fb8-d6a6-4a65-8c0b-546b109437fc)



#### Constructor

- `FractionCalculatorGUI()`: Constructs the GUI interface for fraction calculations.

#### Methods

- `main(String[] args)`: Entry point for launching the GUI application.

## Dependencies

- Java Swing for the graphical user interface components.
- Java AWT for layout management and event handling.


## FractionTester 
- for console based. This application operates entirely in the console and does not have a graphical user interface (GUI).

## Class Structure

The `FractionTester` class consists of methods and functionalities to handle user input, perform arithmetic operations, and display results. Here's an overview of its structure:

- **Main Method**: The entry point of the program. Initializes the `FractionTester` object and invokes the `run()` method to start the application.

- **Run Method**: The main logic of the program. It continuously prompts the user for input and performs operations based on user choices until the user decides to quit.

- **Operation Methods**: Methods to perform arithmetic operations and reduce fractions to their simplest form.

- **Input Methods**: Methods to read user input, including fractions, operation choices, and menu options.

- **Display Methods**: Methods to format and display results in the console.

## Methods

### Main Method
- `main(String[] args)`: Entry point of the program. Creates a `FractionTester` object and invokes the `run()` method.

### Run Method
- `run()`: Main logic of the program. Continuously prompts the user for input and performs operations based on user choices.

### Operation Methods
- `operate(int operation, int typeOfFractions)`: Performs the specified arithmetic operation on the given types of fractions.
- `performFractionOperation(T first, U second, int operation)`: Performs the specified operation on two fractions.
- `reduce(int typeOfFraction)`: Reduces the given fraction to its simplest form.

### Input Methods
- `readTypeOfFraction()`: Reads the type of fraction to reduce from the user input.
- `readTypeOfFractions()`: Reads the types of fractions involved in an operation from the user input.
- `readOperation()`: Reads the operation to perform from the user input.
- `readMenuOption(int max)`: Reads a menu option from the user input.
- `readInteger(String promptMessage)`: Reads an integer value from the user input.

### Display Methods
- `displayResult(Fraction firstFraction, Fraction secondFraction, Fraction resultingFraction, String operation)`: Displays the result of a fraction arithmetic operation.
- `displayResult(MixedFraction fraction, MixedFraction result)`: Displays the result of reducing a fraction.




