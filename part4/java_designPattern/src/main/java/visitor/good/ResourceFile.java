package visitor.good;

public abstract class ResourceFile {
    protected String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }
    abstract public void accept(Extractor extractor);
    abstract public void accept(Compressor compressor);
    abstract public void accept(Visitor visitor);
}