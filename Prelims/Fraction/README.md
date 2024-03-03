# Fraction Arithmetic Program Documentation

This Java program allows users to perform arithmetic operations on fractions. It supports addition, subtraction, multiplication, and division of fractions, as well as reducing fractions to their simplest form.

## Overview

The Fraction Arithmetic program provides a user-friendly interface for performing arithmetic operations on fractions. It includes a menu-driven system where users can choose the desired operation and input fractions. The program then performs the operation and displays the result.

## Table of Contents

- [Getting Started](#getting-started)
- [Usage](#usage)
- [Features](#features)
- [Documentation](#Fraction-Arithmetic-Program-Documentation)
- [Contributing](#contributing)

## Getting Started

To run this program, make sure you have Java installed on your system. You can compile and run the program using any Java IDE or command-line tools.

### Prerequisites

- Java Development Kit (JDK) installed

### Installation

1. Clone this repository to your local machine:
   git clone https://github.com/Hendrizzzz/fraction-arithmetic.git
   
2. Navigate to the project directory:
  cd fraction-arithmetic

3. Compile the Java files:
  javac FractionArithmetic.java Fraction.java



## Usage

To use the program, follow these steps:

1. Run the compiled Java program:
   
2. Follow the on-screen instructions to choose an arithmetic operation and input fractions.

3. The program will display the result of the chosen operation.

4. You can choose to reduce a fraction, display the menu again, or quit the program.

## Features

- **Fraction Arithmetic:** Supports addition, subtraction, multiplication, and division of fractions.
- **Fraction Reduction:** Allows reducing fractions to their simplest form.
- **User-friendly Interface:** Provides a menu-driven system for selecting operations.
- **Error Handling:** Handles invalid input and prevents division by zero.


# Fraction Arithmetic Program Documentation

This Java program allows users to perform arithmetic operations on fractions. It consists of two main classes: `FractionArithmetic` and `Fraction`.

## FractionArithmetic Class

The `FractionArithmetic` class contains the main method and is responsible for handling user input, displaying the menu, and performing arithmetic operations on fractions.

### Methods

- `main(String[] args)`: The entry point of the program. It initializes the `FractionArithmetic` object and runs the program loop.

- `run()`: Runs the fraction arithmetic program. It displays the menu, reads user input, and performs the selected operation.

- `getUserChoice()`: Prompts the user for their choice and validates the input.

- `operate(int choice)`: Performs arithmetic operations on fractions based on user choice.

- `displayMenu()`: Displays the menu options for the user.

## Fraction Class

The `Fraction` class represents a fraction and provides methods for setting numerator and denominator, performing arithmetic operations, and reducing fractions to their simplest form.

### Methods

- `setNumerator(int numerator)`: Sets the numerator of the fraction.

- `setDenominator(int denominator)`: Sets the denominator of the fraction.

- `getNumerator()`: Retrieves the numerator of the fraction.

- `getDenominator()`: Retrieves the denominator of the fraction.

- `add(Fraction anotherFraction)`: Adds another fraction to this fraction.

- `subtract(Fraction anotherFraction)`: Subtracts another fraction from this fraction.

- `multiplyBy(Fraction anotherFraction)`: Multiplies this fraction by another fraction.

- `divideBy(Fraction anotherFraction)`: Divides this fraction by another fraction.

- `reduce()`: Reduces the fraction to its simplest form.

## Contributing

Contributions are welcome! If you have any suggestions, bug reports, or feature requests, please open an issue or submit a pull request.


