import java.util.Scanner;

public class Pennies {
    public static void main(String args[]) {
Scanner keyboard = new Scanner(System.in); // create scanner 

System.out.println("Please enter the number of days worked: ");
int days = keyboard.nextInt(); // read user input

while (days < 1) //input validation for number of days worked
{
    System.out.println("ERROR: Please enter a number greater than 1 for days worked: ");
    days = keyboard.nextInt();
}

int pennies = 1;
int totalpennies = 0;

// output
System.out.println("Day\tPennies");
System.out.println("-------------------------------");
for (int i = 1; i <= days; i++)
{
    pennies = pennies * 2; // double number of pennies
    System.out.println(i + "\t" + pennies); 
    totalpennies += pennies;
}

System.out.println("Total Salary: $" + totalpennies / 100);
    }
}