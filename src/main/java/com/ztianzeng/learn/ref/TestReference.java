package com.ztianzeng.learn.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * @author zhaotianzeng
 * @date 2019/9/18 1:28 下午
 * @version V1.0
 */
public class TestReference {
    private Integer _10M = 1024 * 10;
    private Integer _1M = 1024;

    public static void main(String[] args) {
        TestReference t = new TestReference();
        t.testPhantomReference();
    }

    /**
     * 强引用的资源回收情况
     * 因为不会被GC,最终会引发OOM
     * ![](http://pic.ztianzeng.com/20190918151513.png)
     */
    public void testStrongReference() {
        ArrayList<byte[]> strongList = new ArrayList<>();
        try {
            while (true) {
                strongList.add(new byte[_1M]);
                Thread.sleep(2);
            }
        } catch (OutOfMemoryError | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 弱引用
     * 这种永远不会内存溢出，因为一旦发现了只具有弱引用的对象，GC时不管当前内存空间足够与否，都会回收它的内存
     * ![](http://pic.ztianzeng.com/20190918141112.png)
     */
    public void testWeakReference() {
        ArrayList<WeakReference<byte[]>> strongList = new ArrayList<>();
        try {
            while (true) {
                strongList.add(new WeakReference<>(new byte[_10M]));
            }
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }

    /**
     * 软引用，内存不足时回收
     * 这种永远不会内存溢出，因为一旦发现了只具有弱引用的对象，只有在当前内存空间不够了，才会回收它的内存
     * ![](http://pic.ztianzeng.com/20190918161245.png)
     */
    public void testSoftReference() {
        ArrayList<SoftReference<byte[]>> strongList = new ArrayList<>();
        try {
            while (true) {
                strongList.add(new SoftReference<>(new byte[_10M]));
            }
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }

    /**
     * 虚引用
     * 虚引用必须和引用队列联合使用。
     * 当垃圾回收器准备回收一个对象时，如果发现它还有虚引用，就会在回收对象的内存之前，把这个虚引用加入到与之关联的引用队列中。
     */
    public void testPhantomReference() {
        ArrayList<PhantomReference<byte[]>> strongList = new ArrayList<>();
        ReferenceQueue queue = new ReferenceQueue();
        System.out.println(queue.poll() == null);
        try {
            while (true) {
                strongList.add(new PhantomReference<>(new byte[_10M], queue));
            }
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        System.out.println(queue.poll() == null);
    }
}