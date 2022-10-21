import java.util.Scanner;
import java.io.*;

public class inverseDNA 
{
  public static void main(String[]args){

Scanner keyboard = new Scanner(System.in); // create scanner 

//read user input
System.out.println("Please enter the first DNA sequence: ");
String dna1 = keyboard.nextLine().toUpperCase();
System.out.println("Please enter the second DNA sequence: ");
String dna2 = keyboard.nextLine().toUpperCase(); 

String out = ""; 

for (int i = dna2.length() - 1; i >= 0; i--)
{
  if (dna2.charAt(i) == 'A')
    out += 'T';
  else if
    (dna2.charAt(i) == 'T')
    out += 'A';
  else if (dna2.charAt(i) == 'G')
    out += 'C';
  else
    out += 'G';
}

if (dna1.equals(out))
  System.out.println("The 2 given DNA are reverse complements of one another");
else
  System.out.println("The 2 given DNA are NOT reverse complements of one another");
  }
}