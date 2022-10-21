// Midterm # 7
import java.util.Scanner;

public class AreaofRectangle {
    public static void main(String args[]) {
Scanner keyboard = new Scanner(System.in); // create scanner 

// get user input for Rectangle 1 
System.out.println("Please enter the length of Rectangle 1: ");
double length1 = keyboard.nextDouble(); // read user input
System.out.println("Please enter the width of Rectangle 1: ");
double width1 = keyboard.nextDouble(); // read user input

// get user input for Rectangle 2 
System.out.println("Please enter the length of Rectangle 2: ");
double length2 = keyboard.nextDouble(); // read user input
System.out.println("Please enter the width of Rectangle 2: ");
double width2 = keyboard.nextDouble(); // read user input

// Area of Rectangle 1
double area1 = length1 * width1;

// Area of Rectangle 2
double area2 = length2 * width2;

if (area1 > area2)
    System.out.println("The area of Rectangle 1 is greater than Rectangle 2");
else
    System.out.println("The area of Rectangle 2 is greater than Rectangle 1");

    }
}