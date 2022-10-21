import java.util.*;

public class Final_Q4 {
  
    public static void main(String args[]) {
    
    int[] array = {11, 5, 7, 12, -3, 4, 2, 19};
   
    System.out.println(Arrays.toString(subArray(array, 2, 4)));
  }
  
  public static int[] subArray(int arr[], int start, int length) {
      int[] newarray = new int[length];
      int x = 0;
      
      for (int i = start; i < start + length;i++) {
             newarray[x++] = arr[i];
           }
      return newarray;
    }
  }


  
  



