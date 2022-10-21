// Import
import java.util.Scanner;
import java.io.*;

//Declare file name
public class Assignment4 
{
  public static void main(String[]args) 
    throws FileNotFoundException{
    
    // create key
    Scanner user = new Scanner(System.in);
    
    // ask user for file input
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Please enter file name containing DNA sequences: ");
    String DNAfile = keyboard.next();
    File file = new File(DNAfile);
    
     // Scan in the file
    Scanner input = new Scanner(file);
    
    // Create a variable to store the DNA Sequence.
    String seq = "";
    
    // Skip the first line.
    input.nextLine();
    
    while(input.hasNextLine()){  
      // Read in the line and store it as a variable.
      seq += input.nextLine();
    
    }
  }
  public static String getReverse(String dnaSequence) {
  String reverse = "";
  
  char ch;
  
  for (int i = 0; i < dnaSequence.length(); i++)
  {
    ch = reverse.charAt(i);
    reverse = ch+reverse;
  }
  return reverse;
  }
    public static String getComplement(String dnaSequence) {    
      // Create a variable to store the compliment of dnaSequence.
      String complimentSequence = "";
    
      // Loop through each bp in the DNA sequence and get put its compliment into complimentSequence.
      for(int i = 0; i < dnaSequence.length(); i++)
      {
        // Add the compliment of each bp to the complimentSequence.
        if(dnaSequence.charAt(i) == 'A')
          complimentSequence += 'T';
        else if(dnaSequence.charAt(i) == 'T')
          complimentSequence += 'A';
        else if(dnaSequence.charAt(i) == 'G')
          complimentSequence += 'C';
        else
          complimentSequence += 'G';
      }
    
      return complimentSequence;
    }
    
    public static String getReverseComplement(String dnaSequence) {
      String out = "";
      
      for (int i = dnaSequence.length() - 1; i >= 0; i--)
      {
        if (dnaSequence.charAt(i) == 'A')
          out += 'T';
        else if
          (dnaSequence.charAt(i) == 'T')
          out += 'A';
        else if (dnaSequence.charAt(i) == 'G')
          out += 'C';
        else
          out += 'G';
      }
      return out; 
    }
    
    public static double GCcontent(String dnaSequence) {
      double A = 0;
      double T = 0;
      double G = 0;
      double C = 0;
      double GC = 0;
      double total = 0;
 
      // Loop through each character in the line and check what value it is.
      for(int i = 0; i < dnaSequence.length(); i++)
      {
        // Add to the count of each bp.
        if(dnaSequence.charAt(i) == 'C')
          C++;
        else if(dnaSequence.charAt(i) == 'A')
          A++;
        else if(dnaSequence.charAt(i) == 'G')
          G++;
        else
          T++;
        
        // Add to the length of the total DNA sequence.
        total++;
      }
      
      GC = (G+C) * 100 / total;
      return GC;
    }
    public static String getRNASequence(String dnaSequence) {
      String rna = "";
    
      // Loop through each bp in the DNA sequence and get put its compliment into complimentSequence.
      for(int i = 0; i < dnaSequence.length(); i++)
      {
        // Add the compliment of each bp to the complimentSequence.
        if(dnaSequence.charAt(i) == 'A')
          rna += 'U';
        else if(dnaSequence.charAt(i) == 'T')
          rna += 'A';
        else if(dnaSequence.charAt(i) == 'G')
          rna += 'C';
        else
          rna += 'G';
      }
    
      return rna;
    }
    
}

    