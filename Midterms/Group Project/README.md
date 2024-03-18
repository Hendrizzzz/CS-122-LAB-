# Fraction Calculator

## Overview

The Fraction Calculator application provides functionality for performing arithmetic operations on fractions and mixed fractions. It includes both a console-based version, FractionTester, and a graphical user interface (GUI) version, FractionCalculatorGUI.

## Console-Based Fraction Tester

### Class Structure

The `FractionTester` class consists of methods and functionalities to handle user input, perform arithmetic operations, and display results.

#### Main Method
- `main(String[] args)`: Entry point of the program. Creates a `FractionTester` object and invokes the `run()` method.

#### Run Method
- `run()`: Main logic of the program. Continuously prompts the user for input and performs operations based on user choices.

#### Operation Methods
- `operate(int operation, int typeOfFractions)`: Performs arithmetic operations on fractions.
- `performFractionOperation(T first, U second, int operation)`: Performs specified operations on two fractions.
- `reduce(int typeOfFraction)`: Reduces fractions to their simplest form.

#### Input Methods
- `readTypeOfFraction()`: Reads the type of fraction to reduce from user input.
- `readTypeOfFractions()`: Reads types of fractions involved in an operation from user input.
- `readOperation()`: Reads the operation to perform from user input.
- `readMenuOption(int max)`: Reads a menu option from user input.
- `readInteger(String promptMessage)`: Reads an integer value from user input.

#### Display Methods
- `displayResult(Fraction firstFraction, Fraction secondFraction, Fraction resultingFraction, String operation)`: Displays arithmetic operation results.
- `displayResult(MixedFraction fraction, MixedFraction result)`: Displays reduced fraction results.

### Classes

- **Fraction**: Represents a fraction with numerator and denominator.
- **MixedFraction**: Extends Fraction to handle mixed fractions.
- **FractionCalculatorGUI**: GUI version for fraction calculations.

## Graphical User Interface (GUI)

### FractionCalculatorGUI

Provides a GUI for performing fraction calculations, including reducing fractions and performing arithmetic operations.

#### Constructor
- `FractionCalculatorGUI()`: Constructs the GUI interface for fraction calculations.

#### Dependencies
- Java Swing for GUI components.
- Java AWT for layout management and event handling.

![Fraction Calculator GUI](https://github.com/Hendrizzzz/CS-122-LAB-/assets/139997209/bd4f0fb8-d6a6-4a65-8c0b-546b109437fc)

## Dependencies

- Java Development Kit (JDK) installed on the system.

## Usage

1. Compile the `FractionTester.java` file using a Java compiler.
2. Run the compiled program using the Java interpreter.
3. Follow on-screen instructions to choose the desired operation and input fractions.

## Note

- `FractionTester` operates in the console and does not have a GUI.
- The GUI version, `FractionCalculatorGUI`, provides a more interactive user experience.
