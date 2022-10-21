import java.util.Scanner;

//Midterm #6
public class Quantity {
    public static void main(String args[]) {
Scanner keyboard = new Scanner(System.in); // create scanner 

System.out.println("Please enter the number of packages purchased: ");
int quantity = keyboard.nextInt(); // read user input

double discountper; //declare variable
discountper = 0; //initialize variable

// discounts per packages
if (quantity <= 9)
    System.out.println("Your purchase does not qualify for a discount");
else if (quantity <= 19)
    discountper = 0.20;
else if (quantity <= 49)
    discountper = 0.30;
else if (quantity <= 99)
    discountper = 0.40;
else
    discountper = 0.50;

System.out.println("You qualify for a " + discountper * 100 + "%");

double cost = quantity * 99;
double discount = cost * discountper;
double total = cost - discount;

System.out.println("Your total cost after your discount is $" + total);

    }
}