package com.ztianzeng.learn.juc;

import net.openhft.affinity.Affinity;
import net.openhft.affinity.AffinityLock;
import net.openhft.affinity.AffinityStrategies;
import net.openhft.affinity.AffinitySupport;
import org.junit.Test;

public class CpuAffinity {

    public static void main(String[] args) {
        try (AffinityLock al = AffinityLock.acquireLock(2)) {
            // do some work while locked to a CPU.
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    int cpu = Affinity.getCpu();
                    System.out.println(cpu);
                    System.out.printf("Thread-%d locked", Thread.currentThread().getId());
                    try {
                        Thread.sleep(1000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
    }
}
