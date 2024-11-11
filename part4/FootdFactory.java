public class FoodFactory {  
  
  public static Food makeFood(String name) {  
      if (name.equals("noodle")) {  
          Food noodle = new LanZhouNoodle();  
          noodle.addSpicy("more");  
          return noodle;  
      } else if (name.equals("chicken")) {  
          Food chicken = new HuangMenChicken();  
          chicken.addCondiment("potato");  
          return chicken;  
      } else {  
          return null;  
      }  
  }  
}  