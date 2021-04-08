import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXParseException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;

public class SAXParserDemo {

  public static void main(String[] args) {
    InputStream input = Main.class.getResourceAsStream("/book.xml");
    SAXParserFactory spf = SAXParserFactory.newInstance();
    SAXParser saxParser = null;
    try {
      saxParser = spf.newSAXParser();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    }
    //        saxParser.parse(input, new MyHandler());
  }
}

class MyHandler extends DefaultHandler {

  public void startDocument() {
    print("start document");
  }

  public void endDocument() {
    print("end document");
  }

  public void startElement(
    String uri,
    String localName,
    String qName,
    Attributes attributes
  ) {
    print("start element:", localName, qName);
  }

  public void endElement(String uri, String localName, String qName) {
    print("end element:", localName, qName);
  }

  public void characters(char[] ch, int start, int length) {
    print("characters:", new String(ch, start, length));
  }

  public void error(SAXParseException e) {
    print("error:", e);
  }

  void print(Object... objs) {
    for (Object obj : objs) {
      System.out.print(obj);
      System.out.print(" ");
    }
    System.out.println();
  }
}
