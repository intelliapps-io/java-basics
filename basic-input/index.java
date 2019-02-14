import java.util.Scanner;


public class index {
  public static void main(String[] args) {
    System.out.println("Enter a number!");

    int input; // Declare var

    Scanner keyboard = new Scanner(System.in); // Create instance of Scanner class
    input = keyboard.nextInt(); // Get user input

    keyboard.close();
    
    System.out.println("Your Number Is: " + input);
  }
}