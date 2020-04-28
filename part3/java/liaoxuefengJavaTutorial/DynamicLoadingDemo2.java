import org.apache.commons.logging.LogFactory;

public class DynamicLoadingDemo2 {

    public static void main(String[] args) {
// Commons Logging优先使用Log4j:
        LogFactory factory = null;
        if (isClassPresent("org.apache.logging.log4j.Logger")) {
            factory = createLog4j();
        } else {
            factory = createJdkLog();
        }
    }

    private static LogFactory createJdkLog() {
        return null;
    }

    private static LogFactory createLog4j() {
        return null;

    }

    static boolean isClassPresent(String name) {
        try {
            Class.forName(name);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
