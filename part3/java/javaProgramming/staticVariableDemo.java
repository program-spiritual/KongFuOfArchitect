public class staticVariableDemo {
    private static double salary;
    public static final String DEPARTMENT = "DEV";

    public static double getSalary() {
        return salary;
    }

    public static void setSalary(double salary) {
        staticVariableDemo.salary = salary;
    }

    public staticVariableDemo() {
    }
}
