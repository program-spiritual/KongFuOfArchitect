package unittest.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Fixture的套路如下：
//
//对于实例变量，在@BeforeEach中初始化，在@AfterEach中清理，它们在各个@Test方法中互不影响，因为是不同的实例；
//
//对于静态变量，在@BeforeAll中初始化，在@AfterAll中清理，它们在各个@Test方法中均是唯一实例，会影响各个@Test方法。
//
//大多数情况下，使用@BeforeEach和@AfterEach就足够了。只有某些测试资源初始化耗费时间太长，以至于我们不得不尽量“复用”时才会用到@BeforeAll和@AfterAll。
//
//最后，注意到每次运行一个@Test方法前，JUnit首先创建一个XxxTest实例，因此，每个@Test方法内部的成员变量都是独立的，不能也无法把成员变量的状态从一个@Test方法带到另一个@Test方法。
public class CalculatorTest {

  Calculator calculator;

  @BeforeEach
  public void setUp() {
    this.calculator = new Calculator();
  }

  @AfterEach
  public void tearDown() {
    this.calculator = null;
  }

  @Test
  void testAdd() {
    Assertions.assertEquals(100, this.calculator.add(100));
    Assertions.assertEquals(150, this.calculator.add(50));
    Assertions.assertEquals(130, this.calculator.add(-20));
  }

  @Test
  void testSub() {
    Assertions.assertEquals(-100, this.calculator.sub(100));
    Assertions.assertEquals(-150, this.calculator.sub(50));
    Assertions.assertEquals(-130, this.calculator.sub(-20));
  }
}
