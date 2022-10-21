
// Import
import java.util.Scanner;
import java.io.*;

//Declare file name
public class DNASequenceDemo 
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
    
    System.out.print("Please enter the SeqID of the file: ");
    String SeqID = keyboard.next();
    
    System.out.print("Please enter the DNA Type: ");
    String Type = keyboard.next();
    
    System.out.print("Please enter the topology of the DNA: ");
    String Topology = keyboard.next();
    
    DNASequence dna = new DNASequence(SeqID, seq, Type, Topology);
    
    System.out.println("The sequence in reverse is: " + dna.getReverse());
    System.out.println("The complement of the sequence is: " + dna.getComplement());
    System.out.println("The reverse complement of the sequence is: " + dna.getReverseComplement());
    System.out.println("The GC content of the sequence is: " + dna.getGCcontent());
    System.out.println("The RNA sequence is: " + dna.getRNASequence());
  }
}