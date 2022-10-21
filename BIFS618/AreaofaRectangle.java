import  java.util.Scanner;

public class AreaofaRectangle {
  
  public static void main(String args[]) {
    
    double length = getLength();
    double width = getWidth();
    double area = getArea(length, width);
    displayArea(length, width, area);
    
  }
  
  public static double getLength() {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please enter the length of the rectangle: ");
    double length = keyboard.nextDouble();
    return length;
  }
  
  public static double getWidth() {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please enter the width of the rectangle: ");
    double width = keyboard.nextDouble();
    return width; 
  }
  
  public static double getArea(double length, double width) {
    double area = length * width;
    return area;
  }
  
  public static void displayArea(double length, double width, double area) {
    System.out.println("The length of the rectangle is: \t" + length);
    System.out.println("The width of the rectangle is: \t" + width);
    System.out.println("The area of the rectangle is: \t" + area);
  }
}



