package com.ztianzeng.learn.design.factory;

public class PlantB implements Plant {
    public PlantB() {
        System.out.println("create PlantB !");
    }

    public void doSomething() {
        System.out.println(" PlantB do something ...");
    }
}