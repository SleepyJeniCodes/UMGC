// Import
import java.util.*;
import java.io.*;

//Declare file name
public class Final_Q2 
{
  public static void main(String[]args) 
    throws FileNotFoundException{

Scanner keyboard = new Scanner(System.in); // create scanner 

//read user input
System.out.println("Please enter a file containing a FASTA sequence: ");
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

// initialize dictionary
Map<String,Integer> codon_dict = new HashMap<String,Integer>();

//put() method
codon_dict.put("ATT", 0);
codon_dict.put("ATC", 0);
codon_dict.put("ATA", 0);
codon_dict.put("CTT", 0);
codon_dict.put("CTC", 0);
codon_dict.put("CTA", 0);
codon_dict.put("CTG", 0);
codon_dict.put("TTA", 0);
codon_dict.put("TTG", 0);
codon_dict.put("GTT", 0);
codon_dict.put("GTC", 0);
codon_dict.put("GTA", 0);
codon_dict.put("GTG", 0);
codon_dict.put("TTT", 0);
codon_dict.put("TTC", 0);
codon_dict.put("ATG", 0);
codon_dict.put("TGT", 0);
codon_dict.put("TGC", 0);
codon_dict.put("GCT", 0);
codon_dict.put("GCC", 0);
codon_dict.put("GCA", 0);
codon_dict.put("GCG", 0);
codon_dict.put("GGT", 0);
codon_dict.put("GGC", 0);
codon_dict.put("GGA", 0);
codon_dict.put("GGG", 0);
codon_dict.put("CCT", 0);
codon_dict.put("CCC", 0);
codon_dict.put("CCA", 0);
codon_dict.put("CCG", 0);
codon_dict.put("ACT", 0);
codon_dict.put("ACC", 0);
codon_dict.put("ACA", 0);
codon_dict.put("ACG", 0);
codon_dict.put("TCT", 0);
codon_dict.put("TCC", 0);
codon_dict.put("TCA", 0);
codon_dict.put("TCG", 0);
codon_dict.put("AGT", 0);
codon_dict.put("AGC", 0);
codon_dict.put("TAT", 0);
codon_dict.put("TAC", 0);
codon_dict.put("TGG", 0);
codon_dict.put("CAA", 0);
codon_dict.put("CAG", 0);
codon_dict.put("AAT", 0);
codon_dict.put("AAC", 0);
codon_dict.put("CAT", 0);
codon_dict.put("CAC", 0);
codon_dict.put("GAA", 0);
codon_dict.put("GAG", 0);
codon_dict.put("GAT", 0);
codon_dict.put("GAC", 0);
codon_dict.put("AAA", 0);
codon_dict.put("AAG", 0);
codon_dict.put("CGT", 0);
codon_dict.put("CGC", 0);
codon_dict.put("CGA", 0);
codon_dict.put("CGG", 0);
codon_dict.put("AGA", 0);
codon_dict.put("AGG", 0);
codon_dict.put("TAA", 0);
codon_dict.put("TAG", 0);
codon_dict.put("TGA", 0);

for(int i = 0; i < seq.length()-2; i++)
{
 int codon = i + 3;
 String key = seq.substring(i, codon);
 int count = codon_dict.containsKey(key) ? codon_dict.get(key):0;
 codon_dict.put(key, count + 1);
}
 int total = 0;
                                                                                                                         
    for(Map.Entry<String, Integer> entry : codon_dict.entrySet())
    {
   int value = entry.getValue();
   total += value;
    }
    for(Map.Entry<String, Integer> entry : codon_dict.entrySet())
    {
   double value = entry.getValue();
   String key = entry.getKey();
   double back_frq = (100*value)/total;
   System.out.println(key + ":" + back_frq);
    }
  }
}
  
  