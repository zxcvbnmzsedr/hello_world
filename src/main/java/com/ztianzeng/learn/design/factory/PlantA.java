package com.ztianzeng.learn.design.factory;

public class PlantA implements Plant {
    public PlantA() {
        System.out.println("create PlantA !");
    }

    public void doSomething() {
        System.out.println(" PlantA do something ...");
    }
}