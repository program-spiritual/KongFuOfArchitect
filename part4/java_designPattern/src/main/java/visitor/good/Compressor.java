package visitor.good;

public class Compressor implements Visitor {
    public void compress(PPTFile pptFile) {
        //...
        System.out.println("Compress PPT.");
    }

    public void compress(PdfFile pdfFile) {
        //...
        System.out.println("Compress PDF.");
    }

    public void compress(WordFile wordFile) {
        //...
        System.out.println("Compress WORD.");
    }

    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("Compress PDF.");
    }

    @Override
    public void visit(PPTFile pptFile) {
        System.out.println("Compress PPT.");
    }

    @Override
    public void visit(WordFile wordFile) {
        System.out.println("Compress WORD.");
    }
}
