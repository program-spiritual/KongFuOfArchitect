package adapter.compatible;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

public class Collections {
    public static Enumeration emumeration(final Collection c) {
        return new Enumeration() {
            Iterator i = c.iterator();

            @Override
            public boolean hasMoreElements() {
                return false;
            }

            public Object nextElement() {
                return i.next();
            }
        };
    }
}
