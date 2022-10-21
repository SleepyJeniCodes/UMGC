// Midterm #8
import java.util.Scanner;

public class DistanceTraveled {
    public static void main(String args[]) {
Scanner keyboard = new Scanner(System.in); // create scanner 

System.out.println("Please enter the speed of a vehicle (in mph): ");
double speed = keyboard.nextDouble(); // read user input

while (speed < 0) //input validation for speed
{
    System.out.println("ERROR: Please enter a positive number for speed: ");
    speed = keyboard.nextDouble();
}

System.out.println("Please enter the number of hours it has traveled");
int time = keyboard.nextInt();

while (time < 1) //input validation for time
{
    System.out.println("ERROR: Please enter a value that is 1 or greater for time traveled: ");
    time = keyboard.nextInt();
}


// output
System.out.println("Hours\tDistance");
System.out.println("-------------------------------");
for (int i = 1; i <= time; i++)
{
    double distance = speed * i;
    System.out.println(i + "\t" + distance);
}

    }
}