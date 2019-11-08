public class instanceVarableDemo {
    public String name;
    private double salary;
    public instanceVarableDemo(String epName) {
        name = epName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void printEmp() {
        System.out.println("name  : " + name );
        System.out.println("salary :" + salary);
    }

    public static void main(String[] args) {
        instanceVarableDemo empOne = new instanceVarableDemo("Ransika");
        empOne.setSalary(1000);
        empOne.printEmp();
    }
}
