// Midterm #3
import java.util.Scanner;
import java.io.*;

public class file2 
{
  public static void main(String[]args) 
  throws FileNotFoundException, IOException
  {
File file = new File("file2.txt");
Scanner myFile = new Scanner(file);
int average = Integer.parseInt(myFile.nextLine());
int below = 0;

while (myFile.hasNext()){
  int grade = Integer.parseInt(myFile.next());
  if (grade < average)
    below++;
}
System.out.println("The number of grades below average is: " + below);
  }
}

