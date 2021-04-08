import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class Main {

  public static void main(String[] args) {
    InputStream input = Main.class.getResourceAsStream("/book.xml");
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = null;
    try {
      db = dbf.newDocumentBuilder();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }
    try {
      Document doc = db.parse(input);
      System.out.println(doc);
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  void printNode(Node n, int indent) {
    for (int i = 0; i < indent; i++) {
      System.out.print(' ');
    }
    switch (n.getNodeType()) {
      case Node.DOCUMENT_NODE: // Document节点
        System.out.println("Document: " + n.getNodeName());
        break;
      case Node.ELEMENT_NODE: // 元素节点
        System.out.println("Element: " + n.getNodeName());
        break;
      case Node.TEXT_NODE: // 文本
        System.out.println(
          "Text: " + n.getNodeName() + " = " + n.getNodeValue()
        );
        break;
      case Node.ATTRIBUTE_NODE: // 属性
        System.out.println(
          "Attr: " + n.getNodeName() + " = " + n.getNodeValue()
        );
        break;
      default: // 其他
        System.out.println(
          "NodeType: " + n.getNodeType() + ", NodeName: " + n.getNodeName()
        );
    }
    for (
      Node child = n.getFirstChild();
      child != null;
      child = child.getNextSibling()
    ) {
      printNode(child, indent + 1);
    }
  }
}
