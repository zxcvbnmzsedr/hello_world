package com.ztianzeng.learn.jvm.classloader;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author zhaotianzeng
 */
public class ClassLoaderStudy {
    public static void main(String[] args) throws ClassNotFoundException {
        final ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        final ClassLoader platformClassLoader = appClassLoader.getParent();
        final ClassLoader bootClassLoader = appClassLoader.getParent();
        System.out.println("systemClassLoader == " + appClassLoader);
        System.out.println("systemClassLoader == " + bootClassLoader);

        String str = "hello class loader";
        System.out.println("str class loader is == " + str.getClass().getClassLoader());
        Class driver = Class.forName("java.sql.Driver");
        System.out.println("driver class loader is == " + driver.getClassLoader());
        System.out.println("driver class loader parent is == " + driver.getClassLoader().getParent());

        ClassLoaderStudy study = new ClassLoaderStudy();
        System.out.println("study class loader is == " + study.getClass().getClassLoader());
        System.out.println("study class loader parent is == " + study.getClass().getClassLoader().getParent());
        System.out.println("study class loader parent parent is == " + study.getClass().getClassLoader().getParent().getParent());

        Class jshell = Class.forName("jdk.jshell.JShell");
        System.out.println("jshell class loader is == " + jshell.getClassLoader());
        System.out.println("jshell class loader parent is == " + jshell.getClassLoader().getParent());

        MyClassLoader classLoader = new MyClassLoader();
        Class cls = classLoader.loadClass("com.ztianzeng.learn.jvm.classloader.MyClass");

        System.out.println("cls class loader is == " + cls.getClassLoader());
        System.out.println("cls class loader parent is == " + cls.getClassLoader().getParent());


        Class driverManager = Class.forName("java.sql.DriverManager");
        System.out.println("driverManager class loader is == " + driverManager.getClassLoader());
    }

}
