package prog2.samcis.slu;

import java.io.*;
import java.util.Scanner;

public class TextDisplayer {
    public static void main(String[] args) {
        TextDisplayer program ;
        try{
            program = new TextDisplayer();
            program.run();
        }

        // if the file is not found
        catch (FileNotFoundException e) {
            System.out.println("File is not found. ");
        }

        // Since the readline method of the BufferedReader throws IOException and IOException is a checked exception,
        // we need to handle it, thus throwing it here
        catch (IOException e){
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        // for other possible exceptions
        catch (Exception e){
            e.printStackTrace();
        }

        // terminate the program
        finally{
            System.exit(0);
        }
    }

    private void run() throws IOException {
        File file = new File("samplefile1.txt"); // file to be read
        Scanner keyboard = new Scanner(System.in);
        BufferedReader fileReader = new BufferedReader(new FileReader(file));

        int counter = 0;
        String line;

        while((line = fileReader.readLine()) != null){ // read the file until the line is null
            System.out.println("line " + ++counter + " : " + line);

            // Prompt the user to press enter to continue reading the next line
            System.out.println("Press enter to continue...");
            keyboard.nextLine();
        }

        // Close the BufferedReader
        fileReader.close();
    } // end of the run method

}
