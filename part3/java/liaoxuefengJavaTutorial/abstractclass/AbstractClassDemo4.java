package abstractclass;

public class AbstractClassDemo4 {

  public static double totalTax(Income2[] incomes) {
    double total = 0;
    for (Income2 income : incomes) {
      total = total + income.getTax();
    }
    return total;
  }

  public static void main(String[] args) {
    Income2 s1 = new SalaryDefault(3000);
    Income2 s2 = new Salary3(7500);
    Income2 s3 = new StateCouncilSpecialAllowance2(15000);
    Income2[] incomes = new Income2[] { s1, s2, s3 };
    System.out.println(totalTax(incomes));
  }
}

//假设我们定义一种收入，需要给它报税，那么先定义一个Income类：
abstract class Income2 {

  protected double income;

  public Income2(double income) {
    this.income = income;
  }

  public abstract double getTax();
}

// 默认税收
class SalaryDefault extends Income2 {

  public SalaryDefault(double income) {
    super(income);
  }

  @Override
  public double getTax() {
    return income * 0.1; // 税率10%
  }
}

//对于工资收入，可以减去一个基数，那么我们可以从Income派生出SalaryIncome，并覆写getTax()：

class Salary3 extends Income2 {

  public Salary3(double income) {
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

class StateCouncilSpecialAllowance2 extends Income2 {

  public StateCouncilSpecialAllowance2(double income) {
    super(income);
  }

  @Override
  public double getTax() {
    return 0;
  }
}
