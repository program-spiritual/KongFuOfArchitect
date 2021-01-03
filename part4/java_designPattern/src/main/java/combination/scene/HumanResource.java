package combination.scene;
// HumanResource 是部门类（Department）和员工类（Employee）抽象出来的父类，为的是能统一薪资的处理逻辑
public abstract class HumanResource {
    protected long id;
    protected double salary;


    public HumanResource(long id) {
        this.id = id;

    }

    public long getId() {
        return id;
    }

    public abstract double calculateSalary();
}
