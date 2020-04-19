public class PolymorphismDemo2 {
    public static void main(String[] args) {
//多态是指，针对某个类型的方法调用，其真正执行的方法取决于运行时期实际类型的方法。例如：
        Person11 p = new Student4();
        p.run(); // 无法确定运行时究竟调用哪个run()方法
        /*所以，多态的特性就是，运行期才能动态决定调用的子类方法。
        对某个类型调用某个方法，执行的实际方法可能是某个子类的覆写方法。这种不确定性的方法调用，究竟有什么作用？*/


        // 给一个有普通收入、工资收入和享受国务院特殊津贴的小伙伴算税:
        Income[] incomes = new Income[]{
                new Income(3000),
                new Salary2(7500),
                new StateCouncilSpecialAllowance(15000)
        };
        System.out.println(totalTax(incomes));
    }

    //观察totalTax()方法：利用多态，totalTax()方法只需要和Income打交道，
//它完全不需要知道Salary和StateCouncilSpecialAllowance的存在，
//就可以正确计算出总的税。
//如果我们要新增一种稿费收入，
//只需要从Income派生，然后正确覆写getTax()方法就可以。
//把新的类型传入totalTax()，不需要修改任何代码。
    public static double totalTax(Income... incomes) {
        double total = 0;
        for (Income income : incomes) {
            total = total + income.getTax();
        }
        return total;
    }

}

//假设我们定义一种收入，需要给它报税，那么先定义一个Income类：
class Income {
    protected double income;

    public Income(double income) {
        this.income = income;
    }

    public double getTax() {
        return income * 0.1; // 税率10%
    }
}

//对于工资收入，可以减去一个基数，那么我们可以从Income派生出SalaryIncome，并覆写getTax()：

class Salary2 extends Income {
    public Salary2(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (income <= 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}

//如果你享受国务院特殊津贴，那么按照规定，可以全部免税：

class StateCouncilSpecialAllowance extends Income {
    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return 0;
    }
}

//现在，我们要编写一个报税的财务软件，对于一个人的所有收入进行报税，可以这么写：