module hello.world {
  exports com.itranswarp.sample ;
  requires java.base; // 可不写，任何模块都会自动引入java.base
  requires java.xml;
  requires java.desktop;
}
