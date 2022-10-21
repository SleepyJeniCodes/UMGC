public class Final_Q5 {
  
  public static void main(String args[]) {
    
    int[] array = {1,2,3,3,8,8,8,8,11,11,11,14,19,19};
    
    int duplicates = countDuplicates(array);
    System.out.println("There are a total of " + duplicates + " duplicates");
  }
  
  public static int countDuplicates(int[] array) {
    int count = 0;
    
    for (int i = 0; i < array.length - 1; i++)
    {
      if (array[i] == array[i+1])
        count ++;
    }
    return count; 
  }
}




