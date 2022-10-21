//Midterm #3
import java.util.Scanner;
import java.io.*;

public class fasta 
{
  public static void main(String[]args) 
  throws FileNotFoundException, IOException
  {
File file = new File("sequences.txt");
Scanner myFile = new Scanner(file);

File file2 = new File("AccessionNumbers.txt");
Scanner myFile2 = new Scanner(file2);

for (int i = 0; i < 3; i++)
{
  String sequences = myFile.nextLine();
  String accessions = myFile2.nextLine();
  File access = new File(accessions+".txt");
  FileWriter accessWriter = new FileWriter(accessions+".txt");
  access.createNewFile();
  accessWriter.write(">" + accessions + "\n");
  accessWriter.write(sequences.replaceAll("[^A-Za-z0-9]","").toUpperCase());
  accessWriter.close();
}
  }
}
  

