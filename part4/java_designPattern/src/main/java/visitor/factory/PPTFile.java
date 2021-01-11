package visitor.factory;

public class PPTFile extends ResourceFile{


    public PPTFile(String filePath) {
        super(filePath);
    }

    @Override
    public ResourceFileType getType() {
        return null;
    }
}
