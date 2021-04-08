package io.file;

import java.io.File;

//File对象既可以表示文件，也可以表示目录。
//特别要注意的是，构造一个File对象，即使传入的文件或目录不存在，代码也不会出错，
//因为构造一个File对象，并不会导致任何磁盘操作。
//只有当我们调用File对象的某些方法的时候，才真正进行磁盘操作。
public class FileAndDirectory {

  public static void main(String[] args) {
    File f1 = new File("C:\\Windows");
    File f2 = new File("C:\\Windows\\notepad.exe");
    File f3 = new File("C:\\Windows\\nothing");
    System.out.println(f1.isFile());
    System.out.println(f1.isDirectory());
    System.out.println(f2.isFile());
    System.out.println(f2.isDirectory());
    System.out.println(f3.isFile());
    System.out.println(f3.isDirectory());
  }
}
/**
 * 判断文件的权限和大小：
 *
 * boolean canRead()：是否可读；
 * boolean canWrite()：是否可写；
 * boolean canExecute()：是否可执行；
 * long length()：文件字节大小。
 *
 *
 * */
