package com.ztianzeng.learn.design.factory;

public class FruitB implements Fruit {
    public FruitB() {
        System.out.println("create FruitB !");
    }

    public void doSomething() {
        System.out.println(" FruitB do something ...");
    }
}