public class CharAndStringDemo5 {

  public static void main(String[] args) {
    //        从Java 13开始，字符串可以用"""..."""表示多行字符串（Text Blocks）了。举个例子：
    String s =
      """
                   SELECT * FROM
                     users
                   WHERE id > 100
                   ORDER BY name DESC
                   """;
    System.out.println(s);
    //        上述多行字符串实际上是5行，在最后一个DESC后面还有一个\n。如果我们不想在字符串末尾加一个\n，就需要这么写：
    String s2 =
      """ 
           SELECT * FROM
             users
           WHERE id > 100
           ORDER BY name DESC""";
    //        由于多行字符串是作为Java 13的预览特性（Preview Language Features）实现的，编译的时候，我们还需要给编译器加上参数：
    //
    //        javac --source 13 --enable-preview Main.java
  }
}
