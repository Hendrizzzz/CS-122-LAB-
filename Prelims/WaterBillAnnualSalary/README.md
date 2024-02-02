# SURNAME Water Bill Annual Summary

The `SURNAMEWaterBillAnnualSummary` program is designed to help users summarize and analyze their water bills for an entire year. Users are prompted to enter water meter readings at the start and end of each month, and the program calculates monthly consumption and amount due based on user input.

## Usage

1. Run the program.
2. Enter the name of the water consumer.
3. Choose the type of consumer (Residential or Commercial).
4. Enter the water meter readings at the beginning and end of each month.

## Features

- Supports both Residential and Commercial consumers.
- Calculates monthly consumption and amount due.
- Provides an annual summary with average monthly readings and payments.
- Identifies the month with the lowest and highest water consumption.

## Getting Started

Compile and run the program using a Java compiler. Follow the on-screen prompts to enter the required information.

## Algorithm Overview

The program employs various algorithms for user input validation, calculating amounts due, and finding extreme values.

## Documentation

1. **showIntroduction():**
   - Provides an introduction to the program, explaining its purpose and usage.

2. **readTypeOfConsumer(Scanner scanner):**
   - Reads and validates the type of consumer (Residential or Commercial) from user input.

3. **readStartReading(Scanner scanner):**
   - Reads and validates the water meter reading at the beginning of the year.

4. **readEndOfMonthReading(int previousReading, int index, Scanner scanner):**
   - Reads and validates the water meter reading at the end of each month.

5. **computeAmountDue(int nCMUsed, char cType, int min1, double minB1, int min2, double minB2, float rate1, float rate2):**
   - Computes the amount due based on the number of cubic meters used and consumer type.

6. **showSummary(String n, char t, int[] previous, int[] present, int[] c, double[] amount):**
   - Displays the annual water bill summary, including monthly readings, consumption, and amounts paid.

7. **computeAverage(double[] values):**
   - Computes and returns the average of an array of floating-point numbers.

8. **computeAverage(int[] values):**
   - Computes and returns the average of an array of integers.

9. **findLowest(int[] values):**
   - Finds and returns the index of the element with the lowest value in an array of integers.

10. **findHighest(int[] values):**
    - Finds and returns the index of the element with the highest value in an array of integers.

11. **monthInWord(int m):**
    - Converts a numerical month value to its corresponding word representation.


