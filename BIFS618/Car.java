public class Car {
  
  private int yearModel;
  private String make;
  private int speed; 
  
  public Car() {
    speed = 0;
  }
  
  public Car (int yearModel, String make, int speed)
  {
    this.yearModel = yearModel;
    this.make = make;
    this.speed = speed;
  }
    public int getYearModel()
  {
    return yearModel;
  }
   public String getMake()
  {
    return make;
  }
   public int getSpeed()
  {
    return speed;
  }
   public void getAccelerate() {
     this.speed = this.speed + 5;
   }
   public void getBrake() {
     this.speed = this.speed - 5;
   }
}