package combination.scene;

import java.util.ArrayList;
import java.util.List;

public class Department extends HumanResource {
    private final List<HumanResource> subNodes = new ArrayList<>();

    public Department(long id, double salary) {
        super(id);
    }

    public Department(long organizationRootId) {
        super(organizationRootId);
    }

    @Override
    public double calculateSalary() {
        double totalSalary = 0;
        for (HumanResource hr :
                subNodes) {
            totalSalary += hr.calculateSalary();
        }
        this.salary = totalSalary;
        return totalSalary;
    }

    public void addSubNode(HumanResource hr) {
        subNodes.add(hr);
    }
}
