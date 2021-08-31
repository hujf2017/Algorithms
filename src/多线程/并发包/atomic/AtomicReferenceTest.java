package 多线程.并发包.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Hujf
 * @title: AtomicReferenceTest
 * @date 2021-08-31 16:43
 * @description: AtomicReferenceTest
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        String initialReference = "the initially referenced string";
        AtomicReference atomicReference = new AtomicReference(initialReference);
        System.out.println("atomicStringReference.get() = " + atomicReference);
        atomicReference.set("test test test");
        System.out.println("atomicStringReference.get() = " + atomicReference);

        System.out.println(atomicReference.compareAndSet("", ""));


        AtomicReference<String> atomicStringReference =
                new AtomicReference<String>(initialReference);

        String newReference = "new value referenced";
        boolean exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged: " + exchanged);

        exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged: " + exchanged);

    }
}
