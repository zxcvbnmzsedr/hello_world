package com.ztianzeng.learn.design.factory;

//具体产品FruitA，FruitB
public class FruitA implements Fruit {
    public FruitA() {
        System.out.println("create FruitA !");
    }

    public void doSomething() {
        System.out.println(" FruitA do something ...");
    }
}