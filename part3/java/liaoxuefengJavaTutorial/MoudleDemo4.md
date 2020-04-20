访问权限
前面我们讲过，Java的class访问权限分为public、protected、private和默认的包访问权限。
引入模块后，这些访问权限的规则就要稍微做些调整。

确切地说，class的这些访问权限只在一个模块内有效，模块和模块之间，
例如，a模块要访问b模块的某个class，必要条件是b模块明确地导出了可以访问的包。

举个例子：
我们编写的模块hello.world用到了模块java.xml的一个类javax.xml.XMLConstants，
我们之所以能直接使用这个类，是因为模块java.xml的module-info.java中声明了若干导出：

module java.xml {
    exports java.xml;
    exports javax.xml.catalog;
    exports javax.xml.datatype;
    ...
}
只有它声明的导出的包，外部代码才被允许访问。
换句话说，如果外部代码想要访问我们的hello.world模块中的
com.itranswarp.sample.Greeting类，
我们必须将其导出：

```java

module hello.world {
    exports com.itranswarp.sample;

    requires java.base;
	requires java.xml;
}

```
因此，模块进一步隔离了代码的访问权限。