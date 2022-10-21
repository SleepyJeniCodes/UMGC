public class RectangleDemo {
  
public static void main(String args[]) {
    
    Rectangle r = new Rectangle (3, 7, 10, 12);
    
    System.out.println("The x-coordinate of the rectangle is: " + r.getX());
    System.out.println("The y-coordinate of the rectangle is: " + r.getY());
    System.out.println("The width of the rectangle is: " + r.getWidth());
    System.out.println("The height of the rectangle is: " + r.getHeight());
  }
}