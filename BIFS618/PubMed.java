public class PubMed {
  
  private String title;
  private String author;
  private String journal;
  private int volume;
  
  public PubMed(String title, String author, String journal, int volume) 
  {
    this.title = title;
    this.author = author;
    this.journal = journal;
    this.volume = volume;
  }
  
     public String getTitle()
  {
    return title;
  }
   public String getAuthor()
  {
    return author;
  }
   public String getJournal()
   {
     return journal;
   }
   public int getVolume()
  {
    return volume;
   }
}