package com.ztianzeng.learn.design.factory;

//具体工厂方法
public class FactoryA implements AbstractFactory {
    public Plant createPlant() {
        return new PlantA();
    }

    public Fruit createFruit() {
        return new FruitA();
    }
}