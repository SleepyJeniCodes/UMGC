// Midterm #2
import java.util.Scanner;
import java.io.*;

public class coding 
{
  public static void main(String[]args) 
  throws FileNotFoundException, IOException
  {
File file = new File("genomic_dna.txt");
Scanner myFile = new Scanner(file);
String dna = myFile.nextLine();

File coding = new File("coding.txt");
FileWriter codingWriter = new FileWriter("coding.txt");
coding.createNewFile();
codingWriter.write(dna.substring(0,63));
codingWriter.write(dna.substring(90));
codingWriter.close();

Scanner newFile = new Scanner(coding);
String codingDna = newFile.nextLine();
double percentage = Double.valueOf(codingDna.length())/Double.valueOf(dna.length()) * 100;
System.out.println("The percentage of the dna that is coding is "+ percentage + "%");




    }
}