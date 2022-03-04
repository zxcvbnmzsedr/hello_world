package com.ztianzeng.learn.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
    public MyClassLoader() {
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = loadClassData(name);

        return this.defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String clsName) {
        byte[] data = null;
        InputStream in;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        clsName = clsName.replaceAll("\\.", "/");
        try (out) {
            in = new FileInputStream("classes/" + clsName + ".class");
            int a;
            while ((a = in.read()) != -1) {
                out.write(a);
            }
            data = out.toByteArray();
        } catch (Exception e) {

        }
        return data;
    }
}
