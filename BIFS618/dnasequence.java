public class DNASequence {
  
  private String SeqID;
  private String Sequence;
  private String Type;
  private String Topology;
  
  public DNASequence(String SeqID, String Sequence, String Type, String Topology) 
  {
    this.SeqID = SeqID;
    this.Sequence = Sequence;
    this.Type = Type;
    this.Topology = Topology;
  }
  
  public String getReverse() {
    String reverse = "";
  
    char ch;
  
    for (int i = 0; i < this.Sequence.length(); i++)
    {
      ch = reverse.charAt(i);
      reverse = ch+reverse;
    }
    return reverse;
  }
  public String getComplement() {    
    // Create a variable to store the compliment of dnaSequence.
    String complimentSequence = "";
    
    // Loop through each bp in the DNA sequence and get put its compliment into complimentSequence.
    for(int i = 0; i < this.Sequence.length(); i++)
    {
      // Add the compliment of each bp to the complimentSequence.
      if(this.Sequence.charAt(i) == 'A')
        complimentSequence += 'T';
      else if(this.Sequence.charAt(i) == 'T')
        complimentSequence += 'A';
      else if(this.Sequence.charAt(i) == 'G')
        complimentSequence += 'C';
      else
        complimentSequence += 'G';
    }
    
    return complimentSequence;
  }
    
  public String getReverseComplement() {
    String out = "";
    
    for (int i = this.Sequence.length() - 1; i >= 0; i--)
    {
      if (this.Sequence.charAt(i) == 'A')
        out += 'T';
      else if
        (this.Sequence.charAt(i) == 'T')
        out += 'A';
      else if (this.Sequence.charAt(i) == 'G')
        out += 'C';
      else
        out += 'G';
    }
    return out; 
  }
    
  public double getGCcontent() {
    double A = 0;
    double T = 0;
    double G = 0;
    double C = 0;
    double GC = 0;
    double total = 0;
    
    // Loop through each character in the line and check what value it is.
    for(int i = 0; i < this.Sequence.length(); i++)
    {
      // Add to the count of each bp.
      if(this.Sequence.charAt(i) == 'C')
        C++;
        else if(this.Sequence.charAt(i) == 'A')
          A++;
        else if(this.Sequence.charAt(i) == 'G')
          G++;
        else
          T++;
        
        // Add to the length of the total DNA sequence.
        total++;
    }
    
    GC = (G+C) * 100 / total;
    return GC;
    }
  public String getRNASequence() {
    String rna = "";
    
    // Loop through each bp in the DNA sequence and get put its compliment into complimentSequence.
    for(int i = 0; i < this.Sequence.length(); i++)
    {
      // Add the compliment of each bp to the complimentSequence.
      if(this.Sequence.charAt(i) == 'A')
        rna += 'U';
      else if(this.Sequence.charAt(i) == 'T')
        rna += 'A';
      else if(this.Sequence.charAt(i) == 'G')
        rna += 'C';
      else
        rna += 'G';
    }
    
      return rna;
  }
  
}
