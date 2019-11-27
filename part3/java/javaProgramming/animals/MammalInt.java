package animals;

public class MammalInt  implements AnimalInterface{

    @Override
    public void eat() {
        System.out.println("Mammal eats");
    }

    @Override
    public void travel() {
        System.out.println("Mammal travels");
    }

    public int noOfLegs() {
        return 0;
    }

    public static void main(String args[]) {
        MammalInt m = new MammalInt();
        m.eat();
        m.travel();
    }
}
