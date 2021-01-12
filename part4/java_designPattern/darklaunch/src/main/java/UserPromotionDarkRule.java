public class UserPromotionDarkRule implements IDarkFeature{
    @Override
    public boolean enabled() {
        return true;
    }

    @Override
    public boolean dark(long darkTarget) {
        return false;
    }

    @Override
    public boolean dark(String darkTarget) {
        return false;
    }
}
