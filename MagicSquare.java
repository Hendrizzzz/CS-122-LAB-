package CS122Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MagicSquare {
    public static void main(String[] args) {
        while(true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int size;

            try {
                size = getSize(bufferedReader);

                // Catches the exception and breaks the infinite loop
            } catch (NumberFormatException e){
                break; //Breaks the infinite loop (while loop)

                // Closes the reader
            } finally {
                try{
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("An error occurred while closing the reader. ");
                }
            }

            int[][] magicSquare = new int[size][size];
            populateMagicSquare(magicSquare, size);
            displayMagicSquare(magicSquare);
        }
        
    }

    private static void displayMagicSquare(int[][] magicSquare) {
        for(int[] row : magicSquare){ // Iterates each array of the 2d array
            for(int element : row){ // Iterates each element in an array
                if(element - 100 >= 0) System.out.print(element + " ");
                else if (element - 10 >= 0) System.out.print(" " + element + " ");
                else System.out.print(" " + element + "  ");
            }
            System.out.println(); // new line for new row
        }
    }

    private static int getSize(BufferedReader bufferedReader) throws NumberFormatException{
        do{
            try{
                // If non-integer is entered, it will throw an Exception back to the main method
                System.out.println("Enter any non-integer to quit. ");
                System.out.print("Size of Magic Square (Odd number): ");
                int size = Integer.parseInt(bufferedReader.readLine());
                if(size % 2 == 0 || size < 0){
                    System.out.println("Invalid input. Number must be an odd and positive. Please try again. ");
                    continue;
                }
                return size;
            } catch (IOException e){
                System.out.println("An error occurred while reading the input. Please try again. ");
            }
        } while (true);
    }

    private static void populateMagicSquare(int[][] magicSquare, int size){
        int row = 0;
        int column = size/2;
        for(int i = 1; i <= size * size; i++) {
            magicSquare[row][column] = i;
            row--;
            column++;
            if(row < 0) row += size;
            if(column > size - 1) column -= size;
            if (magicSquare[row][column] != 0){
                row += 2;
                column--;
                if(row > size - 1) row -= size;
                if(column < 0) column += size;
            }
        }
    }
}