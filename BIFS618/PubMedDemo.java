// Import
import java.util.Scanner;
import java.io.*;

public class PubMedDemo {
  
public static void main(String args[]) {
    
    PubMed user_PubMed = new PubMed ("Genetic Structure of the purebred domestic dog", 
                                     "Parker et al.,", "Science", 304);
    
    System.out.println("The title of the PubMed Article is: " + user_PubMed.getTitle());
    System.out.println("The author is: " + user_PubMed.getAuthor());
    System.out.println("The article is in: " + user_PubMed.getJournal());
    System.out.println("The volume is: " + user_PubMed.getVolume());
                       
    
    
}
}