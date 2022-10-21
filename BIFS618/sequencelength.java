import  java.util.Scanner;

public class sequencelength {
  
  public static void main(String args[]) {
    
    Scanner keyboard = new Scanner(System.in); 
    System.out.println("Please enter the number of sequences: "); //user input
    int number = keyboard.nextInt();
    
    int[] seq = new int[number];
    
    // store in array
    for (int i = 0; i < number; i++) {
     System.out.println("Please enter the lengths of each sequences: ");
     int length = keyboard.nextInt();
     seq[i] = length;
    }
    
    // sum of array
    double total = 0;
    for (int x = 0; x < number; x++) {
      total += seq[x];
    }
    
    // average
    double average = total / number;
    
    System.out.println("The total is: " + total);
    System.out.println("The average is: " + average);
    
    // greater than average
    for (int i = 0; i < number; i++)
      if (seq[i] > average)
      System.out.print("The number above the average is: " + seq[i]);

  }
}

