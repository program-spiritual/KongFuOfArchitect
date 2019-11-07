public class Puppy2 {
    int puppyAge;
    public Puppy2(String name) {
        // This constructor has one parameter, name.
        System.out.println("Passed Name is :" + name );
    }

    public void setAge(int age) {
        puppyAge = age;
    }
    public int getAge() {
        return puppyAge;
    }
    public static void main(String []args) {
        /* Object creation */
        Puppy2 myPuppy = new Puppy2( "tommy" );

        /* Call class method to set puppy's age */
        myPuppy.setAge( 2 );

        /* Call another class method to get puppy's age */
        myPuppy.getAge( );

        /* You can access instance variable as follows as well */
        System.out.println("Variable Value :" + myPuppy.puppyAge );
    }
}