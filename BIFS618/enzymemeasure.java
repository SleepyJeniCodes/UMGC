public class enzymemeasure {
  
  public static void main(String args[]) {
    
    double[] brain = {65, 69, 70, 63, 70, 68};
    double[] heart = {102, 95, 98, 110};
    double[] lung = {112, 115, 113, 109, 95, 98, 100};
    
    System.out.println("The number of measurements in the brain is: " + getCount(brain));
    System.out.println("The average enzyme activity in the brain is: " +  getAverage(brain));
    System.out.println("The maximum value in the brain is: " + getMax(brain));
    System.out.println("The minimum value in the brain is: " +  getMin(brain));
      
    System.out.println("The number of measurements in the heart is: " + getCount(heart));
    System.out.println("The average enzyme activity in the heart is: " + getAverage(heart));
    System.out.println("The maximum value in the heart is: " + getMax(heart));
    System.out.println("The minimum value in the heart is: " + getMin(heart));
    
    System.out.println("The number of measurements in the heart is: " + getCount(lung));
    System.out.println("The average enzyme activity in the lung is: " + getAverage(lung));
    System.out.println("The maximum value in the lung is: " + getMax(lung));
    System.out.println("The minimum value in the lung is: " + getMin(lung));
  }
  
  public static int getCount(double[] array) {
    int count = array.length;
    return count; 
  }
  
  public static double getAverage(double[] array) {
    double total = 0;
    for (int i = 0; i < array.length; i++) {
      total += array[i];
    }
    
    double average = total / array.length;
    return average; 
  }
  
  public static double getMin(double[] array) {
    double min = array[0];
    for (int i = 0; i < array.length; i++) {
      if (array[i] < min) {
        min = array[i];
      }
    }
    return min;
  }
  
  public static double getMax(double[] array) {
    double max = array[0];
    for (int i =0; i < array.length; i++) {
      if (array[i] > max)
        max = array[i];
    }
    return max;
  }
}




