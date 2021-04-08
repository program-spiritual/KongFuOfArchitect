class Animal {}

class Mammal extends Animal {}

class Reptile extends Animal {}

public class AnimalDemo extends Mammal {

  public static void main(String args[]) {
    Animal a = new Animal();
    Mammal m = new Mammal();
    AnimalDemo d = new AnimalDemo();

    System.out.println(m instanceof Animal);
    System.out.println(d instanceof Mammal);
    System.out.println(d instanceof Animal);
  }
}
