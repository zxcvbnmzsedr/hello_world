package com.ztianzeng.learn.jvm;

public class TestDynamicLoad {
    static {
        System.out.println("*************load TestDynamicLoad************");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        new A();
        System.out.println("*************load test************");
        // B不会加载，除非这里执行 new B()
        B b = null;
        ClassLoader loader = TestDynamicLoad.class.getClassLoader();
        System.out.println(loader);
        //使用ClassLoader.loadClass()来加载类，不会执行初始化块 
        loader.loadClass("com.ztianzeng.learn.jvm.Test2");
        //使用Class.forName()来加载类，默认会执行初始化块 
        Class.forName("com.ztianzeng.learn.jvm.Test2");
        //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块 
      Class.forName("com.ztianzeng.learn.jvm.Test2", false, loader);
    }
}

class Test2 {
    static {
        System.out.println("静态初始化块执行了！");
    }
}

class A {
    static {
        System.out.println("*************load A************");
    }

    public A() {
        System.out.println("*************initial A************");
    }
}

class B {
    static {
        System.out.println("*************load B************");
    }

    public B() {
        System.out.println("*************initial B************");
    }
}
