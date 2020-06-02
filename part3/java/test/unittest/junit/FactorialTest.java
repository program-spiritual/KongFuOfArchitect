package unittest.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Executable;

/**
 * 在编写单元测试的时候，我们要遵循一定的规范：
 * <p>
 * 一是单元测试代码本身必须非常简单，能一下看明白，决不能再为测试代码编写测试；
 * <p>
 * 二是每个单元测试应当互相独立，不依赖运行的顺序；
 * <p>
 * 三是测试时不但要覆盖常用测试用例，还要特别注意测试边界条件，例如输入为0，null，空字符串""等情况。
 */
public class FactorialTest {
    @Test
    public void testNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Factorial.fact(-1);
        });
    }
    @Test
    public void testFact() {
        Assert.assertEquals(1, Factorial.fact(1));
        Assert.assertEquals(2, Factorial.fact(2));
        Assert.assertEquals(6, Factorial.fact(3));
        Assert.assertEquals(3628800, Factorial.fact(10));
        Assert.assertEquals(2432902008176640000L, Factorial.fact(20));
    }
}
