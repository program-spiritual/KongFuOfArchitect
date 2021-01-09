package visitor.better;


public class PPTFile extends ResourceFile {
    public PPTFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Extractor extractor) {
        extractor.extract2txt(this);

    }

    @Override
    public void accept(Compressor compressor) {
        compressor.compress(this);
    }


}