public class CarDemo {
  
public static void main(String args[]) {
    
    Car user_car = new Car (2020, "Toyota", 20);
    
    System.out.println("The year model of the car is: " + user_car.getYearModel());
    System.out.println("The car make is: " + user_car.getMake());
    
    for (int i = 0; i < 5; i++) {
      user_car.getAccelerate();
      System.out.println("The car's accelerated speed is: " + user_car.getSpeed());
    }
    
    for (int i = 0; i < 5; i++) {
      user_car.getBrake();
      System.out.println("The car's brake speed is: " + user_car.getSpeed()); 
    }
}
}

