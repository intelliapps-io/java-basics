import java.util.Scanner;
import java.util.Random;

public class arrayRandom2D_JM {
    private static boolean inputValidator(int input) {
        return input >= 0 && input <= 9;
    }

    private static void log(String msg) {
        System.out.println(msg);
    }


    private static int getIntInput(String errorMessage) {
        Scanner keyboard = new Scanner(System.in);
        int parsedInput = 0;
        boolean inputValidated = false;
        do {
            String input = keyboard.nextLine();
            try {
                parsedInput = Integer.parseInt(input);
                if (inputValidator(parsedInput))
                    inputValidated = true;
                else
                    throw new Exception("");
            } catch (Exception error) {
                log("\nError, " + input + " is invalid.\n" + errorMessage);
            }
        } while (!inputValidated);
        keyboard.close();
        return parsedInput;
    }

    private static int[] getUniqueRandomInts(int arraySize) {
        Random rng = new Random();
        int bound = (arraySize * arraySize);
        int[] numbersList = new int[arraySize * arraySize];

        for (int i = 0; i < numbersList.length; i++) {
            boolean isUnique;
            do {
                isUnique = true; // default to true
                numbersList[i] = rng.nextInt(bound) + 1; // generate random int

                // check if is unique
                for (int j = 0; j < i; j++)
                    if (numbersList[j] == numbersList[i])
                        isUnique = false;

            } while (!isUnique);
        }

        return numbersList;
    }

    private static void printArray(int[][] array) {
        String printString = "\n";
        for (int rowIndex = 0; rowIndex < array.length; rowIndex++) {
            String printRow = "";
            for (int colIndex = 0; colIndex < array[rowIndex].length; colIndex++) 
                printRow += ((colIndex == 0 ? "" : "\t") + array[rowIndex][colIndex]);
            printString += printRow + "\n";
        }
        log(printString);
    }

    public static void main(String[] args) {
        String userMessage = "Please input a whole number between 0 and 9";

        // Get Input
        log(userMessage);
        int arraySize = getIntInput(userMessage);

        // Initialize 2D Array
        int[][] array = new int[arraySize][arraySize];

        // Get and assign random numbers
        int[] randomNumbers = getUniqueRandomInts(arraySize);
        int randIndex = 0;
        for (int rowIndex = 0; rowIndex < array.length; rowIndex++)
            for (int colIndex = 0; colIndex < array[rowIndex].length; colIndex++) {
                array[rowIndex][colIndex] = randomNumbers[randIndex];
                randIndex ++;
            }

        // Print array to console
        printArray(array);
    }
}