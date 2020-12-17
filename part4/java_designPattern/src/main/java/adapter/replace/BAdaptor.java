package adapter.replace;

public class BAdaptor implements IA{
    private final B b;

    public BAdaptor(B b) {
        this.b = b;
    }

    @Override
    public void fa() {
        b.fb();
    }
}
