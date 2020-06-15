package multithreads.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 除了BlockingQueue外，针对List、Map、Set、Deque等，java.util.concurrent包也提供了对应的并发集合类。我们归纳一下：
 *
 * interface	non-thread-safe	thread-safe
 * List	ArrayList	CopyOnWriteArrayList
 * Map	HashMap	ConcurrentHashMap
 * Set	HashSet / TreeSet	CopyOnWriteArraySet
 * Queue	ArrayDeque / LinkedList	ArrayBlockingQueue / LinkedBlockingQueue
 * Deque	ArrayDeque / LinkedList	LinkedBlockingDeque
 *
 * */
public class Main {
    public static void main(String[] args) {
        Map unsafeMap = new HashMap();
        Map threadSafeMap = Collections.synchronizedMap(unsafeMap);
    }
}
