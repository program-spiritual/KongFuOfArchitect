public class FoodFactoryV2 {

}
public interface FoodFactoryInterface {
  Food makeFood(String name);  
}  
  Food makeFood(String name);  
}  

public class ChineseFoodFactoryV2 implements FoodFactoryInterface {  
  
  @Override  
  public Food makeFood(String name) {  
      if (name.equals("A")) {  
          return new ChineseFoodA();  
      } else if (name.equals("B")) {  
          return new ChineseFoodB();  
      } else {  
          return null;  
      }  
  }  
}  


public class AmericanFoodFactory implements FoodFactoryInterface {  
  
  @Override  
  public Food makeFood(String name) {  
      if (name.equals("A")) {  
          return new AmericanFoodA();  
      } else if (name.equals("B")) {  
          return new AmericanFoodB();  
      } else {  
          return null;  
      }  
  }  
}  