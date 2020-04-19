public class PolymorphismDemo3 {
//    因为所有的class最终都继承自Object，而Object定义了几个重要的方法：
//
//toString()：把instance输出为String；
//equals()：判断两个instance是否逻辑相等；
//hashCode()：计算一个instance的哈希值。
//在必要的情况下，我们可以覆写Object的这几个方法。例如：
    public static void main(String[] args) {

    }
}

class Person12{
    protected String name;
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        // 当且仅当o为Person类型:
        if (obj instanceof Person12) {
            Person12 p = (Person12) obj;
            // 并且name字段相同时，返回true:
            return this.name.equals(p.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Person12:name=" + name;
    }
}