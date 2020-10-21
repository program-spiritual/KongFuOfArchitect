package conCurrentTool;


import java.util.concurrent.atomic.AtomicInteger;

public class AtomIntegerCase {


    private static final jdk.internal.misc.Unsafe U = jdk.internal.misc.Unsafe.getUnsafe();
    private static final long VALUE = U.objectFieldOffset(AtomicInteger.class, "value");
    private volatile int value;


    public final int getAndIncrement() {
//        Unsafe 会利用 value 字段的内存地址偏移，直接完成操作
        return U.getAndAddInt(this, VALUE, 1);
    }
}
