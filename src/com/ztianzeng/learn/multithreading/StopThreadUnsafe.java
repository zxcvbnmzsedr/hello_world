package com.ztianzeng.learn.multithreading;

/**
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-04-08 14:12
 */
public class StopThreadUnsafe {
    public static User u = new User();


    public static class User {
        private Integer id;

        private String name;

        public User() {
            id = 0;
            name = "0";
        }

        public Integer getId() {
            return id;
        }

        public User setId(Integer id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public User setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public String toString() {
            return "User{ id=" + id + ", name='" + name + '\'' + '}';
        }
    }

    public static class ChangeObjectThread extends Thread {
        volatile boolean stopme = false;

        public void stopMe() {
            stopme = true;
        }

        @Override
        public void run() {
            while (true) {
                if (stopme) {
                    System.out.println("exit by stop me");
                    break;
                }
                // 用户信息加锁
                synchronized (u) {
                    int v = (int) (System.currentTimeMillis() / 1000);
                    u.setId(v);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    u.setName(String.valueOf(v));
                }
                Thread.yield();
            }

        }
    }

    public static class ReadObjectThread extends Thread {

        @Override
        public void run() {
            while (true) {
                synchronized (u) {
                    if (u.getId() != Integer.parseInt(u.getName())) {
                        System.out.println(u.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReadObjectThread().start();

        while (true) {
            ChangeObjectThread thread = new ChangeObjectThread();
            thread.start();
            Thread.sleep(150);
            thread.stopMe();
        }
    }
}